package kr.cloud.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import kr.cloud.web.entity.CloudMember;
import kr.cloud.web.repo.CloudMemberRepository;

@Controller
public class MyController {
	// DB에 접근하는 코드 위주의 컨트롤러
	@Autowired
	private CloudMemberRepository repository;
	
	@PostMapping("/login-process")
	public String loginProcess(HttpSession session ,CloudMember member) {
		CloudMember loginMember =repository.findByUseridAndUserpw
		 (member.getUserid(), member.getUserpw());
		session.setAttribute("member", loginMember);
		// Model에 담은 데이터는 리다이렉트 방식으로 이동할 경우
		// -> 유지되지 않는다.
		// session 이용(브라우저가 켜져있는 경우에 유지된다.)
		return "redirect:/main";
	}

	@PostMapping("/join-process")
	public String joinProcess(CloudMember member) {
		
		repository.save(member);

		// forward방식 : 페이지 이동해도 동일한 URL
		//  --> 새로고침하면 동일 URL요청을 하게 된다.
		//  * 회원가입의 경우, 중복회원가입 발생
		// redirect방식 : 페이지 이동하면 URL 변경됨
		
		return "redirect:/";
	}
	
}
