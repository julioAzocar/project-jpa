package com.devpredator.projectjpa.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/*Tabla Genero*/
@Entity
@Table(name = "subgenero")
public class SubGenero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idSubGenero")//opcional si es igual a columna de tabla en bd
	private Long idSubGenero;
	
	@Column(name = "descripcion",length = 100)
	private String descripcion;
	
	@Column(name = "fechaCreacion")
	private LocalDateTime fechaCreacion;
	
	@Column(name = "fechaModificacion")
	private LocalDateTime fechaModificacion;
	
	@Column(name = "estatus")
	private boolean estatus;

	//@ManyToOne(fetch = FetchType.EAGER)//genera tabla genero automaticamente 
	@ManyToOne(fetch = FetchType.LAZY) //performance mas dividido 
	@JoinColumn(name = "idGenero")
	@Cascade(CascadeType.PERSIST)//solo en los insert
	//@Cascade(CascadeType.ALL)//para insert, update, delete
	//@Cascade(CascadeType.REMOVE)
	private Genero genero;

	public Long getIdSubGenero() {
		return idSubGenero;
	}

	public void setIdSubGenero(Long idSubGenero) {
		this.idSubGenero = idSubGenero;
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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
	
}
