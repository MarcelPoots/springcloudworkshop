package com.rossie.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rossie.demo.model.Coupon;
import com.rossie.demo.model.Product;
import com.rossie.demo.repository.ProductRepo;
import com.rossie.demo.restclients.CouponClient;


@RestController
@RefreshScope
@RequestMapping("/productapi")
public class ProductController {

	@Autowired 
	CouponClient couponClient;

	@Autowired
	private ProductRepo repo;

	@Value("${my.custom.property}")
	private String prop;
	
	//@HystrixCommand(fallbackMethod = "sendErrorResponse")
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public Product create(@RequestBody Product product) {
		Coupon coupon = couponClient.getCoupon(product.getCouponCode());
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return repo.save(product);

	}

	@RequestMapping(value = "/prop", method = RequestMethod.GET)
	public String showProperty() {
		return prop;

	}
	
	public Product sendErrorResponse(Product product) {
		return product;

	}

}

