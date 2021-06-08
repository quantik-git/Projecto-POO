import java.util.Date;
import java.util.Map;

public class Avancado extends Futebolista {
    private int drible;

    public Avancado(String nome, Date data_de_nascimento, int velocidade, int resistencia, int destreza, int impulsao, int cabeceamento, int remate, int passe, int drible) {
        super(nome, data_de_nascimento, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe);
        this.drible = drible;
    }

    public Avancado(Avancado a) {
        super(a.getNome(), a.getData_de_nascimento(), a.getVelocidade(), a.getResistencia(), a.getDestreza(), a.getImpulsao(), a.getCabeceamento(), a.getRemate(), a.getPasse(), a.getHistorial());
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
        Date data = new Date();
        
        return new Avancado(campos[0], data,
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
