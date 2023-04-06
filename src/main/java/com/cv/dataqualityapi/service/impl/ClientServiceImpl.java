package com.cv.dataqualityapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cv.dataqualityapi.constants.DataQualityContants;
import com.cv.dataqualityapi.dao.ClientRepository;
import com.cv.dataqualityapi.model.Clients;
import com.cv.dataqualityapi.service.ClientService;
import com.cv.dataqualityapi.utils.BusinessException;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public List<Clients> getClients() {
		return clientRepository.findAll();
	}

	@Override
	public String insertClients(Clients clients) throws Exception {
		Integer getClientCountByClientName = clientRepository.getClientCountByClientName(clients.getClientName());
		if (getClientCountByClientName == 0) {
			clientRepository.save(clients);
			return DataQualityContants.SAVED;
		}
		throw new BusinessException("Client Already Exists");
	}

	@Override
	public String deleteClients(Clients clients) throws Exception {
		Integer getClientCountByClientName = clientRepository.getClientCountByClientName(clients.getClientName());
		if (getClientCountByClientName > 0) {
			clientRepository.delete(clients);
			return DataQualityContants.DELETED;
		}
		throw new BusinessException("Cannot delete client because it does not exists");
	}

	@Override
	public String updateClients(Clients clients) throws Exception {
		System.err.println("The client id is " + clients.getClientId());
		Boolean existsById = clientRepository.existsById(clients.getClientId());
		if (existsById) {
			clientRepository.save(clients);
			return DataQualityContants.UPDATED;
		}
		throw new BusinessException("Client Ref doesnot Exists");
	}

}
