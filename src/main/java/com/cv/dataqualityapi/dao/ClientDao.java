package com.cv.dataqualityapi.dao;

import com.cv.dataqualityapi.model.Clients;

public interface ClientDao {
	
	Clients getClientByClientName(String clientName);
	
	Integer getClientCountByClientName(String clientName);
	
	Boolean existsByClientName(String clientName);

}
