package com.iu.home.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "list")
	public ModelAndView getProductList(ModelAndView mv) throws Exception {
		List<ProductDTO> ar = productService.getProductList();
		
		mv.setViewName("/product/productList");
		mv.addObject("list", ar);
		
		return mv;
	}
	
	@RequestMapping(value = "detail")
	public ModelAndView getProductDetail(ProductDTO productDTO, ModelAndView mv) throws Exception {
		 productDTO = productService.getProductDetail(productDTO);
		 
		 mv.setViewName("/product/productDetail");
		 mv.addObject("detail", productDTO);
		 
		 return mv;
	}
}
