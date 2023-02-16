package com.iu.home.product;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.home.MyTestCase;

public class ProductDAOTest extends MyTestCase {
	
	@Autowired
	private ProductDAO productDAO;
	
//	@Test
//	public void getProductListTest() throws Exception {
//		List<ProductDTO> ar = productDAO.getProductList();
//		// 단정문
//		assertNotEquals(0, ar.size());
//	}
	
	@Test
	public void getProductDetailTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		
		productDTO.setProductNum(193L);
		
		productDTO = productDAO.getProductDetail(productDTO);
		
		assertNotNull(productDTO);
	}
	
	@Test
	public void setProductAddTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		
		productDTO.setProductNum(1L);
		productDTO.setProductName("mmmmmm");
		productDTO.setProductDetail("llllllll");
		
		int result = productDAO.setProductAdd(productDTO);
		
		assertEquals(1, result);
	}
}
