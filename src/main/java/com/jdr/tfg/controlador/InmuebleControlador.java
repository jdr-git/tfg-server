package com.jdr.tfg.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.el.stream.Optional;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jdr.tfg.modelo.beams.Inmueble;
import com.jdr.tfg.modelo.beams.Usuario;
import com.jdr.tfg.modelo.repositorio.InmuebleRepositorio;
import com.jdr.tfg.modelo.repositorio.UsuarioRepositorio;

@CrossOrigin(origins = "http://localhost:8089")
@RestController
@RequestMapping("/inmuebles")
public class InmuebleControlador {

	@Autowired
	private InmuebleRepositorio iRepo;
	
	// === OPERACIONES CRUD ===
	
	// === CREATE ===
	
	// ToDo: Bloque try-catch (inmueble existe; server_error)
	@PostMapping("/crear")
	public ResponseEntity<Inmueble> insertarInmueble(@RequestBody Inmueble inmueble) {
		return new ResponseEntity<>(iRepo.save(inmueble), HttpStatus.CREATED);
	}
	
	// === READ ===
	
	// ToDo: Bloque try-catch (colección vacía; server_error)
	@GetMapping("/mostrarTodos")
	public ResponseEntity<List<Inmueble>> encontrarTodosLosInmuebles(@RequestParam(required = false) String inmuebleId) {
		return new ResponseEntity<>(iRepo.findAll(), HttpStatus.OK);
	}
	
	// ToDo: Bloque try-catch (inmueble no existe)
	@GetMapping("/mostrar/{id}")
	public ResponseEntity<Inmueble> encontrarInmueblePorId(@PathVariable("id") String id) {
		return new ResponseEntity<>(iRepo.findById(id).get(), HttpStatus.OK);
	}
	
	// === UPDATE ===
	
	// ToDo: Bloque try-catch (inmueble no existe; error en la actualización; server_error)
	@PutMapping("/modificar/{id}")
	public ResponseEntity<Inmueble> modificarInmueblePorId(@PathVariable("id") String id, @RequestBody Inmueble inmuebleConCambios) {
		Inmueble inmueble = iRepo.findById(id).get();
		inmueble.setTipoOperacion(inmuebleConCambios.getTipoOperacion());
		inmueble.setPais(inmuebleConCambios.getPais());
		inmueble.setZona(inmuebleConCambios.getZona());
		inmueble.setArea(inmuebleConCambios.getArea());
		inmueble.setTipoInmueble(inmuebleConCambios.getTipoInmueble());
		inmueble.setPrecio(inmuebleConCambios.getPrecio());
		inmueble.setUrlImagen(inmuebleConCambios.getUrlImagen());
		inmueble.setGuardadoPor(inmuebleConCambios.getGuardadoPor());
		return new ResponseEntity<>(iRepo.save(inmueble), HttpStatus.OK);	
	}
	
	// MÉTODO PARA AÑADIR UN INMUEBLE COMO FAVORITO PARA UN CLIENTE
	// ToDo: Bloque try-catch (inmueble no existe; error en la actualización; server_error)
	@PutMapping("/guardarPara/{id}")
	public ResponseEntity<Inmueble> guardarInmuebleParaClientePorId(@PathVariable("id") String id) {
		String mensaje;
		Inmueble inmueble = iRepo.findById(id).get();
		List<String> interesados = new ArrayList<String>();
		interesados = inmueble.getGuardadoPor();
		//! NO FUNCIONA cuando guardadoPor null
		//if(interesados == null) {
			//interesados.add(0, "Cliente obtenido como objeto de sesión");
			//mensaje = "Cliente obtenido como objeto de sesión";
			//System.out.println(mensaje);
		//} else {
			//interesados.add("Cliente obtenido como objeto de sesión");
		//}
		interesados.add("Cliente obtenido como objeto de sesión");
		inmueble.setGuardadoPor(interesados);
		return new ResponseEntity<>(iRepo.save(inmueble), HttpStatus.OK);	
	}
	
	// === DELETE ===
	
	// ToDo: Bloque try-catch (mensaje si inmueble no existe; error en el borrado; server_error)
	@DeleteMapping("/borrar/{id}")
	public Map<String, Boolean> borrarInmueblePorId(@PathVariable("id") String id) {
		Inmueble inmueble = iRepo.findById(id).get();
		iRepo.delete(inmueble);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("Inmueble eliminado", Boolean.TRUE);
		return respuesta;
	}

}
