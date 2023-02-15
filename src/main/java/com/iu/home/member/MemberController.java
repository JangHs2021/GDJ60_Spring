package com.iu.home.member;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.bankBook.BankBookDTO;

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
		
		mv.setViewName("redirect:../");
		
		return mv;
	}
	
	@RequestMapping(value = "getMemberLogin", method = RequestMethod.GET)
	public ModelAndView getMemberLogin(ModelAndView mv) {
		mv.setViewName("member/memberLogin");
		
		return mv;
	}
	
	@RequestMapping(value = "getMemberLogin", method = RequestMethod.POST)
	public ModelAndView getMemberLogin(ModelAndView mv, MemberDTO memberDTO, HttpServletRequest request) throws Exception {
		memberDTO = memberService.getMemberLogin(memberDTO);
		
		// if문 선택사항
		if(memberDTO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", memberDTO);			
		}

		mv.setViewName("redirect:../");		
		return mv;
	}
	
	@RequestMapping(value = "getMemberLogout", method = RequestMethod.GET)
	public ModelAndView getMemberLogout(ModelAndView mv, HttpSession session) throws Exception {
		session.invalidate();
		
		mv.setViewName("redirect:../");
		
		return mv;
	}
	
	@RequestMapping(value = "getMemberPage", method = RequestMethod.GET)
	public ModelAndView getMemberMyPage(ModelAndView mv, HttpSession session) throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		memberDTO = memberService.getMemberPage(memberDTO);
		
		mv.addObject("dto", memberDTO);
		mv.setViewName("member/memberPage");
		return mv;
	}
	
	@RequestMapping(value = "setMemberUpdate", method = RequestMethod.GET)
	public ModelAndView setMemberUpdate(ModelAndView mv, HttpSession session) throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO = memberService.getMemberPage(memberDTO);
		
		mv.addObject("dto", memberDTO);
		mv.setViewName("member/memberUpdate");
		
		return mv;
	}
	
	@RequestMapping(value = "setMemberUpdate", method = RequestMethod.POST)
	public ModelAndView setMemberUpdate(MemberDTO memberDTO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberDTO sessionMemberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO.setId(sessionMemberDTO.getId());
		int result = memberService.setMemberUpdate(memberDTO);
//		if(result > 0) {
//			session.setAttribute("member", memberDTO);
//		}
		
		mv.setViewName("redirect:./getMemberPage");
		
		return mv;
	}
}
