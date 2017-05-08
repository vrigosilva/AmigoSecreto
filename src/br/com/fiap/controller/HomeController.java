package br.com.fiap.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.dao.EventoDao;
import br.com.fiap.entidades.Evento;

@Controller
public class HomeController {

	@Autowired
	EventoDao eventoDao;
	
	
	@RequestMapping(value={"/","/home"}) 
	public String iniciar(ModelMap map){
		List<Evento> eventos = eventoDao.findAll();
		map.addAttribute("eventos", eventos);
		return "/home";
	}
} 