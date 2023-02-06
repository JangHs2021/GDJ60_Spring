package com.iu.home.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception {
		 productDTO = productDAO.getProductDetail(productDTO);
		 
		 return productDTO;
	}
	
	public List<ProductDTO> getProductList() throws Exception {
		List<ProductDTO> ar = productDAO.getProductList();
		
		return ar;
	}
	
	public int setAddProduct(ProductDTO productDTO, List<ProductOptionDTO> ar) throws Exception {
		//product, option 
		Long productNum = productDAO.getProductNum();
		productDTO.setProductNum(productNum);
		int result = productDAO.setAddProduct(productDTO);
		
		if(ar != null) {			
			for(ProductOptionDTO productOptionDTO : ar) {
				productOptionDTO.setProductNum(productNum);
				result = productDAO.setAddProductOption(productOptionDTO);			
			}
		}
		return result; 
	}
}
