package br.com.gft.staffing.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gft.staffing.model.Funcionario;
import br.com.gft.staffing.repository.StaffingRepository;
import br.com.gft.staffing.service.StaffingService;

@Service
public class StaffingImpl implements StaffingService {

	@Autowired
	StaffingRepository staffingRepository;
	
	@Override
	public List<Funcionario> findAll() {
		return staffingRepository.findAll();
	}

	@Override
	public Funcionario findById(Long Id) {
		return staffingRepository.findById(Id).get();
	}

	@Override
	public Funcionario save(Funcionario funcionario) {
		return staffingRepository.save(funcionario);
	}
	
}
