package classes;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Fornecedor {
	@Id
	private String CNPJ;
	private String nome;
	private String telefone;
	private String email;
	
	@OneToOne
	private Endereco endereco;
	@OneToMany(mappedBy="fornecedor")
	private List<Produto> produto;
	@ManyToMany 
	private List<Estoque> estoque;

	public Fornecedor() {
	}
	public Fornecedor(String cNPJ) {
		CNPJ = cNPJ;
	}
	public Fornecedor(String cNPJ, String nome, String telefone, String email, Endereco endereco,
			List<Produto> produto) {
		CNPJ = cNPJ;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.produto = produto;
	}


	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
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
}
