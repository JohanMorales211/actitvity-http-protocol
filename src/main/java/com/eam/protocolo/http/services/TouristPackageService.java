package com.eam.protocolo.http.services;

import com.eam.protocolo.http.models.entities.TouristPackage;

import java.util.List;

public interface TouristPackageService {
    public List<TouristPackage> findAll();
    public TouristPackage save(TouristPackage touristPackage);
    public TouristPackage findById(Integer id);
    public void delete(Integer id);
}
