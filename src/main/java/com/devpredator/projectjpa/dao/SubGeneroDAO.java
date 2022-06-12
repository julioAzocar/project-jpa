package com.devpredator.projectjpa.dao;

import java.util.List;

import com.devpredator.projectjpa.entity.SubGenero;

/*
 * crud jpa tabla subgenero
 * */
public interface SubGeneroDAO {
	void guardar(SubGenero subgenero);
	void actualizar(SubGenero subgenero);
	void eliminar(Long id);
	
	List<SubGenero> Consultar();
	SubGenero consultarById(Long id);
}
