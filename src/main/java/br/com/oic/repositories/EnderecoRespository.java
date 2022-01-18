package br.com.oic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.oic.domain.Endereco;

@Repository
public interface EnderecoRespository extends JpaRepository<Endereco, Integer> {

}
