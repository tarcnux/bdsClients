package br.com.tarcnux.bdsClients.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.tarcnux.bdsClients.dto.ClientDTO;
import br.com.tarcnux.bdsClients.entities.Client;
import br.com.tarcnux.bdsClients.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	@Transactional(readOnly = true)
	public List<ClientDTO> findALL() {
		
		List<Client> listClient = clientRepository.findAll();
		List<ClientDTO> listClientDTO = listClient.stream()
				.map(cli -> new ClientDTO(cli)).collect(Collectors.toList());
		
		return listClientDTO;
	}
}
