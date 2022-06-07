package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
public class InsertController {
	
	@Autowired
	InsertService insertService;
	
	@RequestMapping("/insert")
    public String insert(@ModelAttribute("insert") InsertForm form, Model model) {	
		
        return "insert";
    }
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String resultlogin(@Validated@ModelAttribute("insert") InsertForm form, BindingResult bindingResult, Model model) {
		Integer productid = form.getProductId();
		Integer categoryid = form.getCategoryId();
		String name = form.getName();
		Integer price = form.getPrice();
		
		System.out.println(productid);
		System.out.println(categoryid);
		System.out.println(name);
		System.out.println(price);
		
		if (bindingResult.hasErrors()) {
			System.out.println("ok");
			model.addAttribute("msg", "商品IDが重複しています");
            return "insert";
        }
		
		Products products = new Products(productid, categoryid,name, price);
		
		insertService.insert(products);
		
		model.addAttribute("msg", "登録が完了しました");
		
		return "insert";	
	}
	

}
