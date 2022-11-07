package com.rossie.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rossie.demo.model.Coupon;
import com.rossie.demo.model.Product;
import com.rossie.demo.repository.ProductRepo;
import com.rossie.demo.restclients.CouponClient;


@RestController
@RequestMapping("/productapi")
public class ProductController {

	@Autowired 
	CouponClient couponClient;

	@Autowired
	private ProductRepo repo;

	//@HystrixCommand(fallbackMethod = "sendErrorResponse")
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public Product create(@RequestBody Product product) {
		Coupon coupon = couponClient.getCoupon(product.getCouponCode());
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return repo.save(product);

	}

	public Product sendErrorResponse(Product product) {
		return product;

	}

}

