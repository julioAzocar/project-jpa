package com.devpredator.projectjpa.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;


/*
 * mapea tabla disquera
 */

@Entity
@Table(name = "disquera")
public class Disquera {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDisquera")//opcional si es igual a columna de tabla en bd
	private Long idDisquera;
	
	@Column(name = "descripcion",length = 100)
	private String descripcion;
	
	@Column(name = "fechaCreacion")
	private LocalDateTime fechaCreacion;
	
	@Column(name = "fechaModificacion")
	private LocalDateTime fechaModificacion;
	
	@Column(name = "estatus")
	private boolean estatus;
	
	
	public Long getIdDisquera() {
		return idDisquera;
	}
	public void setIdDisquera(Long idDisquera) {
		this.idDisquera = idDisquera;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public LocalDateTime getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(LocalDateTime fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public boolean isEstatus() {
		return estatus;
	}
	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}
	
	
}
