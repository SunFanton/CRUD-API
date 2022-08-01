package com.springdemo.UserProjectSpring.entity;

public class Usuario {

	private long id;
	
	private String nombre;
	
	private String apellido;
	
	private int dni;
	
	private String fechaNac;
	
	private String profesion;
	
	//CONSTRUCTORES
	public Usuario() {
		
	}
	
	public Usuario(long id, String nombre, String apellido, int dni, String fechaNac, String profesion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNac = fechaNac;
		this.profesion = profesion;
	}
	
	//GETTERS Y SETTERS
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getProfesion() {
		return profesion;
	}
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
	
	
}
