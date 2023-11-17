package com.bal.asha.nurture.server.app.vehicle.service;


import com.bal.asha.nurture.server.app.vehicle.domain.Vehicle;
import com.bal.asha.nurture.server.app.vehicle.domain.VehicleRepository;
import com.bal.asha.nurture.server.app.vehicle.dto.VehicleDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.function.Predicate;

@Slf4j
@Service
@AllArgsConstructor
public class VehicleService {

    private VehicleRepository vehicleRepository;

    public Vehicle save(Vehicle vehicle) {
       // log.info("Going to save record: {}", vehicle);
        return vehicleRepository.save(vehicle);
    }

    public Collection<VehicleDto> findByBrandName(String name, Class<VehicleDto> clazz) {
      //  log.info("Going to find by: {}", name);
        return vehicleRepository.findByBrandName(name, clazz);
    }

    public Iterable<Vehicle> findAll(Predicate predicate) {
        return null;
    }

    public Collection<VehicleDto> findBy(Class<VehicleDto> vehicleDtoClass) {
        //log.info("Going to search by : {}", vehicleDtoClass);
        return vehicleRepository.findBy(VehicleDto.class);
    }
}
