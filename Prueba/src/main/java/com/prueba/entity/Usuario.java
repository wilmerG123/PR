package com.prueba.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Long IdUsuario;
	/*
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "Usuarios_Rol",
        joinColumns = @JoinColumn(name = "id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_rol"))*/
	
	@ManyToOne
	@JoinColumn(name="id_rol")
	private Rol rol;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="activo")
	private char Activo;
	




	public Usuario(Long idUsuario, Rol rol, String nombre, char activo) {
		super();
		IdUsuario = idUsuario;
		this.rol = rol;
		this.nombre = nombre;
		Activo = activo;
	}


	public Usuario() {
		super();
	}


	public Long getIdUsuario() {
		return IdUsuario;
	}


	public void setIdUsuario(Long idUsuario) {
		IdUsuario = idUsuario;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public char getActivo() {
		return Activo;
	}


	public void setActivo(char activo) {
		Activo = activo;
	}


	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}







}
