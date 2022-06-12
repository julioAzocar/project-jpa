package com.devpredator.projectjpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.devpredator.projectjpa.dao.SubGeneroDAO;
import com.devpredator.projectjpa.entity.Disquera;
import com.devpredator.projectjpa.entity.SubGenero;

public class SubGeneroDAOImpl implements SubGeneroDAO {

	//carga toda la info de persistence.xml es constante
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("persistenceDevPredator");

	
	@Override
	public void guardar(SubGenero subgenero) {
		// TODO Auto-generated method stub
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		try {
			et.begin();
			em.persist(subgenero);
			et.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		}finally {
			em.close();
		}
		

	}

	@Override
	public void actualizar(SubGenero subgenero) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			em.merge(subgenero);
			et.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		}finally {
			em.close();
		}
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		SubGenero subgenero = em.find(SubGenero.class, id);
		
		try {
			et.begin();
			em.remove(subgenero);
			et.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		}finally {
			em.close();
		}
	}

	@Override
	public List<SubGenero> Consultar() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		TypedQuery <SubGenero> Consulta= (TypedQuery<SubGenero>) em.createQuery("FROM SubGenero ORDER BY descripcion");
		
		return Consulta.getResultList();
	}

	@Override
	public SubGenero consultarById(Long id) {
		// TODO Auto-generated method stub
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		SubGenero Consulta = em.find(SubGenero.class, id);
		
		if (Consulta == null) {
			
			throw new EntityNotFoundException("Entidad no encontrada");
			
			
		}

		return Consulta;
	}

}
