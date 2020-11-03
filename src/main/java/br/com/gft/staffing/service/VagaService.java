package br.com.gft.staffing.service;

import java.util.List;

import br.com.gft.staffing.model.Vaga;

public interface VagaService {
	List<Vaga> findAll();
	Vaga findById(Long id);
	Vaga save(Vaga vaga);
}
