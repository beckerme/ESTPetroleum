package petroleum;
import java.awt.Point;
import java.util.*;

import petroleum.Central.*;


import menu.Mapa;

/** Esta classe representa um camião, que, neste contexto, se refere à capacidade de transportar
 * combústivel. Tem para isso um limite máximo de combústivel que pode transportar e a
 * quantidade de combústvel que transporta num dado momento.
 * Cada camião desloca-se a uma velocidade, que para simplificar, iremos contabilizar como a velocidade média.
 * Um camiºão segue um itinerário, sendo que deve terminar o itinerário dentro 
 * do limite de tempo de um turno de 14 horas )2 condutores com turnos de 7 horas cada).
 */
public class Camiao {
	/** o tempo máximo de um turno, que são as 14 horas
	 * (2 condutores), dadas em segundos */
	public static final int TEMPO_TURNO = 14 * 3600;
	private String matricula;
	private int capacidade, velocidade, debito, quantidadeAtual;

	Itinerario itinerario;

	public Camiao(String matricula, int capacidade, int velocidade, int debito) {
		this.matricula = matricula;
		this.capacidade = capacidade;
		this.velocidade = velocidade;
		this.debito = debito;
	}

	public String getMatricula() {
		return matricula;
	}
	public int getQuantidadeAtual() {
		return quantidadeAtual;
	}

	public void setQuantidadeAtual(int quantidadeAtual) {
		this.quantidadeAtual = quantidadeAtual;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public int getDebito() {
		return debito;
	}

	public Itinerario getItinerario() {
		return itinerario;
	}

	/** indica se o Camião pode acrescentar o seguinte pedido ao seu itinerário
	 * @param posto posto que pede o abastecimento
	 * @param litros litros que o posto pretende
	 * @return ACEITE, se aceitar o pedido <br>
	 *         EXCEDE_CAPACIDADE_CAMIAO, se o número de litros for superior
	 *         ao que o camião tem disponível<br>
	 *         EXCEDE_TEMPO_TURNO, se o pedido implicar um tempo maior que um turno      
	 *          
	 */
	public int podeFazerPedido(Posto posto, int litros) {
		// TODO implementar este método
		if(litros>getQuantidadeAtual()){
			return Central.EXCEDE_CAPACIDADE_CAMIAO;

		} else if ((duracaoTurno()<tempoPercorrer(itinerario.getInicio(),posto.getPosicaoPosto()))){
			return Central.EXCEDE_TEMPO_TURNO;
		}

		return Central.ACEITE;
	}
	
	/** adiciona um posto ao itinerário do camião, se for possível.
	 * @param p posto que pede o abastecimento
	 * @param litros litros que o posto pretende
	 * @return ACEITE, se aceitar o pedido <br>
	 *         EXCEDE_CAPACIDADE_CAMIAO, se o número de litros for superior
	 *         ao que o camião tem disponível<br>
	 *         EXCEDE_TEMPO_TURNO, se o pedido implicar um tempo maior que um turno      
	 */
	public int addPosto( Posto p, int litros ) {
		// TODO ZFEITO fazer este método

		if(podeFazerPedido(p,litros)== Central.ACEITE)
			itinerario.addParagens(new Paragem(p, litros));

		return podeFazerPedido(p,litros);
	}

	/** retorna o tempo, em segundos, que demora a fazer o itinerário
	 * @return o tempo, em segundos, que demora a fazer o itinerário 
	 */
	public double duracaoTurno() {
		// TODO fazer este método
		return tempoPercorrer(itinerario.getInicio(), itinerario.getParagens().getLast().getPosto().getPosicaoPosto());
	}
	
	/** retorna o tempo, em segundos, que demora a fazer o itinerário
	 * acrescentando um posto extra
	 * @param extra o posto extra a processar
	 * @param nLitros oslitros que o posto extra precisa
	 * @return tempo, em segundos, que demora a fazer o itinerário mais o posto extra
	 */
	public double duracaoTurnoExtra( Posto extra, int nLitros ) {
		// TODO fazer este método

		return duracaoTurno() + tempoPercorrer(itinerario.getParagens().getLast().getPosto().getPosicaoPosto(),extra.getPosicaoPosto()) + tempoDespejar(nLitros);
	}

	/** Efetua o transporte e transferência de combustível
	 * para todos os postos no itinerário
	 */
	public void transporta( ){
		// TODO ZFEITO fazer este método
		for(Paragem p: itinerario.getParagens()){
			Posto pos = p.getPosto();
			pos.enche(p.getnLitros());
		}
	}

	/** retorna o tempo, em segundos, que demora a percorrer o caminho entre
	 * dois pontos.
	 * @param ini o ponto inical
	 * @param fim o ponto final
	 * @return o tempo que demora a ir de ini a fim.
	 */
	private double tempoPercorrer( Point ini, Point fim ){
		// TODO terminar este método (distância / velocidade)
		return Mapa.distancia(ini, fim)/this.velocidade;
	}
	
	/** retorna quanto tempo demora, em segundos, a transferir a quantidade de liquido
	 * @param nLitros a quantidade de liquido a transferir
	 * @return o tempo que demora, em segundos, a transferir os nLitros
	 */
	private double tempoDespejar( int nLitros ){
		// TODO ZFEITO fazer este método
		return ((double)nLitros/this.debito);
	}
	
	/** retorna a percentagem de ocupação do camião, entre 0 (0%) e 1 (100%)
	 * @return a percentagem de ocupação 
	 */
	public float percentagemOcupacao() {
		// TODO ZFEITO fazer este método
		return (float)(this.quantidadeAtual/100.0);
	}
	
	/** retorna a capacidade livre, isto é, quantos litros ainda pode
	 * adicionar à carga
	 * @return a capacidade livre, em litros
	 */
	public int capacidadeLivre() {
		// TODO ZFEITO fazer este método
		return this.capacidade-this.quantidadeAtual;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Camiao camiao)) return false;
        return Objects.equals(getMatricula(), camiao.getMatricula());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getMatricula());
	}
}
