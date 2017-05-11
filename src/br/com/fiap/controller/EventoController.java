package br.com.fiap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.dao.EventoDao;
import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.entidades.Evento;
import br.com.fiap.entidades.Usuario;

@Controller
public class EventoController {

	@Autowired
	EventoDao dao;
	
	@Autowired
	UsuarioDao udao;
	
	@RequestMapping("/evento/addForm")
	public String form(Evento evento, ModelMap map) {
//		map.addAttribute("userList", udao.findAll());
		return "evento/addForm";
	}
					 
	@RequestMapping(value="/evento/add")
	public String add(Evento evento, BindingResult br, RedirectAttributes red) {
		br.getFieldErrors().forEach(System.out::println);
		
		Usuario user = udao.find(1L);
		user.getEventos().add(evento);
		evento.getParticipantes().add(user);
		
		dao.persist(evento);
		red.addFlashAttribute("msg", "Falta listar !!!");
		return "redirect:/home";
	}

	@RequestMapping(value="/evento/edit")
	public String edit(Evento evento, ModelMap map) {
		evento = dao.find(evento.getId());
		map.addAttribute("evento", evento);
		return "evento/addForm";
	}
	
	
	@RequestMapping("/evento/list")
	public String list(ModelMap map) {
		List<Evento> eventos = dao.findAll();
		map.addAttribute("eventos", eventos);
		return "/evento/lista";
	}}
