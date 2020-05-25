package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Contribuyente;

public interface ContribuyenteService {
	public List<Contribuyente> findAll() throws DataAccessException;
	public void insert(Contribuyente contribuyente) throws DataAccessException;
}
