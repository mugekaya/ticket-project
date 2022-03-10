package com.felece.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    @Column(name = "route_name")
    private String routeName;
    @Column(name = "price")
    private double price;
    @Column(name = "cart_start_date")
    private String cartStartDate;
    @Column(name = "cart_end_date")
    private String cartEndDate;
    @Column(name = "seat_id")
    private int seatId;
    @Column(name = "user_id")
    private int userId;


    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCartStartDate() {
        return cartStartDate;
    }

    public void setCartStartDate(String cartStartDate) {
        this.cartStartDate = cartStartDate;
    }

    public String getCartEndDate() {
        return cartEndDate;
    }

    public void setCartEndDate(String cartEndDate) {
        this.cartEndDate = cartEndDate;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
