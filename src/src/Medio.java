import java.util.Date;
import java.util.Map;

public class Medio extends Futebolista {

    private int percecao_de_jogo;

    public Medio(int idAtleta, String nome, Date data_de_nascimento, int velocidade, int resistencia, int destreza, int impulsao, int cabeceamento, int remate, int passe, Map<Integer, Equipa> historial, int percecao_de_jogo) {
        super(idAtleta, nome, data_de_nascimento, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe, historial);
        this.percecao_de_jogo = percecao_de_jogo;
    }

    public Medio(Medio m) {
        super(m.getIdAtleta(), m.getNome(), m.getData_de_nascimento(), m.getVelocidade(), m.getResistencia(), m.getDestreza(), m.getImpulsao(), m.getCabeceamento(), m.getRemate(), m.getPasse(), m.getHistorial());
        this.percecao_de_jogo = m.getPercecao_de_jogo();
    }

    public int getPercecao_de_jogo() {
        return percecao_de_jogo;
    }

    public void setPercecao_de_jogo(int percecao_de_jogo) {
        this.percecao_de_jogo = percecao_de_jogo;
    }

    public Medio clone() {
        return new Medio(this);
    }

    public int getOverall() {
        return this.percecao_de_jogo;
    }
}
