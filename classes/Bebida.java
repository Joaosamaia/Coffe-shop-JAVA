package classes;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bebida extends Produto{
	//add bebida specific atributes
	@Id
	private String tipo;
	private String ingredientes;
	private String temperatura;

	//create constructors


	//implement methods for Bebida
	void imprimir(String a) {
	}
	
}
