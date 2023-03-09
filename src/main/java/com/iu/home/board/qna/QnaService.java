package com.iu.home.board.qna;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.home.board.BbsDTO;
import com.iu.home.board.BoardDTO;
import com.iu.home.board.BoardFileDTO;
import com.iu.home.board.BoardService;
import com.iu.home.util.FileManager;
import com.iu.home.util.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		pager.makeRow();
		
		pager.makeNum(qnaDAO.getTotalCount(pager));
		
		return qnaDAO.getBoardList(pager);
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO, MultipartFile [] files, HttpSession session) throws Exception {
		int result = qnaDAO.setBoardAdd(bbsDTO);
		
		// file HDD 저장
		String realPath = session.getServletContext().getRealPath("resources/upload/qna");
		System.out.println(realPath);
		
		for(MultipartFile multipartFile: files) {	
			
			if (multipartFile.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(multipartFile, realPath);
			
			// DB INSERT
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setNum(bbsDTO.getNum());
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(multipartFile.getOriginalFilename());

			result = qnaDAO.setBoardFileAdd(boardFileDTO);
		}
		
		return result;
	}

	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		return 0;
	}
	
	@Override
	public int setBoardUpdate(BbsDTO bbsDTO, MultipartFile[] multipartFiles, HttpSession session, Long [] fileNums)
			throws Exception {
		int result = qnaDAO.setBoardUpdate(bbsDTO);
		
		if(fileNums != null) {
			for(Long fileNum : fileNums) {
				qnaDAO.setBoardFileDelete(fileNum);
			}
		}
		
		String realPath = session.getServletContext().getRealPath("resources/upload/qna");
		System.out.println(realPath);
		
		for(MultipartFile multipartFile: multipartFiles) {	
			
			if (multipartFile.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(multipartFile, realPath);
			
			// DB INSERT
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setNum(bbsDTO.getNum());
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(multipartFile.getOriginalFilename());

			result = qnaDAO.setBoardFileAdd(boardFileDTO);
		}
		
		return result;
	}

	@Override
	public int setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		List<BoardFileDTO> ar = qnaDAO.getBoardFileList(bbsDTO);
		int result = qnaDAO.setBoardDelete(bbsDTO);
		
		if (result > 0) {
			String realPath = session.getServletContext().getRealPath("resources/upload/qna");
			
			for(BoardFileDTO boardFileDTO : ar) {
				boolean check = fileManager.fileDelete(realPath, boardFileDTO.getFileName());
			}
		}
		return result;
	}

	@Override
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception {
		return qnaDAO.getBoardDetail(boardDTO);
	}
	
	// reply Insert
	public int setReplyAdd(QnaDTO qnaDTO) throws Exception {
		// QnaDTO
		// num : 부모의 글번호
		// writer, title, contents : 답글로 입력한 값
		// ref : null
		// step : null
		// depth : null
		// 1. 부모의 정보를 조회
		QnaDTO parent = (QnaDTO)qnaDAO.getBoardDetail(qnaDTO);
		
		// ref : 부모읜 ref
		qnaDTO.setRef(parent.getRef());
		
		// step : 부모의 step + 1
		qnaDTO.setStep(parent.getStep() + 1);
		
		// depth : 부모의 depth + 1
		qnaDTO.setDepth(parent.getDepth() + 1);
		
		// 2. Step update
		int result = qnaDAO.setStepUpdate(parent);
		
		// 3. 답글 insert
		result = qnaDAO.setReplyAdd(qnaDTO);
		
		return result; 
	}

	@Override
	public BoardFileDTO getBoardFileDetail(BoardFileDTO boardFileDTO) throws Exception {
		return qnaDAO.getBoardFileDetail(boardFileDTO);
	}
	
	public int setBoardFileDelete(Long fileNum) throws Exception {
		// HDD에 파일 삭제
		return qnaDAO.setBoardFileDelete(fileNum);
	}
}
