package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Enitity.BuyList;
import com.example.Enitity.Products;
import com.example.Enitity.User;
import com.example.controller.form.BuyListForm;
import com.example.controller.form.InsertForm;
import com.example.service.InsertService;
import com.example.service.ProductService;

@Controller
public class InsertController {
	
	@Autowired
	InsertService insertService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	HttpSession session;
	
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
		String img = form.getImg();
		
		System.out.println(productid);
		System.out.println(categoryid);
		System.out.println(name);
		System.out.println(price);
		
		if (bindingResult.hasErrors()) {
			System.out.println("ok");
			model.addAttribute("msg", "商品IDが重複しています");
            return "insert";
        }
		
		Products products = new Products(productid, categoryid,name, price,img);
		
		insertService.insert(products);
		
		model.addAttribute("msg", "登録が完了しました");
		
		return "insert";	
	}
	
	@RequestMapping("/detail")
	public String buy(@ModelAttribute("detail")BuyListForm form,Model model) {
		System.out.println(form.getProductId());
		
		Products products = productService.findid(form.getProductId());
		
		model.addAttribute("productdetail", products);
		return "detail";
	}
	
	@RequestMapping("/detailuser")
	public String buyuser(@ModelAttribute("detail")BuyListForm form,Model model) {
		System.out.println(form.getProductId());
		
		Products products = productService.findid(form.getProductId());
		
		model.addAttribute("productdetail", products);
		return "detailuser";
	}
	
	@RequestMapping(value = "/detail", params = "buy", method = RequestMethod.GET)
	public String resultbuy(@Validated@ModelAttribute("detail") BuyListForm form, BindingResult bindingResult, Model model) {
		System.out.println("通った");
		
		User user = (User) session.getAttribute("user");
		System.out.println(user.getName());

		BuyList buyList = new BuyList(user.getName(),form.getProductId(),form.getCategoryId(),form.getName(),form.getPrice(),form.getImg());
		
		insertService.insertbuy(buyList);
		
		List<BuyList> list = productService.finduserlist();
		System.out.println(list);
		model.addAttribute("productList", list);
		return "buylist";

	}
	
	
	
	@RequestMapping(value = "/detailuser", params = "buy", method = RequestMethod.GET)
	public String resultbuyuser(@Validated@ModelAttribute("detail") BuyListForm form, BindingResult bindingResult, Model model) {
		System.out.println("通った");
		
		User user = (User) session.getAttribute("user");
		System.out.println(user.getName());

		BuyList buyList = new BuyList(user.getName(),form.getProductId(),form.getCategoryId(),form.getName(),form.getPrice(),form.getImg());
		
		insertService.insertbuy(buyList);
		
		List<BuyList> list = productService.finduserlist();
		System.out.println(list);
		model.addAttribute("productList", list);
		return "buylist2";

	}
}
