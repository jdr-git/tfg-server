package com.jdr.tfg.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jdr.tfg.modelo.beams.Usuario;
import com.jdr.tfg.modelo.repositorio.UsuarioRepositorio;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

	@Autowired
	private UsuarioRepositorio uRepo;

	@GetMapping("/mostrarTodos")
	public List<Usuario> encontrarTodosUsuarios() {
		return uRepo.findAll();
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/crear")
	public String insertarUsuario(@RequestBody Usuario usuario) {
		uRepo.save(usuario);
		return "Nuevo registro insertado";
	}

	@DeleteMapping("/borrar/{id}")
	public String borrarUsuario(@PathVariable("id") String id) {
		uRepo.deleteById(id);
		return "Registro borrado";
	}

}
