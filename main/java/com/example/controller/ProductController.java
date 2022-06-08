package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Enitity.Products;
import com.example.service.InsertService;
import com.example.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	InsertService insertService;

	@RequestMapping("/menu")
	public String search(@ModelAttribute("search") Model model) {
		
//		Products products = new Products(null, null, key, null);

		List<Products> list = productService.findAll();
		
		model.addAttribute("productList", list);

		return "menu";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String resultsearch(@ModelAttribute("search") String key, Model model) {

		Products products = new Products(null, null, key, null);

		List<Products> list = productService.find(products);
		
		model.addAttribute("productList", list);
		model.addAttribute("productListnum", list.size());
		return "menu";

	}
	


}
