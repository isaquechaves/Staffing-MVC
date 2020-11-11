package br.com.gft.staffing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.gft.staffing.model.Funcionario;
import br.com.gft.staffing.model.Gft;
import br.com.gft.staffing.model.Tecnologia;
import br.com.gft.staffing.model.Vaga;
import br.com.gft.staffing.repository.FuncionarioRepository;
import br.com.gft.staffing.repository.GftRepository;
import br.com.gft.staffing.repository.TecnologiaRepository;
import br.com.gft.staffing.repository.VagaRepository;
import br.com.gft.staffing.service.FuncionarioService;
import br.com.gft.staffing.service.GftService;
import br.com.gft.staffing.service.TecnologiaService;
import br.com.gft.staffing.service.VagaService;
import br.com.gft.staffing.service.filter.FuncionarioFilter;
import br.com.gft.staffing.service.filter.VagaFilter;

@Controller
@RequestMapping("/wa")
public class StaffingController {
	
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@Autowired
	VagaRepository vagaRepository;
	
	@Autowired
	GftRepository gftRepository;
	
	@Autowired
	TecnologiaRepository tecnologiaRepository;
	
	@Autowired
	FuncionarioService funcionarioService;
	
	@Autowired
	VagaService vagaService;
	
	@Autowired
	GftService gftService;
	
	@Autowired
	TecnologiaService tecnologiaService;
	
		
	@RequestMapping("/funcionarios/cadastrar")
	@PreAuthorize("hasRole('USER')")
	public ModelAndView cadastro(@ModelAttribute("gft") Gft gft, @ModelAttribute("tecnologia") Tecnologia tecnologia) {
		ModelAndView mv = new ModelAndView("cadastrar");
		
		List<Gft> gfts = gftService.findAll();
		List<Tecnologia> tecnologias = tecnologiaService.findAll();
		
		
		mv.addObject("tecnologias", tecnologias);
		mv.addObject("gfts", gfts);
		mv.addObject(new Funcionario());
		return mv;
	}
	
	@RequestMapping("/funcionarios/cadastrar/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ModelAndView edicaoFuncionario(@PathVariable("id") Long idFuncionario) {
		
		ModelAndView mv = new ModelAndView("cadastrar");
				
		Funcionario funcionario = funcionarioRepository.getOne(idFuncionario);
		List<Gft> gfts = gftService.findAll();
		List<Tecnologia> tecnologias = tecnologiaService.findAll();							
		
		
		mv.addObject("gfts", gfts);
		mv.addObject("tecnologias", tecnologias);
		mv.addObject(funcionario);
		
		return mv;
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(Funcionario funcionario) {							
		
		funcionario.setTermino_wa(funcionario.getInicio_wa().plusDays(14));
		funcionarioService.save(funcionario);		
		return "redirect:/wa/funcionarios";
		
	}
	
	@RequestMapping("/funcionarios")
	@PreAuthorize("hasRole('USER')")
	public ModelAndView pesquisar(@ModelAttribute("filtro")FuncionarioFilter filtro )
	{
		List<Funcionario> funcionarios = funcionarioService.filtrar(filtro);
		
		ModelAndView mv = new ModelAndView("funcionarios");
		mv.addObject("funcionarios", funcionarios);
		return mv;
	}
	
	@RequestMapping("/historico")
	@PreAuthorize("hasRole('ADMIN')")
	public ModelAndView pesquisarHistorico(@ModelAttribute("filtro")FuncionarioFilter filtro )
	{
		List<Funcionario> funcionarios = funcionarioService.filtrar(filtro);
		
		ModelAndView mv = new ModelAndView("historico");
		mv.addObject("funcionarios", funcionarios);
		return mv;
	}
	
	@RequestMapping("/vagas")
	@PreAuthorize("hasRole('USER')")
	public ModelAndView pesquisarVagas(@ModelAttribute("filtro")VagaFilter filtro)
	{
		List<Vaga> vagas = vagaService.filtrar(filtro);
		
		ModelAndView mv = new ModelAndView("vagas");
		mv.addObject("vagas", vagas);
		return mv;
	}

	
	@RequestMapping(value = "/vagas/cadastrar", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public ModelAndView vagasCadastrar(@ModelAttribute("gft") Gft gft, @ModelAttribute("tecnologia") Tecnologia tecnologia) {
		ModelAndView mv = new ModelAndView("cadastrarVaga");
		
		List<Gft> gfts = gftService.findAll();
		List<Tecnologia> tecnologias = tecnologiaService.findAll();
		
		mv.addObject("tecnologias", tecnologias);
		mv.addObject("gfts", gfts);
		mv.addObject(new Vaga());
		
		return mv;
	}
	
	@RequestMapping("/vagas/cadastrar/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ModelAndView edicao(@PathVariable("id") Long idVaga) {
		
		ModelAndView mv = new ModelAndView("cadastrarVaga");
				
		Vaga vaga = vagaRepository.getOne(idVaga);
		
		List<Tecnologia> tecnologias = tecnologiaService.findAll();							

		mv.addObject("tecnologias", tecnologias);
		mv.addObject(vaga);
		
		return mv;
		
	}
	
	@RequestMapping(value = "/vagas/cadastrar", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public String salvar(Vaga vaga) {			
				
		vagaService.save(vaga);		
		return "redirect:/wa/vagas";
		
	}
	

	@RequestMapping(value = "/alocacao")
	public ModelAndView alocacao() {
		
		ModelAndView mv = new ModelAndView("alocacao");

		return mv;
	}
	
	@RequestMapping(value = "/alocacao/{id}",  method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public ModelAndView alocacao(@PathVariable("id") Long idFuncionario) {
		
		Funcionario funcionario = funcionarioRepository.getOne(idFuncionario);		
		
		List<Vaga> vagas = vagaService.findAll();
		
		
		ModelAndView mv = new ModelAndView("alocacao");
		
	
		mv.addObject("vagas", vagas);
		mv.addObject(funcionario);
		
		return mv;
	}
	
	@RequestMapping(value = "/alocacao", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public String alocar(Funcionario funcionario) {			
		
		funcionarioService.save(funcionario);		
		Long idVaga = funcionario.getVaga().getId();
		System.out.println(idVaga);
		
		Vaga vaga = vagaRepository.getOne(idVaga);
						
		vaga.setQtd_vaga(vaga.getQtd_vaga()-1);
		vagaService.save(vaga);
		
		return "redirect:/wa/funcionarios";
		
	}
}
