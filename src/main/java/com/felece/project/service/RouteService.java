package com.felece.project.service;

import com.felece.project.entity.Route;

import java.util.List;

public interface RouteService {

    List<Route> getAllRoutes(); //login değilken

    Route updateRoute(Long routeId, Route newRoute);

    void deleteRouteById(Long routeId);

    Route save(Route newRoute);

    Route findRouteById(Long id);
}
