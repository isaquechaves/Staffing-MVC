package br.com.gft.staffing.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_vaga_tecnologia")
public class VagaTecnologia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Vaga vaga;
	
	@ManyToOne
	private Tecnologia tecnologia;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}
	
	public Tecnologia getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(Tecnologia tecnologia) {
		this.tecnologia = tecnologia;
	}
	
	
}
