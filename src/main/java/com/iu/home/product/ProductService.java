package com.iu.home.product;

import java.util.List;

public class ProductService {
	private ProductDAO productDAO;
	
	public ProductService() {
		this.productDAO = new ProductDAO();
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
		
		
		for(ProductOptionDTO productOptionDTO : ar) {
			productOptionDTO.setProductNum(productNum);
			result = productDAO.setAddProductOption(productOptionDTO);			
		}
		
		return result; 
	}
}
