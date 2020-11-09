package br.com.gft.staffing.service;

import java.util.List;

import br.com.gft.staffing.model.Vaga;
import br.com.gft.staffing.service.filter.VagaFilter;

public interface VagaService {
	
	List<Vaga> findAll();
	Vaga findById(Long id);
	Vaga save(Vaga vaga);
	List<Vaga> filtrar(VagaFilter filtro);
}
