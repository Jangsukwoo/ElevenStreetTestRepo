package com.elevenst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.elevenst.model.ProductSearchResponse.Product;
import com.elevenst.service.ProductSearchService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ProductSearchController {
	
	@Autowired
    private ProductSearchService productService;
	
    @RequestMapping("/productSearch")
    public ModelAndView  publishEvent() {
    	List<Product> productList = productService.getProductList("�峭��");
    	return new ModelAndView("productSearch");
    }
    @RequestMapping("/search")
    public String  publishEvent2() {
    	return "productSearch.jsp";
    }
}
