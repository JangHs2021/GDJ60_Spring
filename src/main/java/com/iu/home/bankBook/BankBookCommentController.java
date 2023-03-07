package com.iu.home.bankBook;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.board.BbsDTO;
import com.iu.home.member.MemberDTO;
import com.iu.home.util.Pager;

@Controller
@RequestMapping(value = "/bankBookComment/*")
public class BankBookCommentController {
	
	@Autowired
	private BankBookCommentService bankBookCommentService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getBoardList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		List<BbsDTO> ar = bankBookCommentService.getBoardList(pager);
		
		mv.addObject("list", ar);
		mv.setViewName("common/commentList");
		
		return mv;
	}
	
	@PostMapping(value = "add")
	public ModelAndView setBoardAdd(BankBookCommentDTO bankBookCommentDTO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		bankBookCommentDTO.setWriter(memberDTO.getId());
		
		int result = bankBookCommentService.setBoardAdd(bankBookCommentDTO, null, null);
		
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	
	@PostMapping(value = "delete")
	public ModelAndView setBoardDelete(BankBookCommentDTO bankBookCommentDTO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = bankBookCommentService.setBoardDelete(bankBookCommentDTO, null);
		
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	
	@PostMapping(value = "update")
	public ModelAndView setBoardUpdate(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = bankBookCommentService.setBoardUpdate(bankBookCommentDTO);
		
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
}
