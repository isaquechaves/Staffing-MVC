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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "TB_VAGA")
public class Vaga {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@NotNull(message="Data de abertura é obrigatória")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate aberturaVaga;
	
	@NotBlank(message = "Código é obrigatório")
	@Size(max = 10, message = "Código não pode conter mais de 10 caracteres")
	private String codigoVaga;
	
	@NotBlank(message = "Descrição é obrigatório")
	@Size(max = 60, message = "Descrição não pode conter mais de 60 caracteres")
	private String descricaoVaga;
	
	@NotBlank(message = "Cliente é obrigatório")
	@Size(max = 60, message = "Cliente não pode conter mais de 60 caracteres")
	private String cliente;
	
	@NotBlank(message = "Projeto é obrigatório")
	@Size(max = 60, message = "Projeto não pode conter mais de 60 caracteres")
	private String projeto;
	
	@ManyToMany
	@JoinTable(name = "tb_vaga_tecnologia",
			joinColumns = @JoinColumn(name = "vaga_id"),
			inverseJoinColumns  = @JoinColumn(name = "tecnologia_id"))
	private List<Tecnologia> tecnologias;
		
	private int qtdVaga;

	
	
	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

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
		return aberturaVaga;
	}

	public void setAbertura_vaga(LocalDate abertura_vaga) {
		this.aberturaVaga = abertura_vaga;
	}

	public String getCodigo_vaga() {
		return codigoVaga;
	}

	public void setCodigo_vaga(String codigo_vaga) {
		this.codigoVaga = codigo_vaga;
	}

	public String getDescricao_vaga() {
		return descricaoVaga;
	}

	public void setDescricao_vaga(String descricao_vaga) {
		this.descricaoVaga = descricao_vaga;
	}

	public String getProjeto() {
		return projeto;
	}

	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}

	public int getQtd_vaga() {
		return qtdVaga;
	}

	public void setQtd_vaga(int qtd_vaga) {
		this.qtdVaga = qtd_vaga;
	}
	
	
}
