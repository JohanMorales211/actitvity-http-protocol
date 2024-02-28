package com.eam.protocolo.http.services.impl;

import com.eam.protocolo.http.models.entities.Person;
import com.eam.protocolo.http.models.entities.Reservation;
import com.eam.protocolo.http.models.entities.TouristPackage;
import com.eam.protocolo.http.repositories.ReservationRepository;
import com.eam.protocolo.http.services.PersonService;
import com.eam.protocolo.http.services.ReservationService;
import com.eam.protocolo.http.services.TouristPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private PersonService personService;

    @Autowired
    private TouristPackageService touristPackageService;

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

    @Override
    public Reservation factory(Integer idPerson, Integer idTouristPackage, String date, Integer amount) throws ParseException {
        Person personFound = personService.findById(idPerson);
        TouristPackage touristPackage = touristPackageService.findById(idTouristPackage);
        Reservation reservation = new Reservation();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        reservation.setDateReservation(dateFormat.parse(date));
        reservation.setAmountPeople(amount);
        reservation.setPerson(personFound);
        reservation.setTouristPackage(touristPackage);
        return save(reservation);
    }
}
