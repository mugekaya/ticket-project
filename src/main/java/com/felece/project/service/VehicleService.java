package com.felece.project.service;

import com.felece.project.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    void deleteVehicleById(Long vehicleId);

    Vehicle save(Vehicle newVehicle);

    Vehicle getVehicleById(Long id);

    List<Vehicle> getAll();
}
