package br.com.gft.staffing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.gft.staffing.model.Funcionario;
import br.com.gft.staffing.model.Gft;
import br.com.gft.staffing.repository.FuncionarioRepository;
import br.com.gft.staffing.service.FuncionarioService;
import br.com.gft.staffing.service.GftService;
import br.com.gft.staffing.service.TecnologiaService;
import br.com.gft.staffing.service.VagaService;
import br.com.gft.staffing.service.VagaTecnologiaService;
import br.com.gft.staffing.service.filter.FuncionarioFilter;

@Controller
@RequestMapping("/wa")
public class StaffingController {
	
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
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
		
	@RequestMapping("/funcionarios/cadastrar")
	public ModelAndView cadastro(@ModelAttribute("gft") Gft gft) {
		ModelAndView mv = new ModelAndView("cadastrar");
		List<Gft> gfts = gftService.findAll();
		mv.addObject(gfts);
		mv.addObject(new Funcionario());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(Funcionario funcionario) {			
				
		funcionarioService.save(funcionario);		
		return "funcionarios";
		
	}
	
	@RequestMapping("/funcionarios")
	public ModelAndView pesquisar(@ModelAttribute("filtro")FuncionarioFilter filtro )
	{
		List<Funcionario> funcionarios = funcionarioService.filtrar(filtro);
		ModelAndView mv = new ModelAndView("funcionarios");
		mv.addObject("funcionarios", funcionarios);
		return mv;
	}

}
