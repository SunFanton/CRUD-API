package com.springdemo.UserProjectSpring.controller;

import java.net.HttpURLConnection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdemo.UserProjectSpring.entity.Usuario;
import com.springdemo.UserProjectSpring.exceptions.BOException;
import com.springdemo.UserProjectSpring.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired 
	private UsuarioService userService;
	
	//----------------------------------------------------------
	
	@GetMapping("/")
    public String homeListar(Model model) {
		
		List<Usuario> usuarios;
		
		try {
			usuarios = userService.listarUsuarios();
			model.addAttribute("LISTA_USUARIOS", usuarios);
			return "index";
			
		} catch (BOException e) {
			e.printStackTrace();
			return "redirect:/error";
		}
		
    }
	
	//----------------------------------------------------------
  
	@GetMapping("/addnew")
    public String agregarNuevoUsuario(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "nuevoUsuario";
    }
    
  //----------------------------------------------------------
 
	@PostMapping("/saveNew")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        
		try {
			int codResp = userService.alta(usuario);
			
			if(codResp == HttpURLConnection.HTTP_OK)
				return "redirect:/";
			else
				return "redirect:/error";
			
		} catch (BOException e) {
			
			e.printStackTrace();
			return "redirect:/error";
		}
   
    }
    
	//----------------------------------------------------------
	
	@PostMapping("/update")
    public String actualizarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        
		try {
			int codResp = userService.update(usuario);
			
			if(codResp == HttpURLConnection.HTTP_OK)
				return "redirect:/";
			else
				return "redirect:/error";
			
		} catch (BOException e) {
			
			e.printStackTrace();
			return "redirect:/error";
		}
   
    }
	
  //----------------------------------------------------------
 
	@GetMapping("/showFormForUpdate/{id}")
    public String formularioActualiza(@PathVariable(value = "id") int id, Model model) {
        
		Usuario usuario;
		
        try {
			usuario = userService.obtenerPorId(id);
			model.addAttribute("usuario", usuario);
	        return "actualizaUsuario";
			
		} catch (BOException e) {
			
			e.printStackTrace();
			return "redirect:/error";
		}
        
    }
    
  //----------------------------------------------------------
  
	@GetMapping("/deleteEmployee/{id}")
    public String eliminarPorId(@PathVariable(value = "id") int id) {
        
		try {
			int cod = userService.eliminar(id);
			
			if(cod == HttpURLConnection.HTTP_OK)
				return "redirect:/";
			else
				return "redirect:/error";
			
		} catch (BOException e) {
			
			e.printStackTrace();
			return "redirect:/error";
		}
 
    }
	
}
