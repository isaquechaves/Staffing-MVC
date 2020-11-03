package br.com.gft.staffing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gft.staffing.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
}
