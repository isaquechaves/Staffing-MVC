package br.com.gft.staffing.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gft.staffing.model.Vaga;
import br.com.gft.staffing.repository.VagaRepository;
import br.com.gft.staffing.service.VagaService;
import br.com.gft.staffing.service.filter.VagaFilter;

@Service
public class VagaImpl implements VagaService{

	@Autowired
	VagaRepository vagaRepository;
	
	@Override
	public List<Vaga> findAll() {		
		return vagaRepository.findAll();
	}

	@Override
	public Vaga findById(Long id) {
		return vagaRepository.findById(id).get();		
	}

	@Override
	public Vaga save(Vaga vaga) {
		return vagaRepository.save(vaga);
	}

	@Override
	public List<Vaga> filtrar(VagaFilter filtro) {
		String descricao = filtro.getDescricaoVaga() == null ? "" : filtro.getDescricaoVaga();
		return vagaRepository.findByDescricaoVagaContaining(descricao);
	}

}
