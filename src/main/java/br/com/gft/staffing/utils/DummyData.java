package br.com.gft.staffing.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.gft.staffing.model.Funcionario;
import br.com.gft.staffing.model.Gft;
import br.com.gft.staffing.model.Vaga;
import br.com.gft.staffing.repository.FuncionarioRepository;
import br.com.gft.staffing.repository.GftRepository;
import br.com.gft.staffing.repository.VagaRepository;


@Component
public class DummyData {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@Autowired
	VagaRepository vagaRepository;
	
	@Autowired
	GftRepository gftRepository;
	
	
		@PostConstruct	
		public void saveFuncionario(){
			
			List<Gft> gftList = new ArrayList<>();
			
			Gft gft1 = new Gft();		
			gft1.setCep("111-11");
			gft1.setCidade("Gft Sorocaba");
			gft1.setEndereco("rua gft");
			gft1.setEstado("SP");
			gft1.setNome("gft sorocaba");
			gft1.setTelefone("124124124");
			
			Gft gft2 = new Gft();
			gft2.setCep("111-11");
			gft2.setCidade("Gft Sorocaba");
			gft2.setEndereco("rua gft");
			gft2.setEstado("SP");
			gft2.setNome("gft SP");
			gft2.setTelefone("124124124");
			
			gftList.add(gft1);
			gftList.add(gft2);
			
			
			for(Gft gft : gftList) {
				Gft gftSaved = gftRepository.save(gft);
				System.out.println(gftSaved.getId());
			}	
		
			
			
			List<Vaga> vagaList = new ArrayList<>();
			
			Vaga vaga1 = new Vaga();		
			vaga1.setAbertura_vaga(LocalDate.now());
			vaga1.setCodigo_vaga("Itau_12");
			vaga1.setDescricao_vaga("Desenvolvedor back-end Java");
			vaga1.setProjeto("Itaú pix");
			vaga1.setQtd_vaga(1);
			
			Vaga vaga2 = new Vaga();
			vaga2.setAbertura_vaga(LocalDate.now());
			vaga2.setCodigo_vaga("Itau_12");
			vaga2.setDescricao_vaga("Desenvolvedor back-end Java");
			vaga2.setProjeto("Itaú pix");
			vaga2.setQtd_vaga(2);
			
			vagaList.add(vaga1);
			vagaList.add(vaga2);
			
			for(Vaga vaga : vagaList) {
				Vaga vagaSaved = vagaRepository.save(vaga);
				System.out.println(vagaSaved.getId());
			}	
						
			
			List<Funcionario> funcionarioList = new ArrayList<>();
			
			
			Funcionario funcionario1 = new Funcionario();
			funcionario1.setCargo("Desenvolvedor Back-end");
			funcionario1.setInicio_wa(LocalDate.now());
			funcionario1.setTermino_wa(LocalDate.now().plusDays(15));
			funcionario1.setNome("João Pedro");	
			funcionario1.setGft(gft1);
			funcionario1.setVaga(vaga2);
			
			Funcionario funcionario2 = new Funcionario();
			funcionario2.setCargo("Desenvolvedor Front-end");
			funcionario2.setInicio_wa(LocalDate.now());
			funcionario2.setTermino_wa(LocalDate.now().plusDays(15));
			funcionario2.setNome("Maria Fernanda");
			funcionario2.setGft(gft1);
			funcionario2.setVaga(vaga2);
			
			Funcionario funcionario3 = new Funcionario();
			funcionario3.setCargo("Scrum Master");
			funcionario3.setInicio_wa(LocalDate.now());
			funcionario3.setTermino_wa(LocalDate.now().plusDays(15));
			funcionario3.setNome("Lara Dias");
			funcionario3.setGft(gft2);
			funcionario3.setVaga(vaga1);
			
			funcionarioList.add(funcionario1);
			funcionarioList.add(funcionario2);
			funcionarioList.add(funcionario3);
			
			for(Funcionario funcionario : funcionarioList) {
				Funcionario funcionarioSaved = funcionarioRepository.save(funcionario);
				System.out.println(funcionarioSaved.getId());
			}	
		}
}
