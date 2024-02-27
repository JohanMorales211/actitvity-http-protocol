package com.eam.protocolo.http.services.impl;

import com.eam.protocolo.http.models.entities.Reservation;
import com.eam.protocolo.http.repositories.ReservationRepository;
import com.eam.protocolo.http.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation findById(Integer id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        reservationRepository.deleteById(id);
    }
}
