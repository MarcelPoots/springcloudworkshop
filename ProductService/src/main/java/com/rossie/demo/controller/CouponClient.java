package com.rossie.demo.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rossie.demo.model.Coupon;


//@FeignClient("zuul-api-gateway")
@FeignClient("COUPON-SERVICE")
//@RibbonClient("COUPON-SERVICE")
public interface CouponClient {
	
	@GetMapping("/couponapi/coupons/{code}")
	Coupon getCoupon(@PathVariable("code") String code);
}
