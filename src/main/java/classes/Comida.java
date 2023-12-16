package classes;

import javax.persistence.Entity;

@Entity
public class Comida extends Produto{
	private String tipo;
	private String ingredientes;
	private String descricao;
	
	//constructors
	public Comida(String produtoID, String nome, Double preco, Double porcao, Fornecedor fornecedor, Estoque estoque,
	Pedido pedido) {
		super(produtoID, nome, preco, porcao, fornecedor, estoque, pedido);
	}
	public Comida(String produtoID, String nome, Double preco, Double porcao, Fornecedor fornecedor, Estoque estoque,
			Pedido pedido, String tipo, String ingredientes, String descricao) {
		super(produtoID, nome, preco, porcao, fornecedor, estoque, pedido);
		this.setTipo(tipo);
		this.setIngredientes(ingredientes);
		this.setDescricao(descricao);
	}
	public Comida(String produtoID, String nome, Double preco, Double porcao, Fornecedor fornecedor, Estoque estoque,
		String tipo, String ingredientes, String descricao) {
		super(produtoID, nome, preco, porcao, fornecedor, estoque);
		this.setTipo(tipo);
		this.setIngredientes(ingredientes);
		this.setDescricao(descricao);
	}
	public Comida(String produtoID, String nome, Double preco) {
		super(produtoID, nome, preco);
	}
	public Comida() {
		super();
	}	

	//getters and setters:
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	//toString
	@Override
	public String toString() {
		return "Comida [tipo=" + tipo + ", ingredientes=" + ingredientes + ", descricao=" + descricao + "]";
	}	
}
