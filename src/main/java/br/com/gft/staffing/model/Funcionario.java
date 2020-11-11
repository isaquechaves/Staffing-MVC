package br.com.gft.staffing.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name ="TB_FUNCIONARIO")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Cargo é obrigatório")
	@Size(max = 60, message = "Cargo não pode conter mais de 60 caracteres")
	private String cargo;
	
	@NotBlank(message = "Level é obrigatório")
	private String level;
	
	@NotNull(message="Data de início WA é obrigatória")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate inicio_wa;
	
	@NotNull(message="Data de vencimento WA é obrigatória")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate termino_wa;
	
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate inicio_alocacao;
	
	@NotBlank(message = "Nome é obrigatório")
	@Size(max = 100, message = "Nome não pode conter mais de 100 caracteres")
	private String nome;
	
	
	@ManyToOne
	private Vaga vaga;
	
	@ManyToOne
	private Gft gft;
	
	@ManyToMany
	@JoinTable(name = "tb_funcionario_tecnologia",
		joinColumns = @JoinColumn(name = "funcionario_id"),
		inverseJoinColumns = @JoinColumn(name = "tecnologia_id"))
	private List<Tecnologia> tecnologias;
		
	
	
	
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public LocalDate getInicio_alocacao() {
		return inicio_alocacao;
	}

	public void setInicio_alocacao(LocalDate inicio_alocacao) {
		this.inicio_alocacao = inicio_alocacao;
	}

	public List<Tecnologia> getTecnologias() {
		return tecnologias;
	}

	public void setTecnologias(List<Tecnologia> tecnologias) {
		this.tecnologias = tecnologias;
	}

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
