package br.com.tarcnux.bdsClients.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.tarcnux.bdsClients.dto.ClientDTO;
import br.com.tarcnux.bdsClients.entities.Client;
import br.com.tarcnux.bdsClients.repositories.ClientRepository;
import br.com.tarcnux.bdsClients.services.exceptions.DataBaseException;
import br.com.tarcnux.bdsClients.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		
		Page<Client> listClient = clientRepository.findAll(pageRequest);
		
		Page<ClientDTO> listClientDTO = listClient.map(cli -> new ClientDTO(cli));
		
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

	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		
		try {
			Client entity = clientRepository.getOne(id);
			entity.setName(dto.getName());
			entity.setCpf(dto.getCpf());
			entity.setBirthDate(dto.getBirthDate());
			entity.setIncome(dto.getIncome());
			entity.setChildren(dto.getChildren());
			
			entity = clientRepository.save(entity);
			
			return new ClientDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(String.format("Id %d not found", id));
		}
	}

	public void delete(Long id) {
		try {
			clientRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(String.format("Id %d not found", id));
		} catch (DataIntegrityViolationException e) {
			//Referential integrity violation, in this case is not applicable, but leave it.
			throw new DataBaseException("Integrity Violation");
		}
		
	}
}
