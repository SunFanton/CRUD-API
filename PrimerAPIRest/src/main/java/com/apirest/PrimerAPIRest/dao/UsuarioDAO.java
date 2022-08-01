package com.apirest.PrimerAPIRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.PrimerAPIRest.entity.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario,Long>{

}
