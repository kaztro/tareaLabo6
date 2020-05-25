package com.uca.capas.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.ContribuyenteDAO;
import com.uca.capas.domain.Contribuyente;

@Service
public class ContribuyenteServiceImpl implements ContribuyenteService {
	
	@Autowired
	ContribuyenteDAO contribuyenteDAO;
	
	@Autowired
	ImportanciaService importanciaService;
	
	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		return contribuyenteDAO.findAll();
	}
	
	@Transactional
	@Override
	public void insert(Contribuyente contribuyente) throws DataAccessException {
		Date f_fecha = new Date();
		contribuyente.setF_fecha_ingreso(f_fecha);
		
		contribuyente.setImportancia(importanciaService.findOne(contribuyente.getC_importancia()));
		contribuyenteDAO.insert(contribuyente);
		
	}
	
}
