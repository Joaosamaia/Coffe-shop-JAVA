package classes;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Comida extends Produto{
	//add comida specific atributes
	private String tipo;
	private String ingredientes;
	private String descricao;
	
	//create constructors


	//implement methods for Comida
	void imprimir(String a) {
	}
	
}
