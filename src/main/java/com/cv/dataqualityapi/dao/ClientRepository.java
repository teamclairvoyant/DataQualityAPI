package com.cv.dataqualityapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cv.dataqualityapi.model.Clients;

@Repository
public interface ClientRepository extends ClientDao, JpaRepository<Clients, Integer>{

//	@Query(value = "SELECT * FROM Clients c WHERE LOWER(c.client_name) = ?1", nativeQuery = true)
//	Clients findClientByClientName(String clientName);
}
