package com.iu.home.Notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.home.MyTestCase;
import com.iu.home.board.BbsDTO;
import com.iu.home.board.BoardDTO;
import com.iu.home.board.notice.NoticeDAO;
import com.iu.home.board.notice.NoticeDTO;
import com.iu.home.util.Pager;

import oracle.net.aso.c;

public class NoticeDAOTest extends MyTestCase {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void test() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		
		noticeDTO.setTitle("HS");
		noticeDTO.setWriter("HS");
		noticeDTO.setContents("Contents");
		
		int result = noticeDAO.setBoardAdd(noticeDTO);
		
		assertEquals(1, result);
	}
}
