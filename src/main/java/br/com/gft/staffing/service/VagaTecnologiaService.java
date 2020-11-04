package br.com.gft.staffing.service;

import java.util.List;

import br.com.gft.staffing.model.VagaTecnologia;

public interface VagaTecnologiaService {
	List<VagaTecnologia> findAll();
	VagaTecnologia findById(Long id);
	VagaTecnologia save(VagaTecnologia vagaTecnologia);
}
