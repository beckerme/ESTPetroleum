package petroleum;

import java.awt.*;
import java.util.*;

/** Um posto do sistema. Um posto deve ter uma capacidade
 * máxima de combustível, assim como a quantidade de combustível que tem.
 * Para simular o uso do posto assume-se que ele tem num gasto médio diário,
 * o que significa que todos os dias, o posto vende esse combústivel.
 */
public class Posto {
	/** Indica a capacidade (em percentagem) a partir da qual o posto não aceita
	 * novos pedidos abastecimento */
	public static final double OCUPACAO_SUFICIENTE = 0.75;

	/** Indica a capacidade (em percentagem) abaixo da qual o
	 * posto precisa de fazer um pedido */
	public static final double OCUPACAO_MINIMA = 0.25;

	/**Probabilidade de um posto fazer um pedido
	* */
	public static final double PROBABILIDADE_NOVO_PEDIDO = 0.10;


	private int id, gastoMedio, quantidadeAtual, capacidadeTotal;
	private String nomePosto;
	private Point posicaoPosto;

	public Posto(int id, int gastoMedio, int quantidadeAtual, int capacidadeTotal, String nomePosto, Point posicaoPosto) {
		this.id = id;
		this.gastoMedio = gastoMedio;
		this.quantidadeAtual = quantidadeAtual;
		this.capacidadeTotal = capacidadeTotal;
		this.nomePosto = nomePosto;
		this.posicaoPosto = posicaoPosto;
	}

	/**Getters e Setters da classe
	 * */
	public int getId() {
		return id;
	}

	public int getGastoMedio() {
		return gastoMedio;
	}

	public void setGastoMedio(int gastoMedio) {
		this.gastoMedio = gastoMedio;
	}

	public int getQuantidadeAtual() {
		return quantidadeAtual;
	}

	public void setQuantidadeAtual(int quantidadeAtual) {
		this.quantidadeAtual = quantidadeAtual;
	}

	public int getCapacidadeTotal() {
		return capacidadeTotal;
	}

	public void setCapacidadeTotal(int capacidadeTotal) {
		this.capacidadeTotal = capacidadeTotal;
	}

	public String getNomePosto() {
		return nomePosto;
	}

	public void setNomePosto(String nomePosto) {
		this.nomePosto = nomePosto;
	}

	public Point getPosicaoPosto() {
		return posicaoPosto;
	}

	public void setPosicaoPosto(Point posicaoPosto) {
		this.posicaoPosto = posicaoPosto;
	}

	/** transferência de combústivel para o posto
	 * @param nLitros litros a transferir
	 * @return ACEITE, o pedido foi adicionado ao camião<br>
	 *         POSTO_NAO_PRECISA, se o posto não necessita de ser abastecido
	 *         EXCEDE_CAPACIDADE_POSTO, se o posto não tem capacidade de armazenar os litros indicados
	 */
	public int enche( int nLitros ){
		// TODO ZFEITO fazer este método
		if(temPedidoPendente()) {
            return Central.ACEITE;
        }
	 return Central.POSTO_NAO_PRECISA;
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
        return percentagemOcupacao() < OCUPACAO_MINIMA || Math.random() < PROBABILIDADE_NOVO_PEDIDO;
    }

	/** Laborar do posto. O posto processa os gastos e verifica
	 * se precisa de realizar um pedido de abastecimento
	 */
	public void laborar() {
		// TODO ZFEITO fazer este método
		setQuantidadeAtual(quantidadeAtual-getGastoMedio());

		if(!temPedidoPendente())
			laborar();
	}
}
