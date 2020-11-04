package br.com.gft.staffing.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;


import br.com.gft.staffing.StaffingApplication;
import br.com.gft.staffing.model.Funcionario;
import br.com.gft.staffing.model.FuncionarioTecnologia;
import br.com.gft.staffing.repository.FuncionarioRepository;
import br.com.gft.staffing.repository.FuncionarioTecRepository;

public class ConsultaFuncionario {
	public static void main(String[] args) {
	
		ApplicationContext applicationContext = new SpringApplicationBuilder(StaffingApplication.class)
			.web(WebApplicationType.NONE)
			.run(args);

		FuncionarioRepository funcionarioRepository = applicationContext.getBean(FuncionarioRepository.class);
		FuncionarioTecRepository funcionarioTecRepository = applicationContext.getBean(FuncionarioTecRepository.class); 
			
		List<Funcionario> todosFuncionarios = funcionarioRepository.findAll();
		List<FuncionarioTecnologia> todosFuncTec = funcionarioTecRepository.findAll();
			
		for (Funcionario funcionario : todosFuncionarios){
				System.out.printf("%s - %s\n", funcionario.getGft().getNome(), funcionario.getVaga().getCodigo_vaga());
			}
		for (FuncionarioTecnologia funcionarioTecnologia : todosFuncTec){
			System.out.printf("%s - %s\n", funcionarioTecnologia.getFuncionario().getNome(), funcionarioTecnologia.getTecnologia().getNome());
		}
	}
}
