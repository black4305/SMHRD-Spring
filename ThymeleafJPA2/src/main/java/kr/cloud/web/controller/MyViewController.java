package kr.cloud.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyViewController {
	// 단순 페이지 이동을 하는 코드를 모아놓은 컨트롤러
	
	@GetMapping("/main")
	public String goMain() {
		return "main";
	}
	
	@GetMapping("/join")
	public String goJoin() {
		return "join";
	}
	//Persistence : 영속성 
	// (일시적인 메모리가 아니라 지속적으로 데이터를 저장할 수 있는 공간 DB에 보관하는 것!
	
	@GetMapping("/")
	public String goLogin(Model model) {
		// 타임리프 
		//  - 템플릿 엔진의 한 종류
		//  - 서버에서 데이터를 받아 웹 페이지(HTML)상에 데이터를 넣어 보여주는 도구
		//    * request영역에서만 데이터를 가지고 올 수 있음.
		//      - model : request(scope)의 경량화된 버전
		// 1. 임의의 데이터 2개 생성
		String name= "서보경";
		List<String> list = new ArrayList<>();
		list.add("일보경");
		list.add("이보경");
		list.add("삼보경");
		list.add("사보경");
		model.addAttribute("name", name);
		model.addAttribute("list", list);
		return "login";
	}
	
	
}
