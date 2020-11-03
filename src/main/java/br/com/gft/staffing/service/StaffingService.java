package br.com.gft.staffing.service;

import java.util.List;

import br.com.gft.staffing.model.Funcionario;

public interface StaffingService {
	List<Funcionario> findAll();
	Funcionario findById(Long Id);
	Funcionario save(Funcionario funcionario);
}
