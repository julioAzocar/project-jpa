package com.devpredator.projectjpa.dao.impl;

import java.util.List;
import com.devpredator.projectjpa.dao.DisqueraDAO;
import com.devpredator.projectjpa.entity.Disquera;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class DisqueraDAOImpl implements DisqueraDAO {
	
	//carga toda la info de persistence.xml es constante
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("persistenceDevPredator");

	@Override
	public void guardar(Disquera disquera) {
		// TODO Auto-generated method stub
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {
			em.persist(disquera);
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
	public void actualizar(Disquera disquera) {
		// TODO Auto-generated method stub
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {
			em.merge(disquera);
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


		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		Disquera disqueraConsulta = em.find(Disquera.class, id);
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {
			em.remove(disqueraConsulta);
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
	public List<Disquera> Consultar() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		TypedQuery <Disquera> disquerasQuery= (TypedQuery<Disquera>) em.createQuery("FROM Disquera ORDER BY descripcion");
		
		return disquerasQuery.getResultList();

	}

	@Override
	public Disquera consultarById(Long id) {
		// TODO Auto-generated method stub
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		Disquera disqueraConsulta = em.find(Disquera.class, id);
		
		if (disqueraConsulta == null) {
			
			throw new EntityNotFoundException("Entidad no encontrada");
			
			
		}

		return disqueraConsulta;
	}

	
}
