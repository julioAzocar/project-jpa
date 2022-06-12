package com.devpredator.projectjpa.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.devpredator.projectjpa.dao.DisqueraDAO;
import com.devpredator.projectjpa.dao.impl.DisqueraDAOImpl;
import com.devpredator.projectjpa.entity.Disquera;

class DisqueraDAOImplTest {

	@Test
	void testGuardar() {
		//fail("Not yet implemented");
		Disquera disquera = new Disquera();
		disquera.setDescripcion("MegaForce6");
		disquera.setFechaCreacion(LocalDateTime.now());
		disquera.setEstatus(true);
		
		try {
			DisqueraDAO disqueraDAO = new DisqueraDAOImpl();
			disqueraDAO.guardar(disquera);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error : " + e.getMessage());
		}

	}

	@Test
	void testActualizar() {

		DisqueraDAO disqueraDAO = new DisqueraDAOImpl();
		Disquera disquera = disqueraDAO.consultarById(9L);//L indica que es long
		
		if (disquera != null) {
			disquera.setDescripcion(disquera.getDescripcion() + " Actualizado");
			disquera.setFechaModificacion(LocalDateTime.now());
			
			try {
				disqueraDAO.actualizar(disquera);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error : " + e.getMessage());
			}
		}

	}

	@Test
	void testEliminar() {
		DisqueraDAO disqueraDAO = new DisqueraDAOImpl();
		disqueraDAO.eliminar(10L);
		
	}

	@Test
	void testConsultar() {
		DisqueraDAO disqueraDAO = new DisqueraDAOImpl();
		List<Disquera> disqueras =  disqueraDAO.Consultar();
		
		assertTrue(disqueras.size() > 0);
		
		disqueras.forEach(disquera -> {
			System.out.println("Disquera : " + disquera.getDescripcion());
		});
	}

	@Test
	void testConsultarById() {
		
		DisqueraDAO disqueraDAO = new DisqueraDAOImpl();
		Disquera disquera = disqueraDAO.consultarById(9L);//L indica que es long
		
	}


	@Test
	void testconsultarByDescripcion() {
		DisqueraDAO disqueraDAO = new DisqueraDAOImpl();
		
		String descripcion = "MegaForce5";
		
		Disquera disquera =  disqueraDAO.consultarByDescripcionJPQL(descripcion);
		
		assertNotNull(disquera);
		
		System.out.println("Disquera : " + disquera.getDescripcion());

	}
	
	@Test
	void testconsultarByDescripcionSQL() {
		DisqueraDAO disqueraDAO = new DisqueraDAOImpl();
		
		String descripcion = "MegaForce5";
		
		Disquera disquera =  disqueraDAO.consultarByDescripcionSQL(descripcion);
		
		assertNotNull(disquera);
		
		System.out.println("Disquera : " + disquera.getDescripcion());

	}
	
}
