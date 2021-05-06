import java.util.Date;
import java.util.Map;

public class GuardaRedes extends Futebolista {
    private int elasticidade;

    public GuardaRedes(int idAtleta, String nome, Date data_de_nascimento, int velocidade, int resistencia, int destreza, int impulsao, int cabeceamento, int remate, int passe, Map<Integer, Equipa> historial, int elasticidade) {
        super(idAtleta, nome, data_de_nascimento, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe, historial);
        this.elasticidade = elasticidade;
    }

    public GuardaRedes(GuardaRedes g) {
        super(g.getIdAtleta(), g.getNome(), g.getData_de_nascimento(), g.getVelocidade(), g.getResistencia(), g.getDestreza(), g.getImpulsao(), g.getCabeceamento(), g.getRemate(),g.getPasse(),g.getHistorial());
        this.elasticidade = g.getElasticidade();
    }

    public GuardaRedes clone() {
        return new GuardaRedes(this);
    }

    public int getElasticidade() {
        return elasticidade;
    }

    public void setElasticidade(int elasticidade) {
        this.elasticidade = elasticidade;
    }

    public int getOverall() {
        return this.elasticidade;
    }
}
