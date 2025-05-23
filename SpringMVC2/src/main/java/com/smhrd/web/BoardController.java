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

	@RequestMapping("/boardDelete")
	public String boardDelete(@RequestParam int idx, Model model) {

		// 인터페이스 mapper의 boardDelete 메서드를 활용해서 DB에 접근하여 게시글 삭제 쿼리 실행
		mapper.boardDelete(idx);

		// return viewName 하면 board.jsp로 단순 이동
		// board.jsp + 전체 게시글 조회한 데이터가 모델에 담기는 로직 --> /boardlist로 url 요청 필요!
		return "redirect:/boardlist";
	}

	@GetMapping("boardSelect")
	public String boardSelect(@RequestParam int idx, Model model) {

		// 1. DB에서 수집한 데이터 idx와 동일한 idx를 가진 게시글 1개 조회
		BoardVO vo = mapper.boardSelect(idx);
 
		// 2. 조회한 게시글 정보를 model에 담아주기
		model.addAttribute("vo", vo);

		// scope : 데이터가 유효한 범위 -> 정해진 범위 내에서만 사용 가능!
		// scope 종류 : application > session > request > page
		// page scope : 실제 선언된 JSP 페이지 내에서만 사용 가능
		// request scope : 클라이언트로부터 요청을 받고 응답할 때까지 사용 가능
		// session scope : 세션이 유지되는 동안 사용 가능
		// application scope : 웹 어플리케이션(server)이 시작되고 종료될 때까지 사용 가능
		return "boardSelect";
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

	@GetMapping("/boardUpdate")
	public String getMethodName(@RequestParam int idx, Model model) {
		BoardVO vo = mapper.boardSelect(idx);
		model.addAttribute("vo", vo);
		return "boardUpdate";
	}
	
	@PostMapping("/boardUpdate")
	public String boardUpdate(BoardVO vo) {
		mapper.boardUpdate(vo);
		return "redirect:/boardlist";
	}
}
