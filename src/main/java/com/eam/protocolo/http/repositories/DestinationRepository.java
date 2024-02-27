package com.eam.protocolo.http.repositories;

import com.eam.protocolo.http.models.entities.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository  extends JpaRepository<Destination, Integer> {
}
