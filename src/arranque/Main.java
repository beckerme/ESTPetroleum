package arranque;
import java.awt.Point;

import menu.Mapa;
import menu.JanelaControlo;
import petroleum.*;

/** Responsável por cria o ambiente de execução e criar a janela */
public class Main {

	public static void main(String[] args) {
		// TODO criar a central requerida
		Central c = new Central();
		
		// TODO criar os postos
		//public Posto(int id, int gastoMedio, int quantidadeAtual, int capacidadeTotal, String nomePosto, Point posicaoPosto) {
		Posto posto1 = new Posto(1, 2200, 10000, 40000, "Minas Tirith", new Point(1400, 990));
		Posto posto2 = new Posto(2, 3200, 7000, 30000, "Isengard ", new Point(925, 710));
		Posto posto3 = new Posto(3,2300,17000, 30000,"Dol Guldur", new Point(1235,510 ));
		Posto posto4 = new Posto(4, 800,15000, 20000, "Rivendell", new Point(890,310 ));
		Posto posto5 = new Posto(5, 1300, 25000, 30000, "Hobbiton", new Point(455,335));
		Posto posto6 = new Posto(6, 1300, 20000, 25000, "Edoras", new Point(1035,800 ));
		Posto posto7 = new Posto(7, 2300, 5000, 35000, "Barad-dur", new Point(1690,915));
		Posto posto8 = new Posto(8, 1800, 6000, 25000, "Amon Sul", new Point(735,310 ));
		Posto posto9 = new Posto(9, 1750, 4000, 30000, "Erebor", new Point(1500,180 ));
		Posto posto10 = new Posto(10, 2100, 7000, 35000, "Moria", new Point(860,500 ));
		Posto posto11 = new Posto(11, 1200, 2000, 25000, "Cirith Ungol", new Point(1540,980));
		Posto posto12 = new Posto(12, 1600, 18000, 25000, "Emyn Muil", new Point(1380,700));
		Posto posto13 = new Posto(13, 1900, 5000, 30000, "Linhir", new Point(1110,1180));
		Posto posto14 = new Posto(14, 1600, 5000, 30000, "Dom Beornd", new Point(1090,240));
		Posto posto15 = new Posto(15, 2000, 8000, 30000, "Harlond", new Point(175,400 ));
		/*Posto posto16 = new Posto();
		Posto posto17 = new Posto();
		Posto posto18 = new Posto();
		Posto posto19 = new Posto();
		Posto posto20 = new Posto();*/

		c.adicionarPosto(posto1);
		c.adicionarPosto(posto2);
		c.adicionarPosto(posto3);
		c.adicionarPosto(posto4);
		c.adicionarPosto(posto5);
		c.adicionarPosto(posto6);
		c.adicionarPosto(posto7);
		c.adicionarPosto(posto8);
		c.adicionarPosto(posto9);
		c.adicionarPosto(posto10);
		c.adicionarPosto(posto11);
		c.adicionarPosto(posto12);
		c.adicionarPosto(posto13);
		c.adicionarPosto(posto14);
		c.adicionarPosto(posto15);
		/*c.adicionarPosto(posto3);
		c.adicionarPosto(posto3);
		c.adicionarPosto(posto3);
		c.adicionarPosto(posto3);
		c.adicionarPosto(posto3);*/

		// TODO criar os camiões

		Camiao camiao1 = new Camiao("11-FG-33", 20000, 65, 20, new Itinerario(c.getPosicaoCentral()));
		Camiao camiao2 = new Camiao("22-DV-22", 30000, 50, 30, new Itinerario(c.getPosicaoCentral()));
		Camiao camiao3 = new Camiao("AA-34-BB", 35000, 70, 30, new Itinerario(c.getPosicaoCentral()));
		Camiao camiao4 = new Camiao("CF-65-FC", 40000, 45, 40, new Itinerario(c.getPosicaoCentral()));
		Camiao camiaoNosso = new Camiao("MM-30-TS", 20000, 100, 50, new Itinerario(c.getPosicaoCentral()));

		c.adicionarCamiao(camiao1);
		c.adicionarCamiao(camiao2);
		c.adicionarCamiao(camiao3);
		c.adicionarCamiao(camiao4);
		c.adicionarCamiao(camiaoNosso);

		// criar a apresentar a janela principal
		JanelaControlo postosFrame = new JanelaControlo( c );
		postosFrame.setVisible( true );
	}

}
