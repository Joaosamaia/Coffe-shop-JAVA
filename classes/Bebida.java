package classes;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bebida extends Produto{
	//add bebida specific atributes
	private String tipo;
	private String ingredientes;
	private String temperatura;
	private String descricao;

	//create constructors


	//implement methods for Bebida
	void imprimir(String a) {
	}
	
}
