import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import classes.Fornecedor;
import classes.Funcionario;
import classes.Cliente;
import classes.Endereco;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("PersistenceUnitJPA");
		EntityManager entity = entityFactory.createEntityManager();
		
		entity.getTransaction().begin();
		
		//create UI menu
		
		//create functions to automate table creation, update and delete

		Fornecedor dono1 = new Fornecedor("123.456.789-09");
 		dono1.setNome("Jao");
		dono1.setTelefone("(81) 4002-8922");
 		dono1.setEmail("dia 1");
 		

		
		Cliente cliente1 = new Cliente("123.456.789-11");
		cliente1.setNome("Hann");
		cliente1.setTelefone("(81) 4002-8922");
		Cliente cliente2 = new Cliente("123.456.789-10");
		cliente1.setNome("Hanna");
		cliente1.setTelefone("(81) 4002-8922");
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(cliente1);
		clientes.add(cliente2);
		
		Funcionario funcionario1 = new Funcionario("123.456.789-12");
		funcionario1.setNome("Anto");
		funcionario1.setTelefone("(81) 4002-8922");
		Funcionario funcionario2 = new Funcionario("123.456.789-13");
		funcionario1.setNome("Anton");
		funcionario1.setTelefone("(81) 4002-8922");
		
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		funcionarios.add(funcionario1);
		funcionarios.add(funcionario2);
		
		Endereco endereco1 = new Endereco("12345");
		endereco1.setCliente(clientes);
		Endereco endereco2 = new Endereco("123456");
		endereco2.setFuncionario(funcionarios);
		Endereco endereco3 = new Endereco("1234567");
		endereco3.setFornecedor(dono1);
		Endereco endereco4 = new Endereco("12345678");
		
		
		entity.persist(endereco1);
		entity.persist(endereco2);
		entity.persist(endereco3);
		entity.persist(endereco4);

		
		entity.persist(dono1);
		entity.persist(cliente1);
		entity.persist(cliente2);
		entity.persist(funcionario1);
		entity.persist(funcionario2);
		
//		
//		
		entity.getTransaction().commit();
		
		entity.close();
		entityFactory.close();
	}

}
