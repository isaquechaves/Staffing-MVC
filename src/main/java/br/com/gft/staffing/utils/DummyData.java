package br.com.gft.staffing.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.gft.staffing.model.Funcionario;
import br.com.gft.staffing.model.FuncionarioTecnologia;
import br.com.gft.staffing.model.Gft;
import br.com.gft.staffing.model.Tecnologia;
import br.com.gft.staffing.model.Vaga;
import br.com.gft.staffing.model.VagaTecnologia;
import br.com.gft.staffing.repository.FuncionarioRepository;
import br.com.gft.staffing.repository.FuncionarioTecRepository;
import br.com.gft.staffing.repository.GftRepository;
import br.com.gft.staffing.repository.TecnologiaRepository;
import br.com.gft.staffing.repository.VagaRepository;
import br.com.gft.staffing.repository.VagaTecnologiaRepository;


@Component
public class DummyData {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@Autowired
	VagaRepository vagaRepository;
	
	@Autowired
	GftRepository gftRepository;
	
	@Autowired
	TecnologiaRepository tecnologiaRepository;
	
	@Autowired
	VagaTecnologiaRepository vagaTecnologiaRepository;
	
	@Autowired
	FuncionarioTecRepository funcionarioTecRepository;
	
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
	
			List<Tecnologia> tecnologiaList = new ArrayList<>();
			
			Tecnologia tecnologia1 = new Tecnologia();
			tecnologia1.setNome("Java");
			
			Tecnologia tecnologia2 = new Tecnologia();
			tecnologia2.setNome("C#");
			
			Tecnologia tecnologia3 = new Tecnologia();
			tecnologia3.setNome("AWS");
			
			tecnologiaList.add(tecnologia1);
			tecnologiaList.add(tecnologia2);
			tecnologiaList.add(tecnologia3);
			
			for(Tecnologia tecnologia : tecnologiaList) {
				Tecnologia tecnologiaSaved = tecnologiaRepository.save(tecnologia);
				System.out.println(tecnologiaSaved.getId());
			}

			List<VagaTecnologia> vagaTecnologiaList = new ArrayList<>();
			
			VagaTecnologia vagaTecnologia1 = new VagaTecnologia();
			vagaTecnologia1.setTecnologia(tecnologia1);
			vagaTecnologia1.setVaga(vaga1);
			
			vagaTecnologiaList.add(vagaTecnologia1);
			
			for(VagaTecnologia vagaTecnologia : vagaTecnologiaList) {
				VagaTecnologia vagaTecnologiaSaved = vagaTecnologiaRepository.save(vagaTecnologia);
				System.out.println(vagaTecnologiaSaved.getId());
			}
			
			List<FuncionarioTecnologia> funcionarioTecnologiaList = new ArrayList<>();
						
			FuncionarioTecnologia funcionarioTecnologia1 = new FuncionarioTecnologia();
			funcionarioTecnologia1.setFuncionario(funcionario1);
			funcionarioTecnologia1.setTecnologia(tecnologia1);
			
			FuncionarioTecnologia funcionarioTecnologia2 = new FuncionarioTecnologia();
			funcionarioTecnologia2.setFuncionario(funcionario2);
			funcionarioTecnologia2.setTecnologia(tecnologia2);
			
			FuncionarioTecnologia funcionarioTecnologia3 = new FuncionarioTecnologia();
			funcionarioTecnologia3.setFuncionario(funcionario3);
			funcionarioTecnologia3.setTecnologia(tecnologia3);
			
			funcionarioTecnologiaList.add(funcionarioTecnologia1);
			funcionarioTecnologiaList.add(funcionarioTecnologia2);
			funcionarioTecnologiaList.add(funcionarioTecnologia3);
			
			for(FuncionarioTecnologia funcionarioTecnologia : funcionarioTecnologiaList) {
				FuncionarioTecnologia funcionarioTecnologiaSaved = funcionarioTecRepository.save(funcionarioTecnologia);
				System.out.println(funcionarioTecnologiaSaved.getId());
			}
								
		}
}
