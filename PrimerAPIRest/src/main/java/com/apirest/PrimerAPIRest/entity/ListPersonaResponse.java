package com.apirest.PrimerAPIRest.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ListPersonaResponse {
	
	@JsonProperty( "userList" )
	private List<Usuario> list;
	
	public ListPersonaResponse() {
	}

	

	public ListPersonaResponse(List<Usuario> list) {
		super();
		this.list = list;
	}



	public List<Usuario> getList() {
		return list;
	}

	public void setList(List<Usuario> list) {
		this.list = list;
	}
	
}
