package com.eam.protocolo.http.services.impl;

import com.eam.protocolo.http.models.entities.TouristPackage;
import com.eam.protocolo.http.repositories.TouristPackageRepository;
import com.eam.protocolo.http.services.TouristPackageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TouristPackageServiceImpl implements TouristPackageService {

    @Autowired
    private TouristPackageRepository touristPackageRepository;
    @Override
    public List<TouristPackage> findAll() {
        return touristPackageRepository.findAll();
    }

    @Override
    public TouristPackage save(TouristPackage touristPackage) {
        return touristPackageRepository.save(touristPackage);
    }

    @Override
    public TouristPackage findById(Integer id) {
        return touristPackageRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        touristPackageRepository.deleteById(id);
    }
}
