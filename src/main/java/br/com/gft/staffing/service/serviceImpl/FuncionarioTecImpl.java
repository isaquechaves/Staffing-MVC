package br.com.gft.staffing.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.gft.staffing.model.FuncionarioTecnologia;
import br.com.gft.staffing.service.FuncionarioTecService;
import br.com.gft.staffing.repository.FuncionarioTecRepository;

@Service
public class FuncionarioTecImpl implements FuncionarioTecService {
	
	@Autowired
	FuncionarioTecRepository funcionarioTecRepository;
	
	@Override
	public List<FuncionarioTecnologia> findAll() {		
		
		return funcionarioTecRepository.findAll();
	}

	@Override
	public FuncionarioTecnologia finById(Long id) {
		
		return funcionarioTecRepository.findById(id).get();
	}

	@Override
	public FuncionarioTecnologia save(FuncionarioTecnologia funcionarioTecnologia) {
	
		return funcionarioTecRepository.save(funcionarioTecnologia);
	}
	

}
