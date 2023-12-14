package classes;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Fornecedor {
	@Id
	private String CNPJ;
	@Column(name="NOME")
	private String nome;
	@Column(name="TELEFONE")
	private String telefone;
	@Column(name="EMAIL")
	private Integer email;
	
	@OneToOne
	private Endereco endereco;
	@OneToMany(mappedBy="produto")
	private List<Produto> produto;

	public Fornecedor() {
	}
	public Fornecedor(String cNPJ) {
		CNPJ = cNPJ;
	}
	public Fornecedor(String cNPJ, String nome, String telefone, Integer email, Endereco endereco,
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
	
	public Integer getEmail() {
		return email;
	}
	public void setEmail(Integer email) {
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
