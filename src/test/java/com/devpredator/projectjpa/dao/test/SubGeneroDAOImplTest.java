package com.devpredator.projectjpa.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.devpredator.projectjpa.dao.DisqueraDAO;
import com.devpredator.projectjpa.dao.SubGeneroDAO;
import com.devpredator.projectjpa.dao.impl.DisqueraDAOImpl;
import com.devpredator.projectjpa.dao.impl.SubGeneroDAOImpl;
import com.devpredator.projectjpa.entity.Disquera;
import com.devpredator.projectjpa.entity.Genero;
import com.devpredator.projectjpa.entity.SubGenero;

class SubGeneroDAOImplTest {

	SubGeneroDAO subGeneroDAO = new SubGeneroDAOImpl();
	
	@Test
	void testGuardar() {
		
		//fail("Not yet implemented");
		SubGenero subGenero = new SubGenero();
		subGenero.setDescripcion("Death Metal ");
		subGenero.setFechaCreacion(LocalDateTime.now());
		subGenero.setEstatus(true);
		
		Genero genero = new Genero();
		genero.setDescripcion("Metal");
		genero.setFechaCreacion(LocalDateTime.now());
		genero.setEstatus(true);
		
		subGenero.setGenero(genero);
		try {
			SubGeneroDAO subGeneroDAO = new SubGeneroDAOImpl();
			subGeneroDAO.guardar(subGenero);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error : " + e.getMessage());
		}
		
	}

	@Test
	void testActualizar() {
		//buscar sub genero
		SubGenero subGenero =  subGeneroDAO.consultarById(7L);
		subGenero.setDescripcion("Death Metal 2");
		subGenero.setFechaModificacion(LocalDateTime.now());
		//actualizar sub genero y genero
		subGenero.getGenero().setDescripcion("Metal2");
		subGenero.getGenero().setFechaModificacion(LocalDateTime.now());

		try {
			SubGeneroDAO subGeneroDAO = new SubGeneroDAOImpl();
			subGeneroDAO.actualizar(subGenero);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error : " + e.getMessage());
		}
		
	}

	@Test
	void testEliminar() {

		try {
			SubGeneroDAO subGeneroDAO = new SubGeneroDAOImpl();
			subGeneroDAO.eliminar(7L);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error : " + e.getMessage());
		}
	}

	@Test
	void testConsultar() {
		
		List<SubGenero> subGeneros =  subGeneroDAO.Consultar();
		
		assertTrue(subGeneros.size() > 0);
		
		subGeneros.forEach(subgenero -> {
			System.out.println("subgenero : " + subgenero.getDescripcion());
			System.out.println("genero : " + subgenero.getGenero().getDescripcion());
		});
		
		
	}

	@Test
	void testConsultarById() {
		fail("Not yet implemented");
	}

}
