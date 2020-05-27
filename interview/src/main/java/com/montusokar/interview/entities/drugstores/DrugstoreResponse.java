package com.montusokar.interview.entities.drugstores;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DrugstoreResponse {

	private String local_nombre;
	private String local_direccion;
	private String local_telefono;
	private String local_lat;
	private String local_lng;
	@JsonIgnore
	private String local_comuna;

	public DrugstoreResponse() {
		super();
	}

	public DrugstoreResponse(String local_nombre, String local_direccion, String local_telefono, String local_lat,
			String local_lng, String local_comuna) {
		super();
		this.local_nombre = local_nombre;
		this.local_direccion = local_direccion;
		this.local_telefono = local_telefono;
		this.local_lat = local_lat;
		this.local_lng = local_lng;
		this.setLocal_comuna(local_comuna);
	}

	public String getLocal_nombre() {
		return local_nombre;
	}

	public void setLocal_nombre(String local_nombre) {
		this.local_nombre = local_nombre;
	}

	public String getLocal_direccion() {
		return local_direccion;
	}

	public void setLocal_direccion(String local_direccion) {
		this.local_direccion = local_direccion;
	}

	public String getLocal_telefono() {
		return local_telefono;
	}

	public void setLocal_telefono(String local_telefono) {
		this.local_telefono = local_telefono;
	}

	public String getLocal_lat() {
		return local_lat;
	}

	public void setLocal_lat(String local_lat) {
		this.local_lat = local_lat;
	}

	public String getLocal_lng() {
		return local_lng;
	}

	public void setLocal_lng(String local_lng) {
		this.local_lng = local_lng;
	}

	public String getLocal_comuna() {
		return local_comuna;
	}

	public void setLocal_comuna(String local_comuna) {
		this.local_comuna = local_comuna;
	}

}
