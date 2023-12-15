package classes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Endereco {
	@Id
	private String CEP;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;
	
	@OneToMany(mappedBy="endereco", fetch = FetchType.LAZY)
	private List<Funcionario> funcionario;
	@OneToMany(mappedBy="endereco", fetch = FetchType.LAZY)
	private List<Cliente> cliente;

	@OneToOne
	private Fornecedor fornecedor;
	
	//constructors
	public Endereco(String CEP) {
		super();
		this.CEP = CEP;
	}
	public Endereco(String CEP	, String rua, String bairro, String cidade, String estado, String pais, Fornecedor fornecedor) {
		super();
		this.setCEP(CEP);
		this.setRua(rua);
		this.setBairro(bairro);
		this.setCidade(cidade);
		this.setEstado(estado);
		this.setPais(pais);
		this.setFornecedor(fornecedor);
	}
	public Endereco(String cEP, String rua, String bairro, String cidade, String estado, String pais) {
		super();
		this.setCEP(CEP);
		this.setRua(rua);
		this.setBairro(bairro);
		this.setCidade(cidade);
		this.setEstado(estado);
		this.setPais(pais);
	}
	//getters and setters:

	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		this.CEP = cEP;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor Fornecedor) {
		this.fornecedor = Fornecedor;
	}
	public List<Cliente> getCliente() {
		return cliente;
	}
	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}
	public List<Funcionario> getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}

}
