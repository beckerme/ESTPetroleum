package petroleum;

import java.awt.Point;
import java.util.*;
import menu.Mapa.*;
import petroleum.Posto.*;
import static menu.Mapa.distancia;

/** Um itinerário é um conjunto de paragens.<br>
 * O itinerário assume que o ponto de início é sempre o mesmo e,
 * no final, deve retornar sempre ao local de início.
 */
public class Itinerario {

	private ArrayList<Paragem> paragens = new ArrayList<Paragem>();

	private Point inicio;

	public Itinerario(){
		this.inicio = new Point(505, 750);
	}

	public List<Paragem> getParagens() {
		return Collections.unmodifiableList(paragens);
	}

	public void addParagens(Paragem p) {
		paragens.add(p);
	}
	
	public void remomveParagens(Paragem p) {
		paragens.remove(p);
	}

	/*public Central getCentral() {
		return central;
	}*/

	/** retorna o ponto de inicio do itenerário
	 * @return o ponto de inicio do itenerário
	 */
	public Point getInicio() {
		// TODO ZFEITO fazer este método (não usar este valor assim)
		return inicio;
	}

	/** limpa o itinerário, isto é, remove todas
	 * as paragens do mesmo
	 */
	public void limpar() {
		// TODO ZFEITTO fazer este método
		paragens.clear();
	}
}
