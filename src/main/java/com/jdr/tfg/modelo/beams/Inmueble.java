package com.jdr.tfg.modelo.beams;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//? Especifica "inmuebles" si no, falla;
//? Es el nombre de la colección (no la ruta de GetMapping)

@Document("inmuebles")
public class Inmueble {

	// ? Quito @Id; si pongo @Id para nombre no lo muestra bien
	@Id
	private String inmuebleId;
	private String pais;
	private String zona;
	private String area;
	private String[] tipo;

	public Inmueble() {
		super();
	}

	public Inmueble(String inmuebleId, String pais, String zona, String area, String[] tipo) {
		super();
		this.inmuebleId = inmuebleId;
		this.pais = pais;
		this.zona = zona;
		this.area = area;
		this.tipo = tipo;
	}

	public String getInmuebleId() {
		return inmuebleId;
	}

	public void setInmuebleId(String inmuebleId) {
		this.inmuebleId = inmuebleId;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String[] getTipo() {
		return tipo;
	}

	public void setTipo(String[] tipo) {
		this.tipo = tipo;
	}

}
