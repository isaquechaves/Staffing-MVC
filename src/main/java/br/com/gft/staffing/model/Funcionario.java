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
@Table(name ="TB_FUNCIONARIO")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@NotBlank
	private String cargo;
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate inicio_wa;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate termino_wa;
	
	@NotBlank
	private String nome;
	
	
	private Long alocacao_Id;
	
	
	private Long local_de_trabalho;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public LocalDate getInicio_wa() {
		return inicio_wa;
	}

	public void setInicio_wa(LocalDate inicio_wa) {
		this.inicio_wa = inicio_wa;
	}

	public LocalDate getTermino_wa() {
		return termino_wa;
	}

	public void setTermino_wa(LocalDate termino_wa) {
		this.termino_wa = termino_wa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getAlocacao_Id() {
		return alocacao_Id;
	}

	public void setAlocacao_Id(Long alocacao_Id) {
		this.alocacao_Id = alocacao_Id;
	}

	public Long getLocal_de_trabalho() {
		return local_de_trabalho;
	}

	public void setLocal_de_trabalho(Long local_de_trabalho) {
		this.local_de_trabalho = local_de_trabalho;
	}
	
	
}
