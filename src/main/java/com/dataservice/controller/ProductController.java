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


/**
 * ProductController is a REST controller that handles requests related to product listings.
 * It provides endpoints to retrieve all products and filter products based on specific criteria.
 * 
 * <p>
 * The controller exposes the following endpoints:
 * </p>
 * 
 * <ul>
 *   <li><b>GET /data/all</b> - Retrieves a list of all products.</li>
 *   <li><b>POST /data/</b> - Filters the product listing based on the provided product filter criteria in JSON format.</li>
 * </ul>
 * 
 * <p>
 * The controller uses the {@link ProductsDao} to interact with the data layer for fetching product information.
 * </p>
 * 
 * <p>
 * In case of any exceptions during the data retrieval process, the methods will return null.
 * </p>
 */
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
	
	/**
	 * Filters the product listing based on the provided product filter criteria.
	 *
	 * This method handles POST requests to the root path ("/") and expects a JSON 
	 * representation of a Products object in the request body. It processes the 
	 * filter and returns a list of Products that match the specified criteria.
	 *
	 * @param productFilter the Products object containing the filter criteria
	 * @return a List of Products that match the filter criteria, or null if an 
	 *         exception occurs during processing
	 */
	@PostMapping(path= "/", consumes = "application/json", produces = "application/json")
	public List<Products> filterProductListing(@RequestBody Products productFilter) {
		
		try{
			return productlisting.getProducts(productlisting.getProductListing(), productFilter);
		}catch(Exception e){
			return null;
		}
		
	}
}
