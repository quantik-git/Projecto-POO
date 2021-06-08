import java.util.Date;
import java.util.Map;

public class Lateral extends Futebolista{
    private int cruzamento;

    public Lateral(int idAtleta, String nome, Date data_de_nascimento, int velocidade, int resistencia, int destreza, int impulsao, int cabeceamento, int remate, int passe, Map<Integer, Equipa> historial, int cruzamento) {
        super(idAtleta, nome, data_de_nascimento, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe, historial);
        this.cruzamento = cruzamento;
    }

    public Lateral(Lateral l) {
        super(l.getIdAtleta(), l.getNome(), l.getData_de_nascimento(), l.getVelocidade(), l.getResistencia(), l.getDestreza(), l.getImpulsao(), l.getCabeceamento(), l.getRemate(), l.getPasse(), l.getHistorial());
        this.cruzamento = l.getCruzamento();
    }

    public int getCruzamento() {
        return cruzamento;
    }

    public void setCruzamento(int cruzamento) {
        this.cruzamento = cruzamento;
    }

    @Override
    public Futebolista clone() {
        return new Lateral(this);
    }

    @Override
    public int getOverall() {
        return 0;
    }

    public static Lateral parse(String input){
        String[] campos = input.split(",");
        return new Lateral(campos[0],
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]));
    }
}
