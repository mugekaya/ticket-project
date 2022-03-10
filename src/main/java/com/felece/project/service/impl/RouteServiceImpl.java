package com.felece.project.service.impl;

import com.felece.project.entity.Route;
import com.felece.project.repository.RouteRepository;
import com.felece.project.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    @Override
    public Route updateRoute(Long routeId, Route newRoute) {
        return null;
    }

    @Override
    public void deleteRouteById(Long routeId) {
        routeRepository.deleteById(routeId);
    }

    @Override
    public Route save(Route newRoute) {
        return routeRepository.save(newRoute);
    }

    @Override
    public Route findRouteById(Long id) {
        return routeRepository.findById(id).get();
    }
}
