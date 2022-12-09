package com.jdr.tfg.modelo.beams;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//! Especifica "inmuebles" si no, falla;
//! Es el nombre de la colección (no la ruta de GetMapping)

@Document(collection = "inmuebles")
public class Inmueble {

	//! No utilizar @Id sin asociar a un atributo
	@Id
	private String inmuebleId;
	
	private String tipoOperacion;
	private String pais;
	private String zona;
	private String area;
	private String tipoInmueble;
	private int precio;
	private String urlImagen;
	private List<String> guardadoPor;
	
	public Inmueble() {
		super();
	}

	public Inmueble(String inmuebleId, String tipoOperacion, String pais, String zona, String area, String tipoInmueble,
			int precio, String urlImagen, List<String> guardadoPor) {
		super();
		this.inmuebleId = inmuebleId;
		this.tipoOperacion = tipoOperacion;
		this.pais = pais;
		this.zona = zona;
		this.area = area;
		this.tipoInmueble = tipoInmueble;
		this.precio = precio;
		this.urlImagen = urlImagen;
		this.guardadoPor = guardadoPor;
	}

	public String getInmuebleId() {
		return inmuebleId;
	}

	public void setInmuebleId(String inmuebleId) {
		this.inmuebleId = inmuebleId;
	}

	public String getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
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

	public String getTipoInmueble() {
		return tipoInmueble;
	}

	public void setTipoInmueble(String tipoInmueble) {
		this.tipoInmueble = tipoInmueble;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public List<String> getGuardadoPor() {
		return guardadoPor;
	}

	public void setGuardadoPor(List<String> guardadoPor) {
		this.guardadoPor = guardadoPor;
	}

}
