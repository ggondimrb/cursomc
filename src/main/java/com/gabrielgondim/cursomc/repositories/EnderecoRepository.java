package com.gabrielgondim.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabrielgondim.cursomc.domain.Categoria;
import com.gabrielgondim.cursomc.domain.Cliente;
import com.gabrielgondim.cursomc.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
