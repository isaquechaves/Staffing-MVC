package br.com.gft.staffing.service;

import java.util.List;

import br.com.gft.staffing.model.FuncionarioTecnologia;

public interface FuncionarioTecService {
	List<FuncionarioTecnologia> findAll();
	FuncionarioTecnologia finById(Long id);
	FuncionarioTecnologia save(FuncionarioTecnologia funcionarioTecnologia);
}
