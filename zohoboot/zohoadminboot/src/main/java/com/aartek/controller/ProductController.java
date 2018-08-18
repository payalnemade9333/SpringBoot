package com.aartek.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.model.Product;
import com.aartek.service.ProductService;
@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/product", method= RequestMethod.GET)
	public String checkProduct(Model model, Product product)
	{
		System.out.println("---------------Inside get product controller-------------------");
		model.addAttribute("productMap", new Product());
	
	//	map.put("prod", productService.getProduct(product));
		model.addAttribute("prod", productService.getProduct(product));
		return "product";
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.POST )
	public String saveProductDetail(@ModelAttribute("productMap") Product product,BindingResult result,
			Map<String, Object> map, HttpServletRequest request) {
		System.out.println("------------------------Inside post Product Controller---------------------");
		map.put("prod", productService.getProductDetails(product));
		return "product";
		
		
	}
}
