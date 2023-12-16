package classes;

import javax.persistence.Entity;

@Entity
public class Bebida extends Produto{
	private String tipo;
	private String ingredientes;
	private String temperatura;
	private String descricao;

	//constructors
	public Bebida(String produtoID,String nome, Double preco, Double porcao, Fornecedor fornecedor, Estoque estoque, String tipo, String ingredientes, String temperatura, String descricao) {
		super(produtoID, nome, preco, porcao, fornecedor, estoque);
		this.setTipo(tipo);
		this.setIngredientes(ingredientes);
		this.setTemperatura(temperatura);
		this.setDescricao(descricao);
	}
	public Bebida(String produtoID,String nome, Double preco, Double porcao, Fornecedor fornecedor, Estoque estoque,
	Pedido pedido) {
		super(produtoID, nome, preco, porcao, fornecedor, estoque, pedido);
	}
	public Bebida(String produtoID, String nome, Double preco) {
		super(produtoID, nome, preco);
	}
	public Bebida() {
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
	public String getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
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
		return "Bebida [tipo=" + tipo + ", ingredientes=" + ingredientes + ", temperatura=" + temperatura
				+ ", descricao=" + descricao + "]";
	}	
}
