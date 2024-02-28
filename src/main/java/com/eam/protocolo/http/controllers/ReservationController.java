package com.eam.protocolo.http.controllers;

import com.eam.protocolo.http.models.entities.Person;
import com.eam.protocolo.http.models.entities.Reservation;
import com.eam.protocolo.http.services.PersonService;
import com.eam.protocolo.http.services.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/get-reservations")
    public ResponseEntity getReservations() {
        List<Reservation> lstReservations = reservationService.findAll();
        return ResponseEntity.ok(lstReservations);
    }

}
