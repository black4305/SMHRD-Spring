package com.smhrd.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smhrd.database.BoardMapper;
import com.smhrd.model.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardMapper mapper; 
	// spring에서 제공하는 기능 : 자동으로 연결해준다.
	// (인터페이스는 객체 생성 불가) -> @autoWired
	//페이지 요청 -> 메서드의 리턴값을 viewname 요청
	
	// 기능 단위로 메서드 작성!!
	// @RequestMapping ()안에 작성된 url로 요청시,
	//  -> 아래의 메서드 실행
	@GetMapping("boardSelect")
	public String boardSelect(@RequestParam int idx) {
		return "";
	}
	
	// 글쓰기 버튼 클릭 -> register.jsp 이동하기 위한 매핑
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	// register.jsp에서 form 태그를 통해 3가지 데이터를 받아와 처리하는 메서드
	@PostMapping("/register2")
	public String register(BoardVO vo) {
		System.out.println("수집된 데이터 : " + vo);
		int cnt = mapper.register(vo);
		
		if(cnt > 0) {
			System.out.println("게시글 등록 성공");
		}
		else {
			System.out.println("게시글 등록 실패");
		}
		return "redirect:/boardlist";
	}
	
	// 전체 게시글 조회하는 메서드!!
	@RequestMapping("/boardlist") // get,post 방식 모두 가능!
	public String boardList(Model model) {
		// 1. DB에서 데이터 조회하기
		// DB쿼리의 결과값을 BoardVO 자료형으로 list에 담기
		List<BoardVO> list=mapper.boardList();
		// 2. 조회한 결과를 model에 담아주기
		// model -> Spring에서 제공하는 데이터를 담을 수 있는 공간
		model.addAttribute("list", list);
		// viewname 작성 시, 파일명 대소문자 구분해서
		//  동일하게 작성해야한다!!
		return "Board";
		// Web-inf/views/Board.jsp --> viewResolver
	}
	
}
