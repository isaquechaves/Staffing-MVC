package br.com.gft.staffing.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gft.staffing.model.Gft;
import br.com.gft.staffing.repository.GftRepository;
import br.com.gft.staffing.service.GftService;

@Service
public class GftImpl implements GftService {

	@Autowired
	GftRepository gftRepository;
	
	@Override
	public List<Gft> findAll() {		
		return gftRepository.findAll();
	}

	@Override
	public Gft findById(Long id) {	
		return gftRepository.findById(id).get();
	}

	@Override
	public Gft save(Gft gft) {		// 
		return gftRepository.save(gft);
	}

}
