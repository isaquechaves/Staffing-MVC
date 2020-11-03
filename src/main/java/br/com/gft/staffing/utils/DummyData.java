package br.com.gft.staffing.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.gft.staffing.model.Funcionario;
import br.com.gft.staffing.repository.FuncionarioRepository;


@Component
public class DummyData {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@PostConstruct	
	public void saveFuncionario(){
		List<Funcionario> funcionarioList = new ArrayList<>();		
		
		Funcionario funcionario1 = new Funcionario();
		funcionario1.setCargo("Desenvolvedor Back-end");
		funcionario1.setInicio_wa(LocalDate.now());
		funcionario1.setTermino_wa(LocalDate.now().plusDays(15));
		funcionario1.setNome("João Pedro");
		
		
		Funcionario funcionario2 = new Funcionario();
		funcionario2.setCargo("Desenvolvedor Front-end");
		funcionario2.setInicio_wa(LocalDate.now());
		funcionario2.setTermino_wa(LocalDate.now().plusDays(15));
		funcionario2.setNome("Maria Fernanda");
		
		
		Funcionario funcionario3 = new Funcionario();
		funcionario3.setCargo("Scrum Master");
		funcionario3.setInicio_wa(LocalDate.now());
		funcionario3.setTermino_wa(LocalDate.now().plusDays(15));
		funcionario3.setNome("Lara Dias");
		
		
		funcionarioList.add(funcionario1);
		funcionarioList.add(funcionario2);
		funcionarioList.add(funcionario3);
		
		for(Funcionario funcionario : funcionarioList) {
			Funcionario funcionarioSaved = funcionarioRepository.save(funcionario);
			System.out.println(funcionarioSaved.getId());
		}
	
	}
}
