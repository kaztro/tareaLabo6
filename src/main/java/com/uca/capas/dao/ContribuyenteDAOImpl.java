package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Contribuyente;

@Repository
public class ContribuyenteDAOImpl implements ContribuyenteDAO {

	@PersistenceContext(unitName = "capas")
	private EntityManager entityManager;
	
	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM public.contribuyente");
		Query query = entityManager.createNativeQuery(sb.toString(), Contribuyente.class);
		List<Contribuyente> resultset = query.getResultList();
		
		return resultset;
	}
	@Transactional
	@Override
	public void insert(Contribuyente contribuyente) throws DataAccessException {
		entityManager.persist(contribuyente);
	}
	
}
