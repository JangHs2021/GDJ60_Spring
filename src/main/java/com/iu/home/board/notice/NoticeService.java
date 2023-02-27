package com.iu.home.board.notice;

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
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO; 
	
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		pager.makeRow();
		
		pager.makeNum(noticeDAO.getTotalCount(pager));
		
		return noticeDAO.getBoardList(pager);
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO, MultipartFile [] files, HttpSession session) throws Exception {
		int result = noticeDAO.setBoardAdd(bbsDTO);
		
		String realPath = session.getServletContext().getRealPath("resources/upload/notice");
		
		for(MultipartFile multipartFile : files) {
			
			if(multipartFile.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(multipartFile, realPath);
			
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setNum(bbsDTO.getNum());
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(multipartFile.getOriginalFilename());
			
			result = noticeDAO.setBoardFileAdd(boardFileDTO);
		}
		
		return result;
	}

	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		return 0;
	}

	@Override
	public int setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		List<BoardFileDTO> ar = noticeDAO.getBoardFileList(bbsDTO);
		int result = noticeDAO.setBoardDelete(bbsDTO);
		
		if(result > 0) {
			String realPath = session.getServletContext().getRealPath("resources/upload/notice");
			
			for(BoardFileDTO boardFileDTO : ar) {
				boolean check = fileManager.fileDelete(realPath, boardFileDTO.getFileName());
			}
		}
		return result;
	}

	@Override
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception {
		return noticeDAO.getBoardDetail(boardDTO);
	}
}
