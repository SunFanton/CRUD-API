package com.springdemo.UserProjectSpring.service;

import java.util.List;
import com.springdemo.UserProjectSpring.entity.Usuario;
import com.springdemo.UserProjectSpring.exceptions.BOException;

public interface UsuarioService {

	List<Usuario> listarUsuarios() throws BOException;
	
	Usuario obtenerPorId(int id) throws BOException;
	
    int alta(Usuario usuario) throws BOException;
    
    int update(Usuario usuario) throws BOException;
    
    int eliminar(int id) throws BOException;
    
}
