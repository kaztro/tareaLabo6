package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;
import com.uca.capas.service.ContribuyenteService;
import com.uca.capas.service.ImportanciaService;

@Controller
public class MainController {
	
	@Autowired
	private ContribuyenteService contribuyenteService;
	
	@Autowired
	private ImportanciaService importanciaService;
	
	@RequestMapping("/index")
	public ModelAndView init() {
		ModelAndView mav = new ModelAndView();
		Contribuyente contribuyente = new Contribuyente();
		List<Importancia> listImp = null;
		
		try { listImp = importanciaService.findAll(); } 
		catch(Exception e) { e.printStackTrace(); }
		
		mav.addObject("listImp", listImp);
		mav.addObject("contribuyente", contribuyente);
		mav.setViewName("index");
		
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> listCont  = null;
		
		try { listCont = contribuyenteService.findAll(); }
		catch(Exception e) { e.printStackTrace(); }
		mav.addObject("listCont", listCont);
		mav.setViewName("listado");
		
		return mav;
	}
	
	@RequestMapping("/filter")
	public ModelAndView filter(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			List<Importancia> listImp = null;
			
			try { listImp = importanciaService.findAll(); }
			catch(Exception e) { e.printStackTrace(); }
			
			mav.addObject("listImp", listImp);
			mav.setViewName("index");
		} else {
			try { contribuyenteService.insert(contribuyente); }
			catch(Exception e) { e.printStackTrace(); }
			
			contribuyente = new Contribuyente();
			mav.setViewName("filter");
		}

		return mav;
	}
	
}
