package percursos;

import estruturas.*;

/**
 * Uma paragem do itinerário deve indicar
 * o posto onde se deve parar e quantos litros
 * devem ser transferidos para o posto
 */
public class Paragem {

	// Variaveis e Objetos

	private Posto posto;
	private int nLitros;

	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	// Construtor
	
	public Paragem(Posto posto, int nLitros) {

		// TODO ZFEITO fazer validações aqui
		if(nLitros > 0){
			this.nLitros = nLitros; 
		} else this.nLitros = 0;

		if(posto != null){
			this.posto = posto;
		}
	}

	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	// Getters e Setters
	
	public Posto getPosto() {
		return posto;
	}

	public void setPosto(Posto posto) {
		this.posto = posto;
	}

	public int getnLitros() {
		return nLitros;
	}

	public void setnLitros(int nLitros) {
		if(nLitros<0) {
			nLitros=0;
		}
		this.nLitros = nLitros;
	}
}
