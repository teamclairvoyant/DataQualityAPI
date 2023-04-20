package com.cv.dataqualityapi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
			Clients client = clientRepository.getClientByClientName(clients.getClientName());
			clientRepository.delete(client);
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

	@Override
	public List<Clients> getAllClients(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<Clients> pagedResult = clientRepository.findAll(paging);

		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Clients>();
		}
	}

	@Override
	public List<Clients> getClientsByIds(List<Integer> ids) {
		List<Clients> findAllById = clientRepository.findAllById(ids);
		return findAllById;
	}

}
