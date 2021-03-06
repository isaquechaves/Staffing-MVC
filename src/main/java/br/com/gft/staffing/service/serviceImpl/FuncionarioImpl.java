package br.com.gft.staffing.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gft.staffing.model.Funcionario;
import br.com.gft.staffing.repository.FuncionarioRepository;
import br.com.gft.staffing.service.FuncionarioService;
import br.com.gft.staffing.service.filter.FuncionarioFilter;

@Service
public class FuncionarioImpl implements FuncionarioService {

	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@Override
	public List<Funcionario> findAll() {
		return funcionarioRepository.findAll();
	}

	@Override
	public Funcionario findById(Long id) {
		return funcionarioRepository.findById(id).get();
	}

	@Override
	public Funcionario save(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	@Override
	public List<Funcionario> filtrar(FuncionarioFilter filtro) {
		String nome = filtro.getNome() == null ? "" : filtro.getNome();
		return funcionarioRepository.findByNomeContaining(nome);
	}

	@Override
	public Funcionario deleteById(Long id) {
		funcionarioRepository.deleteById(id);
		return null;
	}


}
