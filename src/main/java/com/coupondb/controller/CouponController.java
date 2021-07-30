package com.coupondb.controller;

import com.coupondb.model.Coupon;
import com.coupondb.service.CouponService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CouponController
{
    CouponService couponService;
    public CouponController(CouponService couponService)
    {
        this.couponService=couponService;

    }

    @GetMapping("/coupon")
    public ResponseEntity<Iterable<Coupon>> findAllCoupons()
    {
        return new ResponseEntity(couponService.findAllCoupons(), HttpStatus.OK);
    }

    @PostMapping("/coupon")
    public ResponseEntity addCoupon(@RequestBody Coupon coupon)
    {
        return new ResponseEntity(couponService.addCoupon(coupon), HttpStatus.CREATED);
    }

    @PatchMapping("/coupon/{couponId}")
    public ResponseEntity<Coupon>updateCoupon(@RequestBody Coupon coupon, @PathVariable long couponId)
    {
        Coupon resultCoupon = couponService.updateCoupon(coupon, couponId).orElse(null);
        if(resultCoupon != null)
            return new ResponseEntity(resultCoupon, HttpStatus.OK);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
