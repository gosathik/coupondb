package com.coupondb.service;

import com.coupondb.model.Coupon;
import com.coupondb.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CouponService
{
    @Autowired
    CouponRepository couponRepo;

    public Coupon addCoupon(Coupon coupon)
    {
        return couponRepo.save(coupon);
    }

    public List<Coupon> findAllCoupons()
    { return couponRepo.findAll();
    }

    public Optional<Coupon> updateCoupon(Coupon coupon, Long couponId)
    {
        if(coupon.getCouponAmount() == 0 && coupon.getCouponExpiryDate() == null)
        {}
        else if(coupon.getCouponAmount() != 0 && coupon.getCouponExpiryDate() ==null)
        {
            couponRepo.updateCouponAmount(coupon.getCouponAmount(),couponId);
        }
        else if(coupon.getCouponAmount() == 0 && coupon.getCouponExpiryDate() !=null)
        {
            couponRepo.updateCouponExpiryDate(coupon.getCouponExpiryDate(),couponId);
        }
        else
        {
            couponRepo.updateCouponAmountDate(coupon.getCouponAmount(),coupon.getCouponExpiryDate(),couponId);
        }
        return couponRepo.findById(couponId);
    }
}
