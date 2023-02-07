package com.iu.home.bankBook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BankBookDAOTest {

	@Autowired
	private BankBookDAO bankBookDAO;
	
//	@Test
//	public void getBankBookList() throws Exception {
//		List<BankBookDTO> ar = bankBookDAO.getBankBookList();
//		
//		assertNotEquals(0, ar.size());
//	}
//	
//	@Test
//	public void getBankBookDetail() throws Exception {
//		BankBookDTO bankBookDTO = new BankBookDTO();
//		
//		bankBookDTO.setBookNumber(2L);
//		
//		bankBookDTO = bankBookDAO.getBankBookDetail(bankBookDTO);
//		
//		assertNotNull(bankBookDTO);
//	}
	
	@Test
	public void setBankBookAdd() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		
		bankBookDTO.setBookNumber(22L);
		bankBookDTO.setBookName("HS");
		bankBookDTO.setBookRate(1.1);
		bankBookDTO.setBookSale(1);
		bankBookDTO.setBookDetail("detail1");
		
		int result = bankBookDAO.setBankBookAdd(bankBookDTO);
		
		assertEquals(1, result);
	}
}
