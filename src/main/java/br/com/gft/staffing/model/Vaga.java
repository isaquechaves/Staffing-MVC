package br.com.gft.staffing.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TB_VAGA")
public class Vaga {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate abertura_vaga;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String codigo_vaga;
	
	@NotBlank
	private String descricao_vaga;
	
	@NotBlank
	private String projeto;
	
	@NotBlank
	private int qtd_vaga;
}
