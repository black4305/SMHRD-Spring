package kr.cloud.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.cloud.web.entity.Board;
import kr.cloud.web.entity.SearchCriteria;
import kr.cloud.web.mapper.BoardMapper;


@Controller
public class MyController {

    @Autowired
    BoardMapper mapper;

    // log 찍는 도구 가져오기
    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/goInsert")
    public String goInsert() {
        return "boardInsert";
    }

    @PostMapping("/goInsert")
    public String goInsert(Board board, RedirectAttributes rttr) {
        mapper.goInsert(board);
        rttr.addAttribute("temp", 1);
        return "redirect:/";
    }

    @PostMapping("/")
    public String home(SearchCriteria criteria, Model model) {
        List<Board> boardList = mapper.search(criteria);
        model.addAttribute("boardList", boardList);
        return "Board";
    }

    @ResponseBody
    @GetMapping("/updatedBoard")
    public boolean updatedBoard(Board b) {
        logger.info("updateBoard에서 수집한 데이터 확인 >> " + b);

        // spring에서 비동기 통신을 통해 리턴값이 viewName이 아닌 데이터를 반환 시
        /*
         * 1) @ResponseBody 어노테이션 추가
         * 2) pom.xml에 jackson-databind 의존성 추가
         */
        int row = mapper.updateBoard(b.getIdx());

        return row > 0 ? true : false;
    }
    
    @GetMapping("/goBoardContent/{idx}")
    public String goBoardContent(@PathVariable int idx, Model model) {
        /*
         * @PathVariable("data")
         * - 경로 자체에 데이터를 포함시켰을 때, 해당하는 데이터를 수집하는 방법
         * 매핑{변수명} -> 매개변수의 변수명과 일치 필요!
         */

        logger.info("pathVariable을 통해 수집한 데이터 >> " + idx);

        // 1. mapper의 메서드 goBoardContent를 이용하여 idx가 일치하는 데이터 가져오기
        Board result = mapper.goBoardContent(idx);

        // 2. model에 데이터를 담아서 boardContent로 이동
        model.addAttribute("result", result);

        return "boardContent";
    }

    // 기능 단위로 메서드 생성
    @GetMapping("/") // SpringBoot에서는 requestMaping 사용 X
    public String home(Model model) {

        // DB에 접속해서 전체 게시글 조회하는 메서드
        List<Board> boardList = mapper.selectAll();
        model.addAttribute("boardList", boardList);

        return "Board";
    }
}