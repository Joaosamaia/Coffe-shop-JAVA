package classes;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Cliente{
	@Id
	private String clienteID;
	private String nome;
	private String telefone;
	private String email;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Endereco endereco;
	@OneToOne 
	private Pedido pedido;
	
	//constructors
	public Cliente() {
	}
	public Cliente(String clienteID) {
		this.setClienteID(clienteID);
	}
	public Cliente(String clienteID, String nome, String telefone, String email, Endereco endereco) {
		this.setClienteID(clienteID);
		this.setNome(nome);
		this.setTelefone(telefone);
		this.setEmail(email);
		this.setEndereco(endereco);
	}
	public Cliente(String clienteID, String nome, String telefone, String email, Endereco endereco, Pedido pedido) {
		this.setClienteID(clienteID);
		this.setNome(nome);
		this.setTelefone(telefone);
		this.setEmail(email);
		this.setEndereco(endereco);
		this.setPedido(pedido);
	}
	
	//getters and setters:
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public String getClienteID() {
		return clienteID;
	}
	public void setClienteID(String clienteID) {
		this.clienteID = clienteID;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	//toString
	@Override
	public String toString() {
		return "Cliente [clienteID=" + clienteID + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email
				+ ", endereco=" + endereco + ", pedido=" + pedido + "]";
	}
}
