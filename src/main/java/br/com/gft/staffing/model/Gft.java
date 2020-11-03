package br.com.gft.staffing.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "TB_GFT")
public class Gft {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	private String cep;
	
	@NotBlank
	private String cidade;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String estado;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String telefone;
	
}
