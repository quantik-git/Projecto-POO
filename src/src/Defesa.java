import java.util.Date;
import java.util.Map;

public class Defesa extends Futebolista {

    private int roubo_de_bola;

    public Defesa(int idAtleta, String nome, Date data_de_nascimento, int velocidade, int resistencia, int destreza, int impulsao, int cabeceamento, int remate, int passe, Map<Integer, Equipa> historial, int roubo_de_bola) {
        super(idAtleta, nome, data_de_nascimento, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe, historial);
        this.roubo_de_bola = roubo_de_bola;
    }

    public Defesa(Defesa d) {
        super(d.getIdAtleta(), d.getNome(), d. getData_de_nascimento(), d.getVelocidade(), d.getResistencia(), d.getDestreza(), d.getImpulsao(), d.getCabeceamento(), d.getRemate(), d.getPasse(), d.getHistorial());
        this.roubo_de_bola = d.getRoubo_de_bola();
    }

    public int getRoubo_de_bola() {
        return roubo_de_bola;
    }

    public void setRoubo_de_bola(int roubo_de_bola) {
        this.roubo_de_bola = roubo_de_bola;
    }

    public Defesa clone() {
        return new Defesa(this);
    }

    public int getOverall() {
        return this.roubo_de_bola;
    }
}
