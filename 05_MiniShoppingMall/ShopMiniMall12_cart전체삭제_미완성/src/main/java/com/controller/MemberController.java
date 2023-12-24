package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService mService;
	
	
	//회원가입화면 보기
	@GetMapping("/MemberUIServlet")
	public String memberUI() {
		return "memberForm";  // /WEB-INF/views/memberForm.jsp 
	}
	
	// id 중복체크

//	<dependency>
//    <groupId>com.fasterxml.jackson.core</groupId>
//    <artifactId>jackson-databind</artifactId>
//    <version>2.14.2</version>
//</dependency>		
	@GetMapping(value = "/MemberIdCheckServlet", produces = "text/plain;charset=utf-8")
	@ResponseBody  // jackson-bind 의존성 추가
	public String idCheck(@RequestParam String userid) {
		String mesg = "아이디 중복";
		MemberDTO dto = mService.idCheck(userid);
		if(dto == null) {
			mesg = "아이디 사용 가능";
		}
		return mesg;
	}
	
	//회원등록
	@PostMapping("/MemberAddServlet")
	public String memberAdd(MemberDTO dto) {
		System.out.println(dto);
		int n = mService.memberAdd(dto);
		return "redirect:main";
	}
	
	
	
	
	
}




