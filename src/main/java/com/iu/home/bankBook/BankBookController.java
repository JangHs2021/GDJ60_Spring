package com.iu.home.bankBook;

import java.util.List;

import javax.swing.text.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/bankBook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getBankBookList(ModelAndView mv) throws Exception {
		List<BankBookDTO> ar = bankBookService.getBankBookList();
		
		mv.addObject("list", ar);
		mv.setViewName("bankBook/bankBookList");
		
		return mv;
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView getBankBookDetail(ModelAndView mv, BankBookDTO bankBookDTO) throws Exception {
		bankBookDTO = bankBookService.getBankBookDetail(bankBookDTO);
		
		mv.addObject("dto", bankBookDTO);
		mv.setViewName("bankBook/bankBookDetail");
		
		return mv;
	}
	
	@RequestMapping(value = "bankBookAdd", method = RequestMethod.GET)
	public ModelAndView setBankBookAdd(ModelAndView mv) throws  Exception {
		mv.setViewName("bankBook/bankBookAdd");
		
		return mv;
	}
	
	@RequestMapping(value = "bankBookAdd", method = RequestMethod.POST)
	public ModelAndView setBankBookAdd(ModelAndView mv, BankBookDTO bankBookDTO) throws Exception {
		int result = bankBookService.setBankBookAdd(bankBookDTO);
		
		mv.setViewName("redirect:./list");
		
		return mv;
	}
	
//	@RequestMapping(value = "bankBookAdd", method = RequestMethod.POST)
//	public String setBankBookAdd(BankBookDTO bankBookDTO) throws Exception {
//		int result = bankBookService.setBankBookAdd(bankBookDTO);
//		
//		return "redirect:/list";
//	}
	
	@RequestMapping(value = "bankBookDelete", method = RequestMethod.GET)
	public ModelAndView setBankBookDelete(ModelAndView mv, BankBookDTO bankBookDTO) throws Exception {
		int result = bankBookService.setBankBookDelete(bankBookDTO);
		
		mv.setViewName("redirect:./list");
		
		return mv;
	}
	
	@RequestMapping(value = "bankBookUpdate", method = RequestMethod.GET)
	public ModelAndView setBankBookUpdate(ModelAndView mv, BankBookDTO bankBookDTO) throws Exception {
		bankBookDTO = bankBookService.getBankBookDetail(bankBookDTO);
		
		mv.addObject("dto", bankBookDTO);
		mv.setViewName("bankBook/bankBookUpdate");
		
		return mv;
	}
	
	@RequestMapping(value = "bankBookUpdate", method = RequestMethod.POST)
	public ModelAndView setBankBookUpdate(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		
		return mv;
	}
}
