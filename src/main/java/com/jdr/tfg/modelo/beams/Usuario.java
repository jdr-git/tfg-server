package com.jdr.tfg.modelo.beams;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//? Especifica "usuarios" si no, falla;
//? Es el nombre de la colección (no la ruta de GetMapping)
@Document("usuarios")
public class Usuario {

	// ? Quito @Id; si pongo @Id para nombre no lo muestra bien
	@Id
	private String usuarioId;
	private String nombre;
	private String email;
	private String rol;

	public Usuario() {
		super();
	}

	// ? ¿Hace falta?
	public Usuario(String nombre, String email, String rol) {
		super();
		this.usuarioId = usuarioId;
		this.nombre = nombre;
		this.email = email;
		this.rol = rol;
	}

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}
