package br.com.gft.staffing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.gft.staffing.model.Funcionario;
import br.com.gft.staffing.service.FuncionarioService;
import br.com.gft.staffing.service.FuncionarioTecService;
import br.com.gft.staffing.service.GftService;
import br.com.gft.staffing.service.TecnologiaService;
import br.com.gft.staffing.service.VagaService;
import br.com.gft.staffing.service.VagaTecnologiaService;

@Controller
public class StaffingController {
	
	@Autowired
	FuncionarioService funcionarioService;
	
	@Autowired
	VagaService vagaService;
	
	@Autowired
	GftService gftService;
	
	@Autowired
	TecnologiaService tecnologiaService;
	
	@Autowired
	VagaTecnologiaService vagaTecnologiaService;
	
	@Autowired
	FuncionarioTecService funcionarioTecService;
	
	
	@RequestMapping(value = "/funcionarios", method = RequestMethod.GET)
	public ModelAndView getFuncionarios(){
	
		ModelAndView mv = new ModelAndView("funcionarios");
		List<Funcionario> funcionarios = funcionarioService.findAll();
		
		mv.addObject("funcionarios", funcionarios);
		
		return mv;
	}
}
