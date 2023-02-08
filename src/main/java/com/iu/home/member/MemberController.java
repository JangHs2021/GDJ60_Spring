package com.iu.home.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "memberList")
	public ModelAndView memberList(ModelAndView mv) {
		List<MemberDTO> ar = new ArrayList<MemberDTO>();
		ar = memberService.memberList();
		
		mv.addObject("list", ar);
		mv.setViewName("member/memberList");
		
		return mv;
	}
	
	@RequestMapping(value = "setMemberAdd", method = RequestMethod.GET)
	public ModelAndView setMemberAdd(ModelAndView mv) throws Exception {
		mv.setViewName("member/memberJoin");
		
		return mv;
	}
	
	@RequestMapping(value = "setMemberAdd", method = RequestMethod.POST)
	public ModelAndView setMemberAdd(ModelAndView mv, MemberDTO memberDTO) throws Exception {
		int result = memberService.setMemberAdd(memberDTO);
		
		mv.setViewName("redirect:./memberList");
		
		return mv;
	}
}
