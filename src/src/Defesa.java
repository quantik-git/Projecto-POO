import java.util.Date;
import java.util.Map;
import java.util.List;

public class Defesa extends Futebolista {
    private int roubo_de_bola;

    public Defesa(String nome, int velocidade, int resistencia, int destreza, int impulsao, int cabeceamento, int remate, int passe, List<String> historial, int roubo_de_bola) {
        super(nome, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe, historial);
        this.roubo_de_bola = roubo_de_bola;
    }

    public Defesa(String nome, int velocidade, int resistencia, int destreza, int impulsao, int cabeceamento, int remate, int passe, int roubo_de_bola) {
        super(nome, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe);
        this.roubo_de_bola = roubo_de_bola;
    }

    public Defesa(Defesa d) {
        super(d.getNome(), d.getVelocidade(), d.getResistencia(), d.getDestreza(), d.getImpulsao(), d.getCabeceamento(), d.getRemate(), d.getPasse(), d.getHistorial());
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

    public String toString() {
        StringBuilder sb= new StringBuilder();

        sb.append("Roubo de bola: ").append(this.roubo_de_bola + "\n");

        return super.toString() + sb.toString();
    }

    public static Defesa parse(String input){
        String[] campos = input.split(",");

        return new Defesa(campos[0],
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                80);
    }
}
