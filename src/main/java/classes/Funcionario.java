package classes;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Funcionario{
	@Id
	private String pessoaID;
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	private String cargo;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Endereco endereco;
	
	//constructors
	public Funcionario() {
	}
	public Funcionario(String pessoaID) {
		this.setPessoaID(pessoaID);
	}
	public Funcionario(String pessoaID, String cpf, String nome, String telefone, String email, String cargo,
	Endereco endereco) {
		this.setPessoaID(pessoaID);
		this.setCPF(cpf);
		this.setNome(nome);
		this.setTelefone(telefone);
		this.setEmail(email);
		this.setCargo(cargo);
		this.setEndereco(endereco);
	}
	
	//getters and setters:
	public String getCPF() {
		return cpf;
	}
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getPessoaID() {
		return pessoaID;
	}
	public void setPessoaID(String pessoaID) {
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	//toString
	@Override
	public String toString() {
		return "Funcionario [pessoaID=" + pessoaID + ", cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone
				+ ", email=" + email + ", cargo=" + cargo + ", endereco=" + endereco + "]";
	}
}
