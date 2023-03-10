package com.iu.home.member;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ModelAndView getMemberLogin(ModelAndView mv, HttpServletRequest request) {
		mv.setViewName("member/memberLogin");
		
//		Cookie [] cookies = request.getCookies();
//		
//		for(Cookie cookie : cookies) {
//			System.out.println(cookie.getName());
//			System.out.println(cookie.getValue());
//			System.out.println(cookie.getDomain());
//			System.out.println(cookie.getPath());
//			System.out.println("------------------------");
//			if(cookie.getName().equals("remember")) {
//				mv.addObject("rememberId", cookie.getValue());
//				break;
//			} 
//		}
		
		return mv;
	}
	
	@RequestMapping(value = "getMemberLogin", method = RequestMethod.POST)
	public ModelAndView getMemberLogin(ModelAndView mv, MemberDTO memberDTO, HttpServletRequest request, String remember, HttpServletResponse response) throws Exception {
		memberDTO = memberService.getMemberLogin(memberDTO);
		
		if(remember != null && remember.equals("remember")) {
			Cookie cookie = new Cookie("rememberId", memberDTO.getId());
			cookie.setMaxAge(60*60*24*7); // 초단위
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("rememberId", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		// if문 선택사항
//		if(memberDTO != null) {
//			HttpSession session = request.getSession();
//			session.setAttribute("member", memberDTO);			
//		}
		
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
	
	@RequestMapping(value = "setMemberAgree", method = RequestMethod.GET)
	public ModelAndView setMemberAgree() throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/memberAgree");
		
		return mv;
	}
	
	@PostMapping(value = "memberIdCheck")
	public ModelAndView getMemberIdCheck(MemberDTO memberDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		boolean check = memberService.getMemberIdCheck(memberDTO);
		
		mv.addObject("result", check);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
}
