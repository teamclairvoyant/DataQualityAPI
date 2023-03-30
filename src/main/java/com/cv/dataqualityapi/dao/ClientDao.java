package com.cv.dataqualityapi.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cv.dataqualityapi.model.Clients;

@Repository
public interface ClientDao extends JpaRepository<Clients, Integer> {

}
