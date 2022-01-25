package br.com.oic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.oic.domain.Categoria;
import br.com.oic.repositories.CategoriaRepository;
import br.com.oic.services.exceptions.DataIntegrityException;
import br.com.oic.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired //instanceia a dependencia automaticamente 
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id +", Tipo: "+ Categoria.class.getName()));
		
	}
	
	//insere na tabela
	public Categoria insert(Categoria obj) {
		
		obj.setId(null);
		return repo.save(obj);
	}
	
	
	//atualiza na tabela
	public Categoria update(Categoria obj) {
		
		find(obj.getId());
		return repo.save(obj);
	}
	
	//deleta na tabela
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}
	
	public List<Categoria> findAll(){
		return  repo.findAll();
	}

}
