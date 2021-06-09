import java.util.Date;
import java.util.Map;
import java.util.List;
public class Lateral extends Futebolista{
    private int cruzamento;

    public Lateral(String nome, int velocidade, int resistencia, int destreza, int impulsao, int cabeceamento, int remate, int passe, List<String> historial, int cruzamento) {
        super(nome, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe, historial);
        this.cruzamento = cruzamento;
    }

    public Lateral(String nome, int velocidade, int resistencia, int destreza, int impulsao, int cabeceamento, int remate, int passe, int cruzamento) {
        super(nome, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe);
        this.cruzamento = cruzamento;
    }

    public Lateral(Lateral l) {
        super(l.getNome(), l.getVelocidade(), l.getResistencia(), l.getDestreza(), l.getImpulsao(), l.getCabeceamento(), l.getRemate(), l.getPasse(), l.getHistorial());
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

    public String toString() {
        StringBuilder sb= new StringBuilder();

        sb.append("Cruzamento: ").append(this.cruzamento + "\n");

        return super.toString() + sb.toString();
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
                Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]));
    }
}
