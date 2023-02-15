package com.iu.home.bankBook;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.home.MyTestCase;

public class BankBookDAOTest extends MyTestCase {

	@Autowired
	private BankBookDAO bankBookDAO;
	
//	@Test
//	public void getBankBookList() throws Exception {
//		List<BankBookDTO> ar = bankBookDAO.getBankBookList();
//		
//		assertNotEquals(0, ar.size());
//	}
	
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
		for(int i = 0; i < 30; i++) {
			BankBookDTO bankBookDTO = new BankBookDTO();
			Random r = new Random();
			double d = r.nextDouble();
			int num = (int)d * 1000;
			d = num/100.0;
			
			bankBookDTO.setBookName("HS은행" + i);
			bankBookDTO.setBookRate(d);
			bankBookDTO.setBookSale(1);
			bankBookDTO.setBookDetail("detail1");
			int result = bankBookDAO.setBankBookAdd(bankBookDTO);
		}
		System.out.println("Finish");
	}
	
//	@Test
//	public void setBankBookUpdate() throws Exception {
//		BankBookDTO bankBookDTO = new BankBookDTO();
//		bankBookDTO.setBookName("test1");
//		bankBookDTO.setBookNumber(42L);
//		
//		int result = bankBookDAO.setBankBookUpdate(bankBookDTO);
//		
//		assertEquals(1, result);
//	}
//	
//	@Test
//	public void setBankBookDelete() throws Exception {
//		BankBookDTO bankBookDTO = new BankBookDTO();
//		bankBookDTO.setBookNumber(11L);
//		
//		int result = bankBookDAO.setBankBookDelete(bankBookDTO);
//		
//		assertEquals(1, result);
//	}
}
