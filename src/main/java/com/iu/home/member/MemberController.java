package com.iu.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "memberJoin")
	public String memberJoin() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("ID5");
		memberDTO.setPw("PW5");
		memberDTO.setName("NAME5");
		memberDTO.setPhone("0105635");
		memberDTO.setEmail("@naver");
		memberDTO.setAddress("ADDRESS5");
		
		int result = memberService.memberJoin(memberDTO);
		
		if(result == 1) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		
		return "member/memberJoin";
	}
	
	@RequestMapping(value = "memberLogin")
	public void memberLogin() {
		System.out.println("로그인");
	}
	
	@RequestMapping(value = "memberPage")
	public ModelAndView memberPage() {
		System.out.println("내 정보");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberPage");
		
		return mv;
	}
}