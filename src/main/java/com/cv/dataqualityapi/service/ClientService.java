package com.cv.dataqualityapi.service;

import java.util.List;

import com.cv.dataqualityapi.model.Clients;
import com.cv.dataqualityapi.model.Rules;

public interface ClientService {
	
	public List<Clients> getClients();

	public String insertClients(Clients clients) throws Exception;
	
	public String deleteClients(Clients clients) throws Exception;

	String updateClients(Clients clients) throws Exception;

	public List<Clients> getAllClients(Integer pageNo, Integer pageSize, String sortBy);

	public List<Clients> getClientsByIds(List<Integer> ids);
}
