package classes;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public abstract class Produto{
	@Id
	private String produtoID;
	private String nome;
	private Double preco;
	private Double porcao;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fornecedor_id")
	private Fornecedor fornecedor;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "estoque_id")
	private Estoque estoque;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;
	
	//constructors
	public Produto(String produtoID, String nome, Double preco, Double porcao, Fornecedor fornecedor, Estoque estoque,
	Pedido pedido) {
		this.setProdutoID(produtoID);
		this.setNome(nome);
		this.setPreco(preco);
		this.setPorcao(porcao);
		this.setFornecedor(fornecedor);
		this.setEstoque(estoque);
		this.setPedido(pedido);
	}
	public Produto(String produtoID, String nome, Double preco, Double porcao, Fornecedor fornecedor, Estoque estoque) {
		this.setProdutoID(produtoID);
		this.setNome(nome);
		this.setPreco(preco);
		this.setPorcao(porcao);
		this.setFornecedor(fornecedor);
		this.setEstoque(estoque);
	}
	public Produto(String produtoID, String nome, Double preco) {
		this.setProdutoID(produtoID);
		this.setNome(nome);
		this.setPreco(preco);
	}
	public Produto() {
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
	public Double getPorcao() {
		return porcao;
	}
	public void setPorcao(Double porcao) {
		this.porcao = porcao;
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
	
	//toString
	@Override
	public String toString() {
		return "Produto [produtoID=" + produtoID + ", nome=" + nome + ", preco=" + preco + ", porcao=" + porcao
				+ ", fornecedor=" + fornecedor + ", estoque=" + estoque + ", pedido=" + pedido + "]";
	}
}
