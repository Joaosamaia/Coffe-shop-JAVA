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
public class Pedido{
	@Id
	private String pedidoID;
	private Double valor;
	private String dataHora;

	@OneToMany(mappedBy="pedido", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Produto> produto;
	@OneToOne 
	private Cliente cliente;
	@ManyToMany(mappedBy = "fornecedor")
	private List<Estoque> estoque;

	//constructors
	public Pedido() {
	}
	public Pedido(String pedidoID) {
		this.setPedidoID(pedidoID);
	}
	public Pedido(String pedidoID, Double valor, String dataHora, List<Produto> produto, Cliente cliente) {
		super();
		this.setPedidoID(pedidoID);
		this.setValor(valor);
		this.setDataHora(dataHora);
		this.setProduto(produto);
		this.setCliente(cliente);
	}
	public Pedido(String pedidoID, Double valor, String dataHora, List<Produto> produto, Cliente cliente, List<Estoque> estoque) {
		super();
		this.setPedidoID(pedidoID);
		this.setValor(valor);
		this.setDataHora(dataHora);
		this.setProduto(produto);
		this.setCliente(cliente);
		this.setEstoque(estoque);
	}
	
	//getters and setters:
	public String getPedidoID() {
		return pedidoID;
	}
	public void setPedidoID(String pedidoID) {
		this.pedidoID = pedidoID;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Produto> getProduto() {
		return produto;
	}
	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getDataHora() {
		return dataHora;
	}
	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
	public List<Estoque> getEstoque() {
		return estoque;
	}
	public void setEstoque(List<Estoque> estoque) {
		this.estoque = estoque;
	}

	//toString
	@Override
	public String toString() {
		return "Pedido [pedidoID=" + pedidoID + ", valor=" + valor + ", dataHora=" + dataHora + ", produto=" + produto
				+ ", cliente=" + cliente + ", estoque=" + estoque + "]";
	}
}
