package classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public abstract class Produto{
	@Id
	@GeneratedValue(generator = "custom-generator")
   	@GenericGenerator(name = "custom-generator", strategy = "com.project.CustomIdGenerator")
	private String produtoID;
	@Column(name="NOME")
	private String nome;
	@Column(name="PRECO")
	private Double preco;
	@Column(name="ESTOQUE")
	private Integer estoque;
	@Column(name="PORÇAO")
	private Double porcão;

	@ManyToOne
	private Fornecedor fornecedor;

	//constructors
	public Produto() {
	}
	public Produto(String produtoID) {
		this.produtoID = produtoID;
	}
	public Produto(String produtoID, String nome, Integer estoque, Double preco, Fornecedor fornecedor) {
		this.produtoID = produtoID;
		this.nome = nome;
		this.estoque = estoque;
		this.preco = preco;
		this.fornecedor = fornecedor;
	}

	//getters and setters:

	public String getProdutoID() {
		return produtoID;
	}
	public void setProdutoID(String produtoID) {
		this.produtoID = produtoID;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getEstoque() {
		return estoque;
	}
	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Double getPorcão() {
		return porcão;
	}
	public void setPorcão(Double porcão) {
		this.porcão = porcão;
	}


	//add functions for stock management, venda, compra
}