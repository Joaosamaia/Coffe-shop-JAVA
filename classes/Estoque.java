package classes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Estoque {
    @Id
	private String estoqueID;
    
    @OneToMany(mappedBy="estoque", fetch = FetchType.LAZY)
    private List<Produto> produto;
    @ManyToMany 
    private List<Pedido> pedido;
    @ManyToMany 
    private List<Fornecedor> fornecedor;
    
	//getters and setters:
    
	public String getEstoqueID() {
		return estoqueID;
	}
	public void setEstoqueID(String estoqueID) {
		this.estoqueID = estoqueID;
	}
	public List<Produto> getProduto() {
		return produto;
	}
	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	public List<Pedido> getPedido() {
		return pedido;
	}
	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}
	public List<Fornecedor> getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(List<Fornecedor> fornecedor) {
		this.fornecedor = fornecedor;
	}
    
    	//add functions for stock management, venda, compra
		/*such as:
	AddStockItem:
        Description: Adds a new item to the stock inventory.
        Parameters: Item details (name, quantity, supplier information, etc.).
        Usage: When a new product or ingredient is added to the inventory.

    UpdateStockItem:
        Description: Modifies the details of an existing stock item.
        Parameters: Item ID and updated information (quantity, supplier, etc.).
        Usage: When there are changes in stock item details, such as quantity adjustments or supplier updates.

    RemoveStockItem:
        Description: Removes a stock item from the inventory.
        Parameters: Item ID.
        Usage: When a product or ingredient is no longer carried or is no longer in stock.

    RestockItem:
        Description: Adds additional quantity to an existing stock item.
        Parameters: Item ID, quantity.
        Usage: When new stock is received from a supplier.

    ViewStockDetails:
        Description: Retrieves and displays details of a specific stock item.
        Parameters: Item ID.
        Usage: Allows staff to check the current stock level and details for inventory management.

    CheckStockAvailability:
        Description: Verifies if a particular item is available in the current stock.
        Parameters: Item ID, quantity requested.
        Usage: Before processing an order to ensure there is enough stock.

    AdjustStockLevel:
        Description: Manually adjusts the stock level for a particular item.
        Parameters: Item ID, new quantity.
        Usage: To correct discrepancies or errors in the recorded stock levels.

    GenerateStockReport:
        Description: Generates a report of the current stock status.
        Parameters: Date range, categories, etc.
        Usage: Provides insights into stock levels for management and ordering purposes.
*/

}
