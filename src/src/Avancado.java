import java.util.Date;
import java.util.Map;

public class Avancado extends Futebolista {
    private int drible;

    public Avancado(String nome, int velocidade, int resistencia, int destreza, int impulsao, int cabeceamento, int remate, int passe, int drible) {
        super(nome, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe);
        this.drible = drible;
    }

    public Avancado(Avancado a) {
        super(a.getNome(), a.getVelocidade(), a.getResistencia(), a.getDestreza(), a.getImpulsao(), a.getCabeceamento(), a.getRemate(), a.getPasse(), a.getHistorial());
        this.drible = a.getDrible();
    }

    public int getDrible() {
        return drible;
    }

    public void setDrible(int drible) {
        this.drible = drible;
    }

    public Avancado clone() {
        return new Avancado(this);
    }

    public int getOverall() {
        return this.drible;
    }

    public static Avancado parse(String input){
        String[] campos = input.split(",");
        
        return new Avancado(campos[0],
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                100);
    }
}
