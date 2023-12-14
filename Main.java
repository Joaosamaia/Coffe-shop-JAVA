import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import classes.Fiat;
import classes.BMW;
import classes.Cherry;
import classes.Dono;
import classes.Endereco;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("PersistenceUnitJPA");
		EntityManager entity = entityFactory.createEntityManager();
		
		entity.getTransaction().begin();
		
		//modelar as classes

		//create UI menu
		
		//create functions to automate table creation, update and delete

		Dono dono1 = new Dono("123.456.789-10");
 		dono1.setNome("Jao");
		dono1.setTelefone("(81) 4002-8922");
		dono1.setIdade(23);
 		dono1.setDataNascimento("dia 1");
 		

		
		Dono dono2 = new Dono("123.456.789-11");
		dono2.setNome("Hann");
		dono2.setTelefone("(81) 4002-8922");
		dono2.setIdade(21);
		dono2.setDataNascimento("dia 2");
		
		
		Dono dono3 = new Dono("123.456.789-12");
		dono3.setNome("Anto");
		dono3.setTelefone("(81) 4002-8922");
		dono3.setIdade(10);
		dono3.setDataNascimento("dia 3");
		
		
		
		Endereco endereco1 = new Endereco("12345", "ali", "varzea", "recife", "pe", "br", null);
		endereco1.setDono(dono1);
		dono1.setEndereco(endereco1);
		Endereco endereco2 = new Endereco("123456","aqui", "varzea", "recife", "pe", "br", null);
		endereco2.setDono(dono1);
		dono2.setEndereco(endereco2);
		Endereco endereco3 = new Endereco("1234567","ali", "cdu", "recife", "pe", "br", null);
		endereco3.setDono(dono1);
		dono3.setEndereco(endereco3);
		Endereco endereco4 = new Endereco("12345678","aqui", "cdu", "recife", "pe", "br", null);
		
		Fiat carro1 = new Fiat("A", "ABC-1234", 2000, dono1);
		BMW carro2 = new BMW("B", "DEF-5678", 2012, dono2);
		Cherry carro3 = new Cherry("C", "GHI-9123", 2010, dono1);
		Fiat carro4 = new Fiat("D", "JKL-4567", 2020, dono3);
		BMW carro5 = new BMW("E", "MNO-8912", 2023, dono1);
		
		entity.persist(endereco1);
		entity.persist(endereco2);
		entity.persist(endereco3);
		entity.persist(endereco4);

		
		entity.persist(dono1);
		entity.persist(dono2);
		entity.persist(dono3);
		
		entity.persist(carro1);
		entity.persist(carro2);
		entity.persist(carro3);
		entity.persist(carro4);
		entity.persist(carro5);
//		
//		
		entity.getTransaction().commit();
		
//		entity.close();
//		entityFactory.close();
	}

}
