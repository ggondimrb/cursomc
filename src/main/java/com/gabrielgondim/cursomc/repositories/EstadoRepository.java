package com.gabrielgondim.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabrielgondim.cursomc.domain.Categoria;
import com.gabrielgondim.cursomc.domain.Cidade;
import com.gabrielgondim.cursomc.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
