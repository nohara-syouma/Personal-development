package com.example.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Enitity.BuyList;
import com.example.Enitity.Products;
import com.example.controller.form.BuyListForm;
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
	
	@Autowired
	HttpSession session;
	
//	@Autowired
//	HttpSession session1;
//	
//	@Autowired
//	HttpSession session2;

	@RequestMapping("/menu")
	public String search(@ModelAttribute("search")String key, Model model) {
		
		List<Products> list = productService.findAll();
		
		model.addAttribute("productList", list);
		model.addAttribute("productListnum", list.size());

		return "menu";
	}
	
	@RequestMapping("/menu2")
	public String search2(@ModelAttribute("search")String key, Model model) {
		
		List<Products> list = productService.findAll();
		
		model.addAttribute("productList", list);
		
		model.addAttribute("productListnum", list.size());

		return "menu2";
	}
	
	@RequestMapping("/buylist")
	public String buylist(@ModelAttribute("buylist")BuyListForm form, Model model) {
		
		List<BuyList> list = productService.finduserlist();
		System.out.println(list);
		model.addAttribute("productList", list);
		
		model.addAttribute("productListnum", list.size());

		return "buylist";
	}
	
	@RequestMapping("/buylist2")
	public String buylist2(@ModelAttribute("buylist")BuyListForm form, Model model) {
		
		List<BuyList> list = productService.finduserlist();
		System.out.println(list);
		model.addAttribute("productList", list);
		
		model.addAttribute("productListnum", list.size());

		return "buylist2";
	}
	
//	@RequestMapping("/notification")
//	public String notification(@ModelAttribute("detail")BuyListForm form, Model model) {
//		
//		List<BuyList> list = productService.finduserlist();
//		System.out.println(list);
//		model.addAttribute("productList", list);
//
//		return "notification";
//	}
	
	@RequestMapping(value="/notification")
	public String notification(@ModelAttribute("detail") BuyListForm form,Model model) {
		
		List<BuyList> list = productService.listAll();
		System.out.println(list);
		model.addAttribute("productList", list);
		
		model.addAttribute("productListnum", list.size());
		
//		session1.invalidate();
		
//		session2.setAttribute("tuuti2", list.size());
		
		return "notification";
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
				model.addAttribute("productListnum", list.size());
		 
		 	return "menu";
		 
			}
		}
	
	@RequestMapping(value = "/detail",params = "update", method = RequestMethod.GET)
	public String update(@Validated @ModelAttribute("detail") InsertForm form, BindingResult bindingResult, Model model) {
		
//		if (bindingResult.hasErrors()) {
//			
//			
//            return "delete";
//        }
		
		 Products products = new Products(form.getProductId(),form.getCategoryId(),form.getName(),form.getPrice(),form.getImg());
		 int product = productService.update(products);
		 
		 if (product == 0) {
				String errMsg = messageSource.getMessage("select.error", null, Locale.getDefault());
	            model.addAttribute("msg", errMsg);
				
				return "update";

			}else{
		 
				List<Products> list = productService.findAll();
				
				model.addAttribute("productList", list);
				
				model.addAttribute("productListnum", list.size());
		 
		 	return "menu";
		 
			}
		}

}
