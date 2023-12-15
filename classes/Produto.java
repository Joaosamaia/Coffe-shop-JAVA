package classes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public abstract class Produto{
	@Id
	private String produtoID;
	private String nome;
	private Double preco;
	private Double porcão;

	@ManyToOne
	private Fornecedor fornecedor;
	@ManyToOne 
	private Estoque estoque;
	@ManyToOne 
	private Pedido pedido;

	//constructors
	public Produto() {
	}
	public Produto(String produtoID) {
		this.produtoID = produtoID;
	}
	public Produto(String produtoID, String nome, Double preco, Double porcão, Fornecedor fornecedor, Estoque estoque,
			Pedido pedido) {
		super();
		this.produtoID = produtoID;
		this.nome = nome;
		this.preco = preco;
		this.porcão = porcão;
		this.fornecedor = fornecedor;
		this.estoque = estoque;
		this.pedido = pedido;
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

	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Double getPorcão() {
		return porcão;
	}
	public void setPorcão(Double porcão) {
		this.porcão = porcão;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	

}
