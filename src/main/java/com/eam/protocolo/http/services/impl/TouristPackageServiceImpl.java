package com.eam.protocolo.http.services.impl;

import com.eam.protocolo.http.models.dtos.TouristPackageDTO;
import com.eam.protocolo.http.models.entities.TouristPackage;
import com.eam.protocolo.http.repositories.TouristPackageRepository;
import com.eam.protocolo.http.services.TouristPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
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

    @Override
    public TouristPackage factory(TouristPackageDTO touristPackageDTO) throws ParseException {
        TouristPackage touristPackage = new TouristPackage();
        touristPackage.setPrice(touristPackageDTO.getPrice());
        touristPackage.setName(touristPackageDTO.getName());
        touristPackage.setTime(touristPackageDTO.getTime());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        touristPackage.setDate(dateFormat.parse(touristPackageDTO.getDate()));
        return save(touristPackage);
    }
}
