package com.felece.project.contoller;

import com.felece.project.entity.Order;
import com.felece.project.entity.Route;
import com.felece.project.entity.User;
import com.felece.project.entity.Vehicle;
import com.felece.project.service.OrderService;
import com.felece.project.service.RouteService;
import com.felece.project.service.UserService;
import com.felece.project.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private RouteService routeService;

    @GetMapping("/")
    public String adminPage(Model model) {
        List<Route> route = routeService.getAllRoutes();

        model.addAttribute("routes", route);
        return "admin-page";
    }


    // Kullanıcı işlemleri


    @GetMapping("/user/all")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user-list";
    }


    @GetMapping("/user/create")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "create-user";
    }

    @PostMapping("/user/create")
    public String createUser(User newUser) {
        userService.save(newUser);
        return "redirect:/admin/user/all";
    }

    @GetMapping("/user/{userId}")
    public String updateOneUser(@PathVariable Long userId, Model model) {
        User user = userService.findUserByUserId(userId);
        model.addAttribute("user", user);
        return "create-user";
    }

    @GetMapping("/delete/user/{userId}")
    public String deleteOneUser(@PathVariable Long userId) {
        userService.deleteById(userId);
        return "redirect:/admin/allUsers";
    }


    //Rota işlemleri

    @GetMapping("route/createRoute")
    public String routePage(Model model) {
        model.addAttribute("route", new Route());
        return "create-route";
    }

    @RequestMapping(value = "/route/createRoute", method = RequestMethod.POST)
    public String createRoute(@ModelAttribute Route newRoute) {
        routeService.save(newRoute);
        return "redirect:/admin/";
    }


    @GetMapping("/route/{id}")
    public String updateRoute(@PathVariable Long id, Model model) {
        model.addAttribute("route", routeService.findRouteById(id));
        return "create-route";
    }


    @GetMapping("/route/delete/{routeId}")
    public String deleteRoute(@PathVariable Long routeId) {
        routeService.deleteRouteById(routeId);
        return "redirect:/admin/";
    }


    //Araç işlemleri
    @GetMapping("/vehicle/all")
    public String allVehicle(Model model) {
        model.addAttribute("vehicles", vehicleService.getAll());
        return "vehicle-list";
    }

    @GetMapping("/vehicle/create")
    public String createVehicle(Model model) {
        model.addAttribute("vehicle",new Vehicle());
        return "create-vehicle";
    }


    @GetMapping("/vehicle/{id}")
    public String updateVehicle(@PathVariable Long id, Model model) {
        model.addAttribute("vehicle", vehicleService.getVehicleById(id));
        return "create-vehicle";
    }


    @PostMapping("/vehicle/create")
    public String createVehicle(Vehicle newVehicle) {
        vehicleService.save(newVehicle);
        return "redirect:/admin/vehicle/all";
    }

    @GetMapping("/vehicle/delete/{vehicleId}")
    public String deleteVehicle(@PathVariable Long vehicleId) {
        vehicleService.deleteVehicleById(vehicleId);
        return "redirect:/admin/vehicle/all";
    }


    //Bilet işlemleri

    @PutMapping("/{orderId}")
    public Order updateOrder(@PathVariable Long orderId, Order newOrder) {
        return orderService.updateOrder(newOrder);
    }

}
