package com.apirest.PrimerAPIRest.rest;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.PrimerAPIRest.dao.UsuarioDAO;
import com.apirest.PrimerAPIRest.entity.ListPersonaResponse;
import com.apirest.PrimerAPIRest.entity.Usuario;

@RestController
@RequestMapping("/usuarios/v1.0")
public class UsuarioREST {

	private final Logger log = LogManager.getLogger(UsuarioREST.class);
	
	@Autowired
	private UsuarioDAO userDAO;
	
	@GetMapping   
	public ResponseEntity<ListPersonaResponse> getUsuarios(){
		
		log.info("RECUPERANDO USUARIOS DE LA BBDD");
		
		ListPersonaResponse resp = new ListPersonaResponse(userDAO.findAll());
		
		return ResponseEntity.ok(resp);
	}
	
	@RequestMapping(value="{userId}") 
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable("userId") Long userId){
		
		log.info("OBTENIENDO PERSONA CON ID {}", userId);
		
		Optional<Usuario> optUser = userDAO.findById(userId);
		if(optUser.isPresent())
			return ResponseEntity.ok(optUser.get());
		else{
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping 
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario user){
		
		log.info("CREANDO NUEVO USUARIO");
		
		Usuario newUsuario = userDAO.save(user);
		return ResponseEntity.ok(newUsuario);
		
	}
	
	@DeleteMapping(value="{userId}")
	public ResponseEntity<Void> deleteUsuario(@PathVariable("userId") Long userId){
		
		log.info("ELIMINANDO PERSONA CON ID {}", userId);
		
		userDAO.deleteById(userId);
		return ResponseEntity.ok(null);
		
	}
	
	@PutMapping
	public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario user){
		
		log.info("ACTUALIZANDO USUARIO CON ID {}", user.getId());
		
		Optional<Usuario> optUser = userDAO.findById(user.getId());
		
		if(optUser.isPresent()){
			
			Usuario usuario = optUser.get();
			usuario.setNombre(user.getNombre());
			usuario.setApellido(user.getApellido());
			usuario.setDni(user.getDni());
			usuario.setFechaNac(user.getFechaNac());
			usuario.setProfesion(user.getProfesion());
			userDAO.save(usuario);
			return ResponseEntity.ok(usuario);
		}
		else{
			return ResponseEntity.notFound().build();
		}
		
	}
	
	//PRIMEROS EJEMPLOS--------------------------------------
	/*@GetMapping
	public ResponseEntity<Usuario> getusuario(){
		
		Usuario user = new Usuario();
		user.setId(1);
		user.setNombre("Ana");
		user.setApellido("Diaz");
		user.setDni(12345678);
		user.setFechaNac("1956-09-12");
		user.setProfesion("Medica");
		
		return ResponseEntity.ok(user);
	}*/
	
	//@GetMapping
	/*@RequestMapping(value="hello", method=RequestMethod.GET)
	public String hello() {
		return "Hello World";
	}*/
	
}
