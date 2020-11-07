package br.com.gft.staffing.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany
	@JoinTable(name = "tb_vaga_tecnologia",
			joinColumns = @JoinColumn(name = "vaga_id"),
			inverseJoinColumns  = @JoinColumn(name = "tecnologia_id"))
	private List<Tecnologia> tecnologias;
		
	private int qtd_vaga;

	
	
	public List<Tecnologia> getTecnologias() {
		return tecnologias;
	}

	public void setTecnologias(List<Tecnologia> tecnologias) {
		this.tecnologias = tecnologias;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public LocalDate getAbertura_vaga() {
		return abertura_vaga;
	}

	public void setAbertura_vaga(LocalDate abertura_vaga) {
		this.abertura_vaga = abertura_vaga;
	}

	public String getCodigo_vaga() {
		return codigo_vaga;
	}

	public void setCodigo_vaga(String codigo_vaga) {
		this.codigo_vaga = codigo_vaga;
	}

	public String getDescricao_vaga() {
		return descricao_vaga;
	}

	public void setDescricao_vaga(String descricao_vaga) {
		this.descricao_vaga = descricao_vaga;
	}

	public String getProjeto() {
		return projeto;
	}

	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}

	public int getQtd_vaga() {
		return qtd_vaga;
	}

	public void setQtd_vaga(int qtd_vaga) {
		this.qtd_vaga = qtd_vaga;
	}
	
	
}
