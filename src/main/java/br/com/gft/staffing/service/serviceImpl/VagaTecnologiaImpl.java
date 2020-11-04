package br.com.gft.staffing.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gft.staffing.model.VagaTecnologia;
import br.com.gft.staffing.repository.VagaTecnologiaRepository;
import br.com.gft.staffing.service.VagaTecnologiaService;

@Service
public class VagaTecnologiaImpl implements VagaTecnologiaService {

	@Autowired
	VagaTecnologiaRepository vagaTecnologiaRepository;
	
	@Override
	public List<VagaTecnologia> findAll() {
		
		return vagaTecnologiaRepository.findAll();
	}

	@Override
	public VagaTecnologia findById(Long id) {
		
		return vagaTecnologiaRepository.findById(id).get();		
	}

	@Override
	public VagaTecnologia save(VagaTecnologia vagaTecnologia) {
	
		return vagaTecnologiaRepository.save(vagaTecnologia);
	}

}
