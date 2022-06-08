package com.example.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Enitity.Products;
import com.example.controller.form.InsertForm;
import com.example.service.InsertService;
import com.example.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	InsertService insertService;
	
	@Autowired
    MessageSource messageSource;

	@RequestMapping("/menu")
	public String search(@ModelAttribute("search")String key, Model model) {
		
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
	
	@RequestMapping(value = "/detail",params = "delete", method = RequestMethod.GET)
	public String insert(@Validated @ModelAttribute("detail") InsertForm form, BindingResult bindingResult, Model model) {
		
//		if (bindingResult.hasErrors()) {
//			
//			
//            return "delete";
//        }
		
		 Products products = new Products(form.getProductId(),form.getCategoryId(),form.getName(),form.getPrice());
		 int product = productService.delete(products);
		 
		 if (product == 0) {
				String errMsg = messageSource.getMessage("select.error", null, Locale.getDefault());
	            model.addAttribute("msg", errMsg);
				
				return "delete";

			}else{
		 
				List<Products> list = productService.findAll();
				
				model.addAttribute("productList", list);
		 
		 	return "menu";
		 
			}
		}
	


}
