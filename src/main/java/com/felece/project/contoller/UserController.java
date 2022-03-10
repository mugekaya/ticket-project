package com.felece.project.contoller;

import com.felece.project.entity.Cart;
import com.felece.project.entity.Order;
import com.felece.project.entity.User;
import com.felece.project.service.CartService;
import com.felece.project.service.OrderService;
import com.felece.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

}
