package br.com.gft.staffing.service;

import java.util.List;

import br.com.gft.staffing.model.Funcionario;

public interface FuncionarioService {
	List<Funcionario> findAll();
	Funcionario findById(Long id);
	Funcionario save(Funcionario funcionario);
}
