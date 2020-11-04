package br.com.gft.staffing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gft.staffing.model.FuncionarioTecnologia;

public interface FuncionarioTecRepository extends JpaRepository<FuncionarioTecnologia, Long> {

}
