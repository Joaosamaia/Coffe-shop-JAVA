package classes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public abstract class Pessoa{
	@Id
	@GeneratedValue(generator = "custom-generator")
   	@GenericGenerator(name = "custom-generator", strategy = "com.project.CustomIdGenerator")
	private String pessoaID;
   	@Column(name="NOME")
	private String nome;
	@Column(name="TELEFONE")
	private String telefone;
	@Column(name="EMAIL")
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private List<Endereco> endereco;

	//constructors
	public Pessoa() {
		super();
	}
	public Pessoa(String pessoaID) {
		this.pessoaID = pessoaID;
	}
	public Pessoa(String pessoaID, String nome, String telefone, String email, List<Endereco> endereco) {
		this.pessoaID = pessoaID;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
	}

	//getters and setters:

	public String getpessoaID() {
		return pessoaID;
	}
	public void setpessoaID(String pessoaID) {
		this.pessoaID = pessoaID;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}
	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}
}