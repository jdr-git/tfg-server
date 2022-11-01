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

import com.jdr.tfg.modelo.beams.Inmueble;
import com.jdr.tfg.modelo.beams.Usuario;
import com.jdr.tfg.modelo.repositorio.InmuebleRepositorio;
import com.jdr.tfg.modelo.repositorio.UsuarioRepositorio;

@CrossOrigin
@RestController
@RequestMapping("/inmuebles")
public class InmuebleControlador {

	@Autowired
	private InmuebleRepositorio iRepo;

	@GetMapping("/mostrarTodos")
	public List<Inmueble> encontrarTodosInmuebles() {
		return iRepo.findAll();
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/crear")
	public String insertarInmueble(@RequestBody Inmueble inmueble) {
		iRepo.save(inmueble);
		return "Nuevo registro insertado";
	}

	@DeleteMapping("/borrar/{id}")
	public String borrarInmueble(@PathVariable("id") String id) {
		iRepo.deleteById(id);
		return "Registro borrado";
	}

}
