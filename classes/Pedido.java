package classes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public abstract class Pedido{
	@Id
	private String pedidoID;
	private Double valor;
	private String dataHora;
	
	//add date.time atributes

	@OneToMany(mappedBy="pedido", fetch = FetchType.LAZY)
	private List<Produto> produto;
	@OneToOne 
	private Cliente cliente;
	@ManyToMany 
	private List<Estoque> estoque;

	//constructors
	public Pedido() {
	}
	public Pedido(String pedidoID) {
		this.pedidoID = pedidoID;
	}
	public Pedido(String pedidoID, Double valor, String dataHora, List<Produto> produto, Cliente cliente, List<Estoque> estoque) {
		super();
		this.pedidoID = pedidoID;
		this.valor = valor;
		this.dataHora = dataHora;
		this.produto = produto;
		this.cliente = cliente;
		this.estoque = estoque;
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
		//add functions for order management
		/*such as:
	CreateOrder:
        Description: Initiates a new order.
        Parameters: Customer ID, items ordered, quantity, preferences, etc.
        Usage: When a customer places an order.

    UpdateOrder:
        Description: Allows modifications to an existing order.
        Parameters: Order ID, updated items, quantity changes, special requests, etc.
        Usage: When a customer wants to make changes to their order before it's fulfilled.

    ProcessOrder:
        Description: Handles the fulfillment of an order.
        Parameters: Order ID, status update (e.g., preparing, ready for pickup).
        Usage: When the staff starts preparing the items and throughout the order fulfillment process.

    CompleteOrder:
        Description: Marks an order as completed.
        Parameters: Order ID.
        Usage: When the customer receives their order.

    CancelOrder:
        Description: Cancels an order.
        Parameters: Order ID.
        Usage: When a customer decides to cancel an order before it's completed.

    ViewOrderDetails:
        Description: Retrieves and displays details of a specific order.
        Parameters: Order ID.
        Usage: Allows staff to check the details of an order or address customer inquiries.

    CalculateTotal:
        Description: Calculates the total cost of an order.
        Parameters: Order ID.
        Usage: Summing up the costs of items in an order for billing purposes.

    GenerateReceipt:
        Description: Creates a receipt for a completed order.
        Parameters: Order ID.
        Usage: Provides a detailed breakdown of the order for the customer.
*/
}
