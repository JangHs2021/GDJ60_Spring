package com.iu.home.board.qna;

import java.util.List;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.board.BbsDTO;
import com.iu.home.board.BoardDTO;
import com.iu.home.board.BoardFileDTO;
import com.iu.home.util.Pager;

@Controller
@RequestMapping(value = "/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("boardName")
	public String getBoardName() {
		return "qna";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getBoardList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		List<BbsDTO> ar = qnaService.getBoardList(pager);
		
		mv.addObject("list", ar);
		mv.setViewName("board/list");
		
		RestTemplate restTemplate = new RestTemplate();
		
		// Header
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/x-www-form-urlencoded");
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		// parameter(post)
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "${REST_API_KEY}");
		
		// header, params 하나의 객체로 생성
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String,String>>(params, headers);
		
		String result = restTemplate.getForObject("https://dummyjson.com/products/1", String.class, request);
		
		return mv;
	}
	
	@GetMapping(value = "add")
	public ModelAndView setBoardAdd() throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/add");
		
		return mv;
	}
	
	@PostMapping(value = "add")
	public ModelAndView setBoardAdd(QnaDTO qnaDTO, MultipartFile [] addfiles, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.setBoardAdd(qnaDTO, addfiles, session);
		
		String message = "등록 실패";
		
		if(result > 0) {
			message = "글이 등록 되었습니다";
		}
		
		mv.addObject("result", message);
		mv.addObject("url", "./list");
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@GetMapping(value = "detail")
	public ModelAndView getBoardDetail(QnaDTO qnaDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		BoardDTO boardDTO = qnaService.getBoardDetail(qnaDTO);
		
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/detail");
		
		return mv;
	}
	
	@GetMapping(value = "reply")
	public ModelAndView setReplyAdd(BoardDTO BoardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/reply");
		
		return mv;
	}
	
	@PostMapping(value = "reply")
	public ModelAndView setReplyAdd(QnaDTO qnaDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.setReplyAdd(qnaDTO);
		
		String message = "등록 실패";
		
		if(result > 0) {
			message = "글이 등록 되었습니다";
		}
		
		mv.addObject("url", "./detail?num=" + qnaDTO.getNum());
		mv.addObject("result", message);
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@PostMapping(value = "delete")
	public ModelAndView setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.setBoardDelete(bbsDTO, session);
		
		String message = "삭제 실패";
		
		if(result > 0) {
			message = "삭제 성공";
		}
		
		mv.addObject("result", message);
		mv.addObject("url", "./list");
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@GetMapping(value = "fileDown")
	public ModelAndView getFileDown(BoardFileDTO boardFileDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		boardFileDTO = qnaService.getBoardFileDetail(boardFileDTO);
		
		mv.addObject("boardFile", boardFileDTO);
		mv.setViewName("fileDownView");
		
		return mv;
	}
	
	@GetMapping(value = "update")
	public ModelAndView setBoardUpdate(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		boardDTO = qnaService.getBoardDetail(boardDTO);
		
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/update");
		
		return mv;
	}
	
	@PostMapping(value = "update")
	public ModelAndView setBoardUpdate(BoardDTO boardDTO, MultipartFile [] addfiles, HttpSession session, Long [] fileNum) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.setBoardUpdate(boardDTO, addfiles, session, fileNum);
		
		mv.addObject("result", "수정 성공");
		mv.addObject("url", "./list");
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@PostMapping("boardFileDelete")
	public ModelAndView setBoardFileDelete(Long fileNum) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.setBoardFileDelete(fileNum);
		
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
}
