package com.prueba.entity.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.entity.Usuario;
import com.prueba.repository.RolRepository;
import com.prueba.repository.UsuarioRepository;
import com.prueba.utils.Mensaje;

@RestController
@RequestMapping("/prueba")
public class UsuarioController {

	@Autowired
	UsuarioRepository repo;

	@Autowired
	RolRepository rolrepo;

	@PostMapping("/usuario")
	public ResponseEntity<?> CrearUsuario(@RequestBody Usuario usuario, BindingResult bindingResult) {

		
		
		if (bindingResult.hasErrors())
			return new ResponseEntity(new Mensaje("Campos Mal Puestos"), HttpStatus.BAD_REQUEST);

		if (repo.existsByNombre(usuario.getNombre()))
			return new ResponseEntity(new Mensaje("Ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
		
		if (!rolrepo.existsById(usuario.getRol().getIdRol()))
			return new ResponseEntity(new Mensaje("Ese rol no existe"), HttpStatus.BAD_REQUEST);

		repo.save(usuario);

		return new ResponseEntity(new Mensaje("Usuario Guardado"), HttpStatus.CREATED);
	}

	@PutMapping("/usuario/{id}")
	public ResponseEntity<?> modificarUsuario(@RequestBody Usuario usuario, @PathVariable Long id,
			BindingResult bindingResult) {

		Optional<Usuario> Busqueda = repo.findById(id);

		String nombreEntrante = usuario.getNombre();

		if (Busqueda.get().getNombre() == nombreEntrante) {

			if (bindingResult.hasErrors())
				return new ResponseEntity(new Mensaje("Campos Mal Puestos"), HttpStatus.BAD_REQUEST);

			usuario.setIdUsuario(id);

			repo.save(usuario);

		}

		if (repo.existsByNombre(usuario.getNombre()))
			return new ResponseEntity(new Mensaje("Ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);

		usuario.setIdUsuario(id);

		repo.save(usuario);

		return new ResponseEntity(new Mensaje("Usuario Modificado"), HttpStatus.ACCEPTED);

	}

	@GetMapping("/usuario")
	public List<Usuario> listaDeUsuarios() {

		return repo.findAll();
	}

	@GetMapping("/usuario/{nombre}")
	public List<Usuario> listaDeUsuariosXnombre(@PathVariable String nombre) {

		return repo.findByNombre(nombre);
	}

	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<?> borrarUsuario(@PathVariable Long id) {

		repo.deleteById(id);

		return new ResponseEntity(new Mensaje("Usuario Eliminado"), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/usuarion/{nombre}")
	public ResponseEntity<?> borrarUsuario(@PathVariable String nombre) {

		repo.deleteByNombre(nombre);

		return new ResponseEntity(new Mensaje("Usuario Eliminado"), HttpStatus.ACCEPTED);
	}

}
