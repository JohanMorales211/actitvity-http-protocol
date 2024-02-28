package com.eam.protocolo.http.controllers;

import com.eam.protocolo.http.models.dtos.PersonDTO;
import com.eam.protocolo.http.models.entities.Person;
import com.eam.protocolo.http.models.entities.Reservation;
import com.eam.protocolo.http.services.PersonService;
import com.eam.protocolo.http.services.ReservationService;
import com.eam.protocolo.http.services.TouristPackageService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private TouristPackageService touristPackageService;

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/get-persons")
    public ResponseEntity getPersons() {
        List<Person> lstPersons = personService.findAll();
        return ResponseEntity.ok(lstPersons);
    }

    @PostMapping("/save-person")
    public ResponseEntity save(@ModelAttribute PersonDTO personDTO) {
        System.err.println("xd");
        personService.factory(personDTO);
        return ResponseEntity.ok("Guardado Exitosamente");
    }

    @GetMapping("/edit-person/{idPerson}/{idTouristPackage}/{date}/{amount}")
    public ResponseEntity editPerson(@PathVariable Integer idPerson, @PathVariable Integer idTouristPackage,
                                             @PathVariable String date, @PathVariable Integer amount) {
        try {
            Reservation reserv = reservationService.factory(idPerson, idTouristPackage, date, amount);
            return ResponseEntity.ok(reserv);
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
