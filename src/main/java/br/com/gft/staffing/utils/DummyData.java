package br.com.gft.staffing.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.gft.staffing.model.Funcionario;
import br.com.gft.staffing.model.Gft;
import br.com.gft.staffing.model.Tecnologia;
import br.com.gft.staffing.model.User;
import br.com.gft.staffing.model.Vaga;
import br.com.gft.staffing.repository.FuncionarioRepository;
import br.com.gft.staffing.repository.GftRepository;
import br.com.gft.staffing.repository.TecnologiaRepository;
import br.com.gft.staffing.repository.UserRepository;
import br.com.gft.staffing.repository.VagaRepository;



@Component
public class DummyData {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@Autowired
	VagaRepository vagaRepository;
	
	@Autowired
	GftRepository gftRepository;
	
	@Autowired
	TecnologiaRepository tecnologiaRepository;

	
		@PostConstruct	
		public void saveFuncionario(){
			
			List<User> userList = new ArrayList<>();
			
			User user1 = new User();
			user1.setUsername("isaque");
			user1.setPassword("$2a$10$TxLoENb.IWq4F0q1HyIkGeF8Vpz26YKTtb6ThR0J9PVGWZfNyrDHy");
			user1.setNome("Isaque Chaves");
			user1.setAdmin(true);
			
			User user2 = new User();
			user2.setUsername("convidade");
			user2.setPassword("$2a$10$TxLoENb.IWq4F0q1HyIkGeF8Vpz26YKTtb6ThR0J9PVGWZfNyrDHy");
			user2.setNome("Isaque Chaves");
			user2.setAdmin(true);
			
			User user3 = new User();
			user3.setUsername("henrique");
			user3.setPassword("$2a$10$TxLoENb.IWq4F0q1HyIkGeF8Vpz26YKTtb6ThR0J9PVGWZfNyrDHy");
			user3.setNome("Henrique");
			user3.setAdmin(true);
			
			User user4 = new User();
			user4.setUsername("usuario");
			user4.setPassword("$2a$10$TxLoENb.IWq4F0q1HyIkGeF8Vpz26YKTtb6ThR0J9PVGWZfNyrDHy");
			user4.setNome("usuario");
			user4.setAdmin(false);
			
			userList.add(user1);
			userList.add(user2);
			userList.add(user3);
			userList.add(user4);
			
			for(User user : userList) {
				User userSaved = userRepository.save(user);
				System.out.println(userSaved.getNome());
			}
			
			List<Gft> gftList = new ArrayList<>();
			
			Gft gft1 = new Gft();		
			gft1.setCep("111-11");
			gft1.setCidade("Sorocaba");
			gft1.setEndereco("Rua GFT");
			gft1.setEstado("SP");
			gft1.setNome("GFT Sorocaba");
			gft1.setTelefone("124124124");
			
			Gft gft2 = new Gft();
			gft2.setCep("111-11");
			gft2.setCidade("São Paulo");
			gft2.setEndereco("Rua GFT");
			gft2.setEstado("SP");
			gft2.setNome("GFT São Paulo");
			gft2.setTelefone("124124124");
			
			gftList.add(gft1);
			gftList.add(gft2);
			
			
			for(Gft gft : gftList) {
				Gft gftSaved = gftRepository.save(gft);
				System.out.println(gftSaved.getId());
			}	
		
									
						
			List<Tecnologia> tecnologiaList = new ArrayList<>();
			
			
			Tecnologia tecnologia1 = new Tecnologia();
			tecnologia1.setNome("C#");
			
			Tecnologia tecnologia2 = new Tecnologia();
			tecnologia2.setNome("AWS");							
			
			
			Tecnologia tecnologia3 = new Tecnologia();
			tecnologia3.setNome("MySQL");
			
			tecnologiaList.add(tecnologia1);
			tecnologiaList.add(tecnologia2);
			tecnologiaList.add(tecnologia3);								
			
			List<Tecnologia> tecnologiaList2 = new ArrayList<>();
			
			Tecnologia tecnologia4 = new Tecnologia();
			tecnologia4.setNome("Java");
						
			Tecnologia tecnologia5 = new Tecnologia();
			tecnologia5.setNome("Angular");			
			
			
			tecnologiaList2.add(tecnologia4);
			tecnologiaList2.add(tecnologia5);
			
			
			for(Tecnologia tecnologia : tecnologiaList) {
				Tecnologia tecnologiaSaved = tecnologiaRepository.save(tecnologia);
				System.out.println(tecnologiaSaved.getId());
			}
			
			for(Tecnologia tecnologia : tecnologiaList2) {
				Tecnologia tecnologiaSaved = tecnologiaRepository.save(tecnologia);
				System.out.println(tecnologiaSaved.getId());
			}
				
				
			List<Vaga> vagaList = new ArrayList<>();
			
			Vaga vaga1 = new Vaga();		
			vaga1.setAbertura_vaga(LocalDate.now());
			vaga1.setCodigo_vaga("Itau_12");
			vaga1.setCliente("Itaú");
			vaga1.setDescricao_vaga("Desenvolvedor Java");
			vaga1.setProjeto("Itaú pix");
			vaga1.setQtd_vaga(1);
			vaga1.setTecnologias(tecnologiaList);
			
			Vaga vaga2 = new Vaga();
			vaga2.setAbertura_vaga(LocalDate.now());
			vaga2.setCodigo_vaga("SAN01");
			vaga2.setCliente("Santander");
			vaga2.setDescricao_vaga("Desenvolvedor C#");
			vaga2.setProjeto("Santander");
			vaga2.setQtd_vaga(2);
			vaga2.setTecnologias(tecnologiaList2);
			
			Vaga vaga3 = new Vaga();
			vaga3.setAbertura_vaga(LocalDate.now());
			vaga3.setCodigo_vaga("Itau_13");
			vaga3.setCliente("Itaú");
			vaga3.setDescricao_vaga("Desenvolvedor backend Java");
			vaga3.setProjeto("Itaú pix");
			vaga3.setQtd_vaga(0);
			vaga3.setTecnologias(tecnologiaList2);
			
			System.out.println(vaga3.getAbertura_vaga());
			System.out.println(vaga1.getAbertura_vaga());
			System.out.println(vaga2.getAbertura_vaga());
			
			
			vagaList.add(vaga1);
			vagaList.add(vaga2);
			vagaList.add(vaga3);
			
			for(Vaga vaga : vagaList) {
				Vaga vagaSaved = vagaRepository.save(vaga);
				System.out.println(vagaSaved.getId());
			}	
			
			List<Funcionario> funcionarioList = new ArrayList<>();
			
			
			Funcionario funcionario1 = new Funcionario();
			funcionario1.setCargo("Desenvolvedor Backend");
			funcionario1.setInicio_wa(LocalDate.now());
			funcionario1.setTermino_wa(LocalDate.now().plusDays(15));
			funcionario1.setNome("João Pedro");	
			funcionario1.setLevel("L2");	
			funcionario1.setGft(gft1);			
			funcionario1.setTecnologias(tecnologiaList);	
			
			Funcionario funcionario2 = new Funcionario();
			funcionario2.setCargo("Desenvolvedor Frontend");
			funcionario2.setInicio_wa(LocalDate.now());
			funcionario2.setTermino_wa(LocalDate.now().plusDays(15));
			funcionario2.setNome("Maria Fernanda");
			funcionario2.setLevel("L3");
			funcionario2.setInicio_alocacao(LocalDate.now());
			funcionario2.setGft(gft1);
			funcionario2.setVaga(vaga2);
			funcionario2.setTecnologias(tecnologiaList);			
			
			Funcionario funcionario3 = new Funcionario();
			funcionario3.setCargo("Scrum Master");
			funcionario3.setInicio_wa(LocalDate.now());
			funcionario3.setTermino_wa(LocalDate.now().plusDays(15));
			funcionario3.setNome("Lara Dias");
			funcionario3.setLevel("L0");
			funcionario3.setGft(gft2);			
			funcionario3.setTecnologias(tecnologiaList2);
			
			funcionarioList.add(funcionario1);
			funcionarioList.add(funcionario2);
			funcionarioList.add(funcionario3);
			
			for(Funcionario funcionario : funcionarioList) {
				Funcionario funcionarioSaved = funcionarioRepository.save(funcionario);
				System.out.println(funcionarioSaved.getId());
			}	
	
		}
}
