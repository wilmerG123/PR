package com.prueba.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.entity.Rol;
import com.prueba.repository.RolRepository;;

@Service
@Transactional	
public class RolService {
	
	@Autowired
	RolRepository rolrepo;
	
	public void save(Rol rol) {
		
		rolrepo.save(rol);
	}

}
