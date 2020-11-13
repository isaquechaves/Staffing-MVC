package br.com.gft.staffing.service;

import java.util.List;

import br.com.gft.staffing.model.Funcionario;
import br.com.gft.staffing.service.filter.FuncionarioFilter;

public interface FuncionarioService {

	List<Funcionario> findAll();
	Funcionario findById(Long id);
	Funcionario save(Funcionario funcionario);
	List<Funcionario> filtrar(FuncionarioFilter filtro);
	Funcionario deleteById(Long id);

}
