package br.com.gft.staffing.service;

import java.util.List;

import br.com.gft.staffing.model.Gft;

public interface GftService {
	List<Gft> findAll();
	Gft findById(Long id);
	Gft save(Gft gft);
}
