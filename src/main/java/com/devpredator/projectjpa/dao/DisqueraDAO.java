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
	
    /** apunta a objetos
    *Metodo permite consultar con JPQL la disquera a partir de una descripcion
    *@param descripcion {@link String} descripcion de la disquera 
    *@return {@link Disquera} la disquera consultada
    */
	Disquera consultarByDescripcionJPQL(String descripcion);
	
    /** usado para consultas mas complejas apunta a bd
    *Metodo permite consultar con SQL la disquera a partir de una descripcion
    */
	Disquera consultarByDescripcionSQL(String descripcion);
	
	
}
