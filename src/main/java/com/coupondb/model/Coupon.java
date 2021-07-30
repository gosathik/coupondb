package com.coupondb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Coupon
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long couponId;
    private String itemName;
    private double itemPrice;
    private double couponAmount;
    private LocalDate couponExpiryDate;
    private String storeName;

    public Coupon(String itemName, double itemPrice, double couponAmount, LocalDate couponExpiryDate, String storeName) {
        this.itemName = itemName;
        itemPrice = itemPrice;
        this.couponAmount = couponAmount;
        this.couponExpiryDate = couponExpiryDate;
        this.storeName = storeName;
    }
}
