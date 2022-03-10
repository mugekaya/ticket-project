package com.felece.project.contoller;

import com.felece.project.entity.Order;
import com.felece.project.entity.Quantity;
import com.felece.project.entity.Route;
import com.felece.project.entity.Vehicle;
import com.felece.project.service.OrderService;
import com.felece.project.service.RouteService;
import com.felece.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private UserService userService;

    @GetMapping("/sell")
    public String sell(Model model) {
        List<Route> routes = routeService.getAllRoutes();
        List<Route> routeList = new ArrayList<>();

        for (int i = 0; i < routes.size(); i++) {
            Vehicle vehicle = routes.get(i).getVehicle();
            if ((routes.get(i).getSoldSeat() != null) &&
                    vehicle.getCapacity() > routes.get(i).getSoldSeat()) {
                routeList.add(routes.get(i));
            }
        }

        model.addAttribute("quantity", new Quantity());
        model.addAttribute("routes", routeList);
        return "sell-page";
    }


    @PostMapping("/sell/{id}")
    public String sell2(Model model, @PathVariable Long id, @ModelAttribute Quantity quantity) {
        Route route = routeService.findRouteById(id);
        if (route.getVehicle().getCapacity() < (route.getSoldSeat() + quantity.getQuantity())) {
            return "404";
        }

        Order order = new Order();
        order.setOrderStatus("Satıldı");
        order.setOrderDate(route.getDepartureTime());
        order.setRouteName(route.getRouteName());
        order.setPrice(route.getPrice() * quantity.getQuantity());
        order.setUser(userService.getAdminUser());

        orderService.createOrder(order);
        route.setSoldSeat(route.getSoldSeat() + quantity.getQuantity());
        route.setRemainTicket(route.getVehicle().getCapacity() - route.getSoldSeat());
        routeService.save(route);

        return "redirect:/order/sell";
    }

    @GetMapping("/all")
    public String orderList(Model model) {
        List<Order> orders = orderService.getOrderByStatus("Satıldı");

        model.addAttribute("orders", orders);
        return "order-list";
    }

    @GetMapping("/cancel/{orderId}")
    public String cancelOrder(Model model, @PathVariable Long orderId) {
        Order order = orderService.findOrderById(orderId);
        order.setOrderStatus("IPTAL");
        orderService.updateOrder(order);
        return "redirect:/order/all";
    }

    @GetMapping("/cancel/all")
    public String cancelOrders(Model model) {
        model.addAttribute("orders", orderService.getOrderByStatus("IPTAL"));
        return "order-list";
    }

    @GetMapping("/update/{orderId}")
    public String updateOrder(@PathVariable Long orderId){
        Order order = orderService.findOrderById(orderId);
        order.setOrderStatus("Satıldı");
        orderService.updateOrder(order);
        return "redirect:/order/all";
    }
}
