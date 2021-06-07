import java.util.Date;
import java.util.Map;

public class Avancado extends Futebolista {
    private int drible;

    public Avancado(int idAtleta, String nome, Date data_de_nascimento, int velocidade, int resistencia, int destreza, int impulsao, int cabeceamento, int remate, int passe, Map<Integer, Equipa> historial, int drible) {
        super(idAtleta, nome, data_de_nascimento, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe, historial);
        this.drible = drible;
    }

    public Avancado(Avancado a) {
        super(a.getIdAtleta(), a.getNome(), a.getData_de_nascimento(), a.getVelocidade(), a.getResistencia(), a.getDestreza(), a.getImpulsao(), a.getCabeceamento(), a.getRemate(), a.getPasse(), a.getHistorial());
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
}