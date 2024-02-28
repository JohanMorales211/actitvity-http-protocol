package com.eam.protocolo.http.controllers;

import com.eam.protocolo.http.models.entities.Destination;
import com.eam.protocolo.http.models.entities.Person;
import com.eam.protocolo.http.services.DestinationService;
import com.eam.protocolo.http.services.TouristPackageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @Autowired
    private TouristPackageService touristPackageService;

    @GetMapping("/get-destinations")
    public ResponseEntity getDestinations() {
        List<Destination> lstDestinations = destinationService.findAll();
        return ResponseEntity.ok(lstDestinations);
    }

    @GetMapping("/save-destination/{value}/{touristPackageId}")
    public ResponseEntity save(@PathVariable String value, @PathVariable Integer touristPackageId) {
        Destination destination = new Destination();
        destination.setValue(value);
        destination.setTouristPackage(touristPackageService.findById(touristPackageId));
        destination = destinationService.save(destination);
        return ResponseEntity.ok(destination);
    }
}
