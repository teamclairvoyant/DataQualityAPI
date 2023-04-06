package com.cv.dataqualityapi.service;

import java.util.List;

import com.cv.dataqualityapi.model.Clients;

public interface ClientService {
	
	public List<Clients> getClients();

	public String insertClients(Clients clients) throws Exception;
	
	public String deleteClients(Clients clients) throws Exception;

	String updateClients(Clients clients) throws Exception;
}
