package org.serratec.h2.grupo2.repository;

import java.util.List;

import org.serratec.h2.grupo2.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	List<Produto> findByNomeContainingIgnoreCase (String nome);
	
	List<Produto> findByCategoriaNomeIgnoreCase (String nome);
}
