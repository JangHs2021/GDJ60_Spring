package com.iu.home.Notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.home.MyTestCase;
import com.iu.home.board.BbsDTO;
import com.iu.home.board.BoardDTO;
import com.iu.home.board.notice.NoticeDAO;
import com.iu.home.util.Pager;

import oracle.net.aso.c;

public class NoticeDAOTest extends MyTestCase {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void test() throws Exception {
		Pager pager = new Pager();
	
		pager.setKind("writer");
		pager.setSearch("t");
		
		
		long count = noticeDAO.getTotalCount(pager);
		//List<BbsDTO> ar = noticeDAO.getBoardList(pager);
		
		assertNotEquals(0, count);
	}

}
