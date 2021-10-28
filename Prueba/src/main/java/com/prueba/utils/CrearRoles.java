package com.prueba.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.prueba.entity.Rol;
import com.prueba.enums.RolNombre;
import com.prueba.services.RolService;

@Component
public class CrearRoles implements CommandLineRunner {
	
	@Autowired
	RolService rolService;

	@Override
	public void run(String... args) throws Exception {

		/*
		Rol rolAdministrador = new Rol(RolNombre.ADMINISTRADOR);
		Rol rolAuditor = new Rol(RolNombre.AUDITOR);
		Rol rolAuxiliar = new Rol(RolNombre.AUXILIAR);

		rolService.save(rolAdministrador);
		rolService.save(rolAuditor);
		rolService.save(rolAuxiliar);
*/
	}
	

}