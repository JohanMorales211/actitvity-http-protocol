package com.eam.protocolo.http.repositories;

import com.eam.protocolo.http.models.entities.TouristPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TouristPackageRepository extends JpaRepository<TouristPackage, Integer> {
}
