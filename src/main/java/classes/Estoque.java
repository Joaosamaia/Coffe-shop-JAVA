package classes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Estoque {
    @Id
	private String estoqueID;
    private Integer quantidade;
    
    @OneToMany(mappedBy="estoque", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Produto> produto;
    @ManyToMany
    private List<Pedido> pedido;
    @ManyToMany 
    private List<Fornecedor> fornecedor;

    //constructors
    public Estoque() {
    }
    public Estoque(String estoqueID) {
        this.setEstoqueID(estoqueID);
    }
    public Estoque(String estoqueID, Integer quantidade, List<Produto> produtos, List<Pedido> pedido, List<Fornecedor> fornecedor) {
        this.setEstoqueID(estoqueID);
        this.setQuantidade(quantidade);
        this.setProduto(produtos);
        this.setPedido(pedido);
        this.setFornecedor(fornecedor);
    }

	//getters and setters:
    public String getEstoqueID() {
		return estoqueID;
	}
    public void setEstoqueID(String estoqueID) {
		this.estoqueID = estoqueID;
	}
	public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
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
    
    //toString
    @Override
    public String toString() {
        return "Estoque [estoqueID=" + estoqueID + ", quantidade=" + quantidade + ", produto=" + produto + ", pedido="
                + pedido + ", fornecedor=" + fornecedor + "]";
    }
}
