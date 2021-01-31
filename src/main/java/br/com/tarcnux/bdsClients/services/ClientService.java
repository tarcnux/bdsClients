package br.com.tarcnux.bdsClients.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.tarcnux.bdsClients.dto.ClientDTO;
import br.com.tarcnux.bdsClients.entities.Client;
import br.com.tarcnux.bdsClients.repositories.ClientRepository;
import br.com.tarcnux.bdsClients.services.exceptions.ResourceNotFoundException;

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

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> optionalObjClient = clientRepository.findById(id);	
//		Client entityClient = optionalObjClient.get();
		Client entityClient = optionalObjClient.orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
		return new ClientDTO(entityClient);
	}

	@Transactional		
	public ClientDTO insert(ClientDTO dto) {
		Client entity = new Client();
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setBirthDate(dto.getBirthDate());
		entity.setIncome(dto.getIncome());
		entity.setChildren(dto.getChildren());
		
		entity = clientRepository.save(entity);
		
		return new ClientDTO(entity);
	}
}
