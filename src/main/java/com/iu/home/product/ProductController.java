package com.iu.home.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "list")
	public ModelAndView getProductList(ModelAndView mv) throws Exception {
//		ModelAndView mv = new ModelAndView();
		
		List<ProductDTO> ar = productService.getProductList();
		
		System.out.println(ar.size() > 0);
		
		mv.setViewName("product/productList");
		mv.addObject("list", ar);
		
		return mv;
	}
	
	@RequestMapping(value = "detail")
	public String getProductDetail(ProductDTO productDTO, Model model) throws Exception {
		// 파라미터의 이름과 setter의 이름과 같아야 함
		
		System.out.println("Product Detail");
		//String num = request.getParameter("num");
		
//		System.out.println(name);
//		System.out.println(age);
//		
//		ProductDTO productDTO = new ProductDTO();
//		productDTO.setProductNum(num);
		productDTO = productService.getProductDetail(productDTO);
		
		System.out.println(productDTO != null);
		
		model.addAttribute("dto", productDTO);
		
		return "product/productDetail";
	}
	
	@RequestMapping(value = "productAdd", method = RequestMethod.GET)
	public void productAdd() {
		System.out.println("Product Add");
	}
	
	@RequestMapping(value = "productAdd", method = RequestMethod.POST)
	public String productAdd(ProductDTO productDTO) throws Exception {
		int result = productService.setAddProduct(productDTO, null);
		System.out.println(result == 1);
		return "redirect:./list";	
	}
	
	@RequestMapping(value = "update")
	public ModelAndView productUpdate() {
		System.out.println("Product Update");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/productUpdate");
		
		return mv;
	}
}
