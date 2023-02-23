package com.iu.home.bankBook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.home.MyTestCase;
import com.iu.home.board.BbsDTO;
import com.iu.home.util.Pager;

public class BankBookCommentDAOTest extends MyTestCase {
	
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	@Test
	public void getBoardListTest() throws Exception {
		Pager pager = new Pager();
		
		pager.setBookNumber(421L);
		// pager.setKind("writer");
		// pager.setSearch("t");
		pager.makeRow();
		
		// long count = bankBookCommentDAO.getTotalCount(pager);
		List<BbsDTO> ar = bankBookCommentDAO.getBoardList(pager);
		
		assertNotEquals(0, ar.size());
	}
}
