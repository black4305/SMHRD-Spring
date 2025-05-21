package com.smhrd.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

	//페이지 요청 -> 메서드의 리턴값을 viewname 요청
	
	// 기능 단위로 메서드 작성!!
	// @RequestMapping ()안에 작성된 url로 요청시,
	//  -> 아래의 메서드 실행
	@RequestMapping("/board")
	public String board() {
		// viewname 작성 시, 파일명 대소문자 구분해서
		//  동일하게 작성해야한다!!
		return "Board";
		// Web-inf/views/Board.jsp --> viewResolver
	}
	
}
