package com.jdr.tfg.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jdr.tfg.modelo.beams.Usuario;
import com.jdr.tfg.modelo.repositorio.UsuarioRepositorio;

@CrossOrigin(origins = "http://localhost:8089")
@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

	@Autowired
	private UsuarioRepositorio uRepo;
	
	// === OPERACIONES CRUD ===
	
	// === CREATE ===
	
	@PostMapping("/crear")
	public ResponseEntity<Usuario> insertarUsuario(@RequestBody Usuario usuario) {
		return new ResponseEntity<>(uRepo.save(usuario), HttpStatus.CREATED);
	}
		
	// === READ ===

	// ToDo: Bloque try-catch (colección vacía; server_error)
	@GetMapping("/mostrarTodos")
	public ResponseEntity<List<Usuario>> encontrarTodosLosUsuarios(@RequestParam(required = false) String usuarioId) {
		return new ResponseEntity<>(uRepo.findAll(), HttpStatus.OK);
	}
	
	// ToDo: Bloque try-catch (usuario no existe)
	@GetMapping("/mostrar/{id}")
	public ResponseEntity<Usuario> encontrarUsuarioPorId(@PathVariable("id") String id) {
		return new ResponseEntity<>(uRepo.findById(id).get(), HttpStatus.OK);
	}
	
	// ToDo: Bloque try-catch (usuario no existe)
	@GetMapping("/mostrar/{email}")
	public ResponseEntity<Usuario> encontrarUsuarioPorEmail(@PathVariable("email") String email) {
		return new ResponseEntity<>(uRepo.findById(email).get(), HttpStatus.OK);
	}
			
	// === UPDATE ===
		
	// ToDo: Bloque try-catch (inmueble no existe; error en la actualización; server_error)
	@PutMapping("/modificar/{id}")
	public ResponseEntity<Usuario> modificarUsuarioPorId(@PathVariable("id") String id, @RequestBody Usuario usuarioConCambios) {
		Usuario usuario = uRepo.findById(id).get();
		usuario.setNombre(usuarioConCambios.getNombre());
		usuario.setEmail(usuarioConCambios.getEmail());
		usuario.setContrasena(usuarioConCambios.getContrasena());
		usuario.setRol(usuarioConCambios.getRol());
		return new ResponseEntity<>(uRepo.save(usuario), HttpStatus.OK);	
	}
			
	// === DELETE ===	
	
	// ToDo: Bloque try-catch (mensaje si usuario no existe; error en el borrado; server_error)
	@DeleteMapping("/borrar/{id}")
	public Map<String, Boolean> borrarUsuarioPorId(@PathVariable("id") String id) {
		Usuario usuario = uRepo.findById(id).get();
		uRepo.delete(usuario);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("Usuario eliminado", Boolean.TRUE);
		return respuesta;
	}

}
