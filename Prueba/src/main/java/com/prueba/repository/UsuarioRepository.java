package com.prueba.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.entity.Usuario;

@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	boolean existsByNombre(String nombreUsuario);
	
	public void deleteByNombre(String nombreUsuario);
	
	public List<Usuario> findByNombre(String nombreUsuario);
	
	public Optional<Usuario> findById (Long id);

}
