package com.felece.project.service.impl;

import com.felece.project.entity.Route;
import com.felece.project.entity.User;
import com.felece.project.entity.Vehicle;
import com.felece.project.repository.VehicleRepository;
import com.felece.project.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public void deleteVehicleById(Long vehicleId) {
        vehicleRepository.deleteById(vehicleId);
    }

    @Override
    public Vehicle save(Vehicle newVehicle) {
        return vehicleRepository.save(newVehicle);
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.getById(id);
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }
}
