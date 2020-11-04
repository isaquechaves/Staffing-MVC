package br.com.gft.staffing.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gft.staffing.model.Tecnologia;
import br.com.gft.staffing.repository.TecnologiaRepository;
import br.com.gft.staffing.service.TecnologiaService;

@Service
public class TecnologiaImpl implements TecnologiaService{

	@Autowired
	TecnologiaRepository tecnologiaRepository;
	
	@Override
	public List<Tecnologia> findAll() {
	
		return tecnologiaRepository.findAll();
	}

	@Override
	public Tecnologia findById(Long id) {

		return tecnologiaRepository.findById(id).get();
	}

	@Override
	public Tecnologia save(Tecnologia tecnologia) {
		
		return tecnologiaRepository.save(tecnologia);
	}

}
