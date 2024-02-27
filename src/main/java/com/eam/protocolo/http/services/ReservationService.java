package com.eam.protocolo.http.services;

import com.eam.protocolo.http.models.entities.Reservation;

import java.util.List;

public interface ReservationService {
    public List<Reservation> findAll();
    public Reservation save(Reservation reservation);
    public Reservation findById(Integer id);
    public void delete(Integer id);
}
