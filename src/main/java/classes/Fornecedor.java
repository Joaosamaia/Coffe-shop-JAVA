package classes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Fornecedor {
	@Id
	private String cnpj;
	private String nome;
	private String telefone;
	private String email;
	
	@OneToOne
	private Endereco endereco;
	@OneToMany(mappedBy="fornecedor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Produto> produto;
	@ManyToMany(mappedBy = "fornecedor")
	private List<Estoque> estoque;
	
	//constructors
	public Fornecedor() {
	}
	public Fornecedor(String cnpj) {
		this.setCnpj(cnpj);
	}
	public Fornecedor(String cnpj, String nome, String telefone, String email, Endereco endereco,
	List<Produto> produto) {
		this.setCnpj(cnpj);
		this.setNome(nome);;
		this.setTelefone(telefone);
		this.setEmail(email);
		this.setEndereco(endereco);
		this.setProduto(produto);
	}
	
	//getters and setters:
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
	
	public List<Produto> getProduto() {
		return produto;
	}
	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
	//toString
	@Override
	public String toString() {
		return "Fornecedor [cnpj=" + cnpj + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email
				+ ", endereco=" + endereco + ", produto=" + produto + ", estoque=" + estoque + "]";
	}
}
