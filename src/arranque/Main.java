package arranque;
import java.awt.Point;

import estruturas.*;
import menu.JanelaControlo;
import percursos.*;
import transportes.*;

/** Responsável por cria o ambiente de execução e criar a janela */
public class Main {

	public static void main(String[] args) {
		// TODO ZFEITO criar a central requerida
		
		Central c = new Central();

		// TODO ZFEITO criar os postos
		c.adicionarPosto(new Posto(1, 2200, 10000, 40000, "Minas Tirith", new Point(1400, 990)));
		c.adicionarPosto(new Posto(2, 3200, 7000, 30000, "Isengard ", new Point(925, 710)));
		c.adicionarPosto(new Posto(3,2300,17000, 30000,"Dol Guldur", new Point(1235,510 )));
		c.adicionarPosto(new Posto(4, 800,15000, 20000, "Rivendell", new Point(890,310 )));
		c.adicionarPosto(new Posto(5, 1300, 25000, 30000, "Hobbiton", new Point(455,335)));
		c.adicionarPosto(new Posto(6, 1300, 20000, 25000, "Edoras", new Point(1035,800 )));
		c.adicionarPosto(new Posto(7, 2300, 5000, 35000, "Barad-dur", new Point(1690,915)));
		c.adicionarPosto(new Posto(8, 1800, 6000, 25000, "Amon Sul", new Point(735,310 )));
		c.adicionarPosto(new Posto(9, 1750, 4000, 30000, "Erebor", new Point(1500,180 )));
		c.adicionarPosto(new Posto(10, 2100, 7000, 35000, "Moria", new Point(860,500 )));
		c.adicionarPosto(new Posto(11, 1200, 2000, 25000, "Cirith Ungol", new Point(1540,980)));
		c.adicionarPosto(new Posto(12, 1600, 18000, 25000, "Emyn Muil", new Point(1380,700)));
		c.adicionarPosto(new Posto(13, 1900, 5000, 30000, "Linhir", new Point(1110,1180)));
		c.adicionarPosto(new Posto(14, 1600, 5000, 30000, "Dom Beornd", new Point(1090,240)));
		c.adicionarPosto(new Posto(15, 2000, 8000, 30000, "Harlond", new Point(175,400 )));
		c.adicionarPosto(new Posto(16, 2700, 8500, 35000, "Shibuya", new Point (1162,850)));
		c.adicionarPosto(new Posto(17, 1300, 22500, 27500, "Shinjuku", new Point (1062,410)));
		c.adicionarPosto(new Posto(18, 1300, 10000, 50000, "Tokyo", new Point (745,567)));
		c.adicionarPosto(new Posto(19, 2050, 5500, 30000, "Osaka", new Point (1212,612)));
		c.adicionarPosto(new Posto(20, 1925, 5500, 32500, "Shinagawa", new Point (1180,340)));

		// TODO ZFEITO criar os camiões
		c.adicionarCamiao(new Camiao("11-FG-33", 20000, 65, 20, new Itinerario(c.getPosicaoCentral())));
		c.adicionarCamiao(new Camiao("22-DV-22", 30000, 50, 30, new Itinerario(c.getPosicaoCentral())));
		c.adicionarCamiao(new Camiao("AA-34-BB", 35000, 70, 30, new Itinerario(c.getPosicaoCentral())));
		c.adicionarCamiao(new Camiao("CF-65-FC", 40000, 45, 40, new Itinerario(c.getPosicaoCentral())));
		c.adicionarCamiao(new Camiao("MM-30-TS", 50000, 100, 50, new Itinerario(c.getPosicaoCentral())));

		// criar e apresentar a janela principal
		JanelaControlo postosFrame = new JanelaControlo(c);
		postosFrame.setVisible( true );
	}

}
