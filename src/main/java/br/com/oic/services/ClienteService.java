package br.com.oic.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.oic.domain.Cliente;
import br.com.oic.repositories.ClienteRepository;
import br.com.oic.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired //instanceia a dependencia automaticamente 
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id +", Tipo: "+ Cliente.class.getName()));
		
	}

}
