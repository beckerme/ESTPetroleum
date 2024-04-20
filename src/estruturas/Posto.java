package estruturas;

import java.awt.*;
import java.util.*;

/** Um posto do sistema. Um posto deve ter uma capacidade
 * máxima de combustível, assim como a quantidade de combustível que tem.
 * Para simular o uso do posto assume-se que ele tem num gasto médio diário,
 * o que significa que todos os dias, o posto vende esse combústivel.
 */
public class Posto {

	// Constantes da classe Posto

	/** Indica a capacidade (em percentagem) a partir da qual o posto não aceita
	 * novos pedidos abastecimento */
	public static final double OCUPACAO_SUFICIENTE = 0.75;

	/** Indica a capacidade (em percentagem) abaixo da qual o
	 * posto precisa de fazer um pedido */
	public static final double OCUPACAO_MINIMA = 0.25;

	/**Probabilidade de um posto fazer um pedido
	 * */
	public static final double PROBABILIDADE_NOVO_PEDIDO = 0.10;

	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	// Variáveis da classe Posto

	private int id, gastoMedio, quantidadeAtual, capacidadeTotal;
	private String nomePosto;
	private Point posicaoPosto;

	boolean pedidoPendente;

	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	// Construtor do Posto

	public Posto(int id, int gastoMedio, int quantidadeAtual, int capacidadeTotal, String nomePosto, Point posicaoPosto) {

		// TODO ZFEITO FAZER AS VALIDAÇÕES

		this.id = id;

		if(gastoMedio < 0) {
			this.gastoMedio = 0;
		}
		this.gastoMedio = gastoMedio;

		if(quantidadeAtual < 0) {
			this.quantidadeAtual = 0;
		}
		this.quantidadeAtual = quantidadeAtual;

		if(capacidadeTotal < 0 || capacidadeTotal < quantidadeAtual) {
			this.capacidadeTotal = quantidadeAtual;
		}
		this.capacidadeTotal = capacidadeTotal;

		this.nomePosto = nomePosto;

		this.posicaoPosto = posicaoPosto;
	}

	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	/**Getters e Setters da classe
	 * */

	public int getId() {
		return id;
	}

	public int getGastoMedio() {
		return gastoMedio;
	}

	public int setGastoMedio() {

		// verifica se o gasto médio é válido
		if(this.gastoMedio < 0)
			return this.gastoMedio = 0;
		return this.gastoMedio;

	}

	public int getQuantidadeAtual() {
		return quantidadeAtual;
	}

	public void setQuantidadeAtual(int quantidadeAtual) {

		// verifica se a quantidade atual de combústivel é válida (se for menor que 0)
		if(quantidadeAtual < 0) {
			quantidadeAtual = 0;
		}

		//(se for maior que a Capacidade Total de combústivel do Posto)
		if(quantidadeAtual > getCapacidadeTotal()) {
			this.quantidadeAtual = getCapacidadeTotal();
		}

		this.quantidadeAtual = quantidadeAtual;
	}

	public int getCapacidadeTotal() {
		return capacidadeTotal;
	}

	public String getNomePosto() {
		return nomePosto;
	}

	public Point getPosicaoPosto() {
		return posicaoPosto;
	}

	public void setPedidoPendente(boolean pedidoPendente) {
		this.pedidoPendente = pedidoPendente;
	}

	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	// Metodos da Classe Posto

	/** transferência de combústivel para o posto
	 * @param nLitros litros a transferir
	 * @return ACEITE, o pedido foi adicionado ao camião<br>
	 *         POSTO_NAO_PRECISA, se o posto não necessita de ser abastecido
	 */
	public int enche( int nLitros ){
		// TODO ZFEITO fazer este método

		if(temPedidoPendente()) {

			// 
			if(podeEncher(nLitros) == Central.ACEITE){
				setQuantidadeAtual(quantidadeAtual+nLitros);
			}

			return podeEncher(nLitros);
		}
		return Central.POSTO_NAO_PRECISA;
	}

	/** Verifica se podemos colocar combustivel num posto
	 * @param nLitros litros a transferir
	 * @return ACEITE, o pedido é válido para o posto<br>
	 *         EXCEDE_CAPACIDADE_POSTO, se o posto não tem capacidade de armazenar os litros indicados
	 */

	public int podeEncher (int nLitros){
		
		if((getQuantidadeAtual() + nLitros) < getCapacidadeTotal()){

			return Central.ACEITE;
		}
		else return  Central.EXCEDE_CAPACIDADE_POSTO;
	}

	/** retorna a capacidade livre, isto é, quantos
	 * litros ainda podem ser armazenados no posto
	 * @return a capacidade livre
	 */
	public int capacidadeLivre() {
		// TODO ZFEITO fazer este método
		return this.capacidadeTotal - this.quantidadeAtual;
	}

	/** retorna a percentagem de ocupação do posto, entre 0 (0%) e 1 (100%)
	 * @return a percentagem de ocupação do posto
	 */
	public float percentagemOcupacao() {
		// TODO ZFEITO fazer este método
		return (float) this.quantidadeAtual/this.capacidadeTotal;
	}

	/** indica se o posto tem um pedido pendente
	 * @return true, se tiver um pedido
	 */
	public boolean temPedidoPendente() {
		// TODO ZFEITO fazer este método
		return pedidoPendente;
	}

	/** Laborar do posto. O posto processa os gastos e verifica
	 * se precisa de realizar um pedido de abastecimento
	 */
	public void laborar() {

		// TODO ZFEITO fazer este método

		// Calcula os gastos dos postos
		setQuantidadeAtual(quantidadeAtual-getGastoMedio());

		// Compara a percentagem de combustivel do posto com a quantidade
		// minima para se meter ccombustivel
		if(percentagemOcupacao() < OCUPACAO_SUFICIENTE){

			// Verifica se o posto tem ocupação para fazer um pedido
			if(percentagemOcupacao() < OCUPACAO_MINIMA ){ 
				pedidoPendente = true;
			}

			// Faz o calculo para os pedidos aleatorios dos postos
			double aleatorio = Math.random(); 
			if(aleatorio < PROBABILIDADE_NOVO_PEDIDO){
				pedidoPendente = true;
			}
		}
	}

	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	// Metodo Equals
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Posto posto)) return false;
		return getId() == posto.getId();
	}

	// Hash Code
	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
}
