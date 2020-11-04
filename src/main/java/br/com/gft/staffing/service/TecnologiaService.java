package br.com.gft.staffing.service;

import java.util.List;

import br.com.gft.staffing.model.Tecnologia;

public interface TecnologiaService {
	List<Tecnologia> findAll();
	Tecnologia findById(Long id);
	Tecnologia save(Tecnologia tecnologia);
}
