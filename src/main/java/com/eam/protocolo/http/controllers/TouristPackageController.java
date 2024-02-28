package com.eam.protocolo.http.controllers;

import com.eam.protocolo.http.models.dtos.PersonDTO;
import com.eam.protocolo.http.models.dtos.TouristPackageDTO;
import com.eam.protocolo.http.models.entities.Person;
import com.eam.protocolo.http.models.entities.TouristPackage;
import com.eam.protocolo.http.services.PersonService;
import com.eam.protocolo.http.services.TouristPackageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class TouristPackageController {

    @Autowired
    private TouristPackageService touristPackageService;

    @GetMapping("/get-tourist-packages")
    public ResponseEntity getTouristPackages() {
        List<TouristPackage> lstTouristPackages = touristPackageService.findAll();
        return ResponseEntity.ok(lstTouristPackages);
    }

    @PostMapping("/save-tourist-package")
    public ResponseEntity save(@ModelAttribute TouristPackageDTO touristPackageDTO) {
        try {
            touristPackageService.factory(touristPackageDTO);
            return ResponseEntity.ok("Guardado Exitosamente");
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return  null;
    }
}
