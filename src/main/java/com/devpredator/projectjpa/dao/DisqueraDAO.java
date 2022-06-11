package com.devpredator.projectjpa.dao;

import java.util.List;

import com.devpredator.projectjpa.entity.Disquera;

/*file tipo interfaz
 * Dao genera crud en tabla disquera
 * 
 * */
public interface DisqueraDAO {
	
	void guardar(Disquera disquera);
	void actualizar(Disquera disquera);
	void eliminar(Long id);
	
	List<Disquera> Consultar();
	Disquera consultarById(Long id);
	
	
}
