package com.bal.asha.nurture.server.app.vehicle.rest;

import com.bal.asha.nurture.server.app.vehicle.domain.Vehicle;
import com.bal.asha.nurture.server.app.vehicle.dto.VehicleDto;
import com.bal.asha.nurture.server.app.vehicle.service.VehicleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Collection;
import java.util.function.Predicate;


@Slf4j
@Validated
@RestController
@AllArgsConstructor
public class VehicleController {

    private VehicleService vehicleService;

    @GetMapping("vehicle/persist")
    public Vehicle createNewVehicle(){
        //log.info("Going to Create Anonymous Vehicle");
        final Vehicle vehicle = Vehicle.create("type","modelCode", "brandName", LocalDate.now());
        return this.vehicleService.save(vehicle);
    }

   @GetMapping("search/projection")
    public Collection<VehicleDto> dynamicProjection(@QuerydslPredicate(root = Vehicle.class) Predicate predicate) {
        return vehicleService.findByBrandName("Ferrari", VehicleDto.class);
    }

    //@Cacheable("vehicle")
    @GetMapping("search/cache")
    public Iterable<Vehicle> cache(@QuerydslPredicate(root = Vehicle.class) Predicate predicate) {
       // log.info("Going to search in car database");
        return vehicleService.findAll(predicate);
    }

    @GetMapping("search/class")
    public Collection<VehicleDto> dynamicProjection() {
        return vehicleService.findBy(VehicleDto.class);
    }

}
