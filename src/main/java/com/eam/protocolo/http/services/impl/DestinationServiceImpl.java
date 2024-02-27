package com.eam.protocolo.http.services.impl;

import com.eam.protocolo.http.models.entities.Destination;
import com.eam.protocolo.http.repositories.DestinationRepository;
import com.eam.protocolo.http.services.DestinationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DestinationServiceImpl implements DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;
    @Override
    public List<Destination> findAll() {
        return destinationRepository.findAll();
    }

    @Override
    public Destination save(Destination destination) {
        return destinationRepository.save(destination);
    }

    @Override
    public Destination findById(Integer id) {
        return destinationRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        destinationRepository.deleteById(id);
    }
}
