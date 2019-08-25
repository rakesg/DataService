package com.dataservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dataservice.dao.ProductsDao;
import com.dataservice.model.Products;


@RestController
@RequestMapping("/data")
public class ProductController {

	@Autowired
	ProductsDao productlisting;
	
	@RequestMapping(method=RequestMethod.GET, value= "/all")
	public List<Products> getProductListing() {
		
		try{
			return productlisting.getProductListing();
		}catch(Exception e){
			return null;
		}
		
	}
	
	@PostMapping(path= "/", consumes = "application/json", produces = "application/json")
	public List<Products> filterProductListing(@RequestBody Products productFilter) {
		
		try{
			return productlisting.getProducts(productlisting.getProductListing(), productFilter);
		}catch(Exception e){
			return null;
		}
		
	}
}
