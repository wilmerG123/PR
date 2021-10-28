package com.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.entity.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{
	
	boolean existsByIdRol(Long id);

}
