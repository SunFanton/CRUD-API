package com.springdemo.UserProjectSpring.service;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.UserProjectSpring.entity.ListPersonaResponse;
import com.springdemo.UserProjectSpring.entity.Usuario;
import com.springdemo.UserProjectSpring.exceptions.BOException;

@Service
public class UsuarioServiceImp implements UsuarioService{

	@Autowired
	WebTarget webTarget;
	
	//-------------------------------------------
	
	//METODOS
	
	//LISTAR----------
	@Override
	public List<Usuario> listarUsuarios() throws BOException{
		
		List<Usuario> personas = new ArrayList<Usuario>();
		
		try {
			
			Response response = webTarget.request(MediaType.APPLICATION_JSON)
		  			 					 .get();
			
			try {
				if (response.getStatus() == HttpURLConnection.HTTP_OK) {
					ListPersonaResponse lp = response.readEntity(ListPersonaResponse.class);
					
					personas.addAll(lp.getList());
				}
				else {
					throw new BOException("Error de invocacion " + response.getStatus());
				}
			} finally {
				response.close();
			}
			
		}
		catch(Throwable e) {
			
			throw new BOException(e);
		}
		
		return personas;
		
		/*ListPersonaResponse listR = webTarget.request(MediaType.APPLICATION_JSON)
				 							 .get(ListPersonaResponse.class);

		List<Usuario> personas = listR.getList();
		
		return personas;*/
		
	}

	//OBTENER POR ID----------
	@Override
	public Usuario obtenerPorId(int id) throws BOException{
		
		Usuario user = new Usuario();
		
		try {
			
			Response response = webTarget.path(String.valueOf(id))
									.request(MediaType.APPLICATION_JSON)
			  			 			.get();
			
			try {
				if (response.getStatus() == HttpURLConnection.HTTP_OK) {
					user = response.readEntity(Usuario.class);
				}
				else {
					throw new BOException("Error de invocacion " + response.getStatus());
				}
			} finally {
				response.close();
			}
			
		}
		catch(Throwable e) {
			
			throw new BOException(e);
		}
		
		return user;
		
		/*Usuario user = webTarget.path(String.valueOf(id))
	  			 			.request(MediaType.APPLICATION_JSON)
	  			 			.get(Usuario.class);
		
		return user;*/

	}

	//INSERTAR NUEVO USUARIO----------
	@Override
	public int alta(Usuario usuario) throws BOException{
		
		int codResp = 0;
		
		try {
			
			Response rPost = webTarget.request(MediaType.APPLICATION_JSON)
					  				  .post(Entity.json(usuario));
			
			try {
				if (rPost.getStatus() == HttpURLConnection.HTTP_OK) {
					codResp = rPost.getStatus();
				}
				else {
					throw new BOException("Error de invocacion " + rPost.getStatus());
				}
			} finally {
				rPost.close();
			}
			
		}
		catch(Throwable e) {
			
			throw new BOException(e);
		}
		
		return codResp;
		
		/*Response rPost = webTarget.request(MediaType.APPLICATION_JSON)
 				  .post(Entity.json(usuario));

		int codResp = rPost.getStatus();
		rPost.close();
		
		return codResp;*/
	}

	//ACTUALIZAR USUARIO----------
	@Override
	public int update(Usuario usuario) throws BOException{
		
		int codResp = 0;
		
		try {
			
			Response rPut = webTarget.request(MediaType.APPLICATION_JSON)
	 				  				 .put(Entity.json(usuario));
			
			try {
				if (rPut.getStatus() == HttpURLConnection.HTTP_OK) {
					codResp = rPut.getStatus();
				}
				else {
					throw new BOException("Error de invocacion " + rPut.getStatus());
				}
			} finally {
				
				rPut.close();
			}
			
		}
		catch(Throwable e) {
			
			throw new BOException(e);
		}
		
		return codResp;
		
		/*Response rPut = webTarget.request(MediaType.APPLICATION_JSON)
 				  .put(Entity.json(usuario));

		int codResp = rPut.getStatus();
		rPut.close();
		
		return codResp;*/
		
	}

	//ELIMINAR USUARIO----------
	@Override
	public int eliminar(int id) throws BOException{
		
		int codResp = 0;
		
		try {

			Response rDelete = webTarget.path(String.valueOf(id))
					   					.request()
					   					.delete(Response.class);
			
			try {
				if (rDelete.getStatus() == HttpURLConnection.HTTP_OK) {
					codResp = rDelete.getStatus();
				}
				else {
					throw new BOException("Error de invocacion " + rDelete.getStatus());
				}
			} finally {
				
				rDelete.close();
			}
			
		}
		catch(Throwable e) {
			
			throw new BOException(e);
		}
		
		return codResp;
		
		/*Response rDelete = webTarget.path(String.valueOf(id))
				   					 .request()
				   					 .delete(Response.class);

		int codResp = rDelete.getStatus();
		rDelete.close();
		
		return codResp;*/
	}


}
