package br.com.gft.staffing.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	private Long id;
	
	@NotBlank
	private String cargo;
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate inicio_wa;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate termino_wa;
	
	@NotBlank
	private String nome;
	
	@ManyToOne
	private Vaga vaga;
	
	@ManyToOne
	private Gft gft;

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	public Gft getGft() {
		return gft;
	}

	public void setGft(Gft gft) {
		this.gft = gft;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	
}
