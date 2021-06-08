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
        int overall = (int) (0.2*this.getDestreza() + 0.18*this.getImpulsao() + 0.16*this.getPasse() + 0.14*this.getRemate() + 0.12*this.getResistencia() + 0.10*this.getCabeceamento() + 0.10*this.getVelocidade());
        
        return (int) (overall*0.80 + this.getElasticidade()*0.20);
    }

    public static GuardaRedes parse(String input){
        String[] campos = input.split(",");
        return new GuardaRedes(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]));
    }
}
