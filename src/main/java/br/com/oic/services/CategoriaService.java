package br.com.oic.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.oic.domain.Categoria;
import br.com.oic.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired //instanceia a dependencia automaticamente 
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
		
	}

}
