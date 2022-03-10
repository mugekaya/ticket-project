package com.felece.project.service.impl;

import com.felece.project.entity.Cart;
import com.felece.project.repository.CartRepository;
import com.felece.project.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart save(Cart newCart) {
        return null;
    }

    @Override
    public Cart updateCart(Long cartId, Cart newCart) {
        cartRepository.save(newCart);
        return null;
    }
}
