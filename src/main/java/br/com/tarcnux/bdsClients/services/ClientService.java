package br.com.tarcnux.bdsClients.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarcnux.bdsClients.entities.Client;
import br.com.tarcnux.bdsClients.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> findALL() {
		
		return clientRepository.findAll();
	}
}