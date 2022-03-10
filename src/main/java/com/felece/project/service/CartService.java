package com.felece.project.service;

import com.felece.project.entity.Cart;

public interface CartService {
     Cart save(Cart newCart);

    Cart updateCart(Long cartId, Cart newCart);
}


