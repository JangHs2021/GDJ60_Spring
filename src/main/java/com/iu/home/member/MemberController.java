package com.iu.home.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "setMemberAdd")
	public String setMemberAdd(MemberDTO memberDTO) throws Exception {
		
		int result = memberService.setMemberAdd(memberDTO);
		
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
	
	@RequestMapping(value = "memberList")
	public ModelAndView memberList(ModelAndView mv) {
		List<MemberDTO> ar = new ArrayList<MemberDTO>();
		ar = memberService.memberList();
		
		mv.addObject("list", ar);
		mv.setViewName("member/memberList");
		
		return mv;
	}
}
