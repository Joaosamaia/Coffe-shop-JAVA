package classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


@Entity
public abstract class Pedido{
	@Id
	@GeneratedValue(generator = "custom-generator")
   	@GenericGenerator(name = "custom-generator", strategy = "com.project.CustomIdGenerator")
	private String pedidoID;
	private Cliente cliente;
	private Produto produto;
	private Double valor;
	private String dataHora;
	//add date.time atributes


	//constructors
	public Pedido() {
	}
	public Pedido(String pedidoID) {
		this.pedidoID = pedidoID;
	}
	public Pedido(String pedidoID, Cliente cliente, Produto produto, Double valor, String dataHora) {
		this.pedidoID = pedidoID;
		this.cliente = cliente;
		this.produto = produto;
		this.valor = valor;
		this.dataHora = dataHora;
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

	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
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
}