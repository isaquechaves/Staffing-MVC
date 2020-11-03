package br.com.gft.staffing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gft.staffing.model.Vaga;

public interface VagaRepository extends JpaRepository<Vaga, Long> {

}
