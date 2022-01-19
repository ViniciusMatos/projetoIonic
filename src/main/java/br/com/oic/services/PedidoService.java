package br.com.oic.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.oic.domain.Pedido;
import br.com.oic.repositories.PedidoRepository;
import br.com.oic.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired //instanceia a dependencia automaticamente 
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id +", Tipo: "+ Pedido.class.getName()));
		
	}

}
