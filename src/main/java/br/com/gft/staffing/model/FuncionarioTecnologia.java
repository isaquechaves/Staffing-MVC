package br.com.gft.staffing.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_funcionario_tecnologia")
public class FuncionarioTecnologia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne	
	private Funcionario funcionario;
	
	@ManyToOne
	private Tecnologia tecnologia;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Tecnologia getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(Tecnologia tecnologia) {
		this.tecnologia = tecnologia;
	}
	
}
