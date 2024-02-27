package com.eam.protocolo.http.services;

import com.eam.protocolo.http.models.entities.Destination;

import java.util.List;

public interface DestinationService {
    public List<Destination> findAll();
    public Destination save(Destination destination);
    public Destination findById(Integer id);
    public void delete(Integer id);
}
