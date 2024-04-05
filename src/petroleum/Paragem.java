package petroleum;

/** Uma paragem do itinerário deve indicar
 * o posto onde se deve parar e quantos litros
 * devem ser transferidos para o posto  
 */
public class Paragem {
    private  Posto posto;
    private int nLitros;

    public Paragem(Posto posto, int nLitros) {
        this.posto = posto;
        this.nLitros = nLitros;
    }

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
        this.nLitros = nLitros;
    }
}
