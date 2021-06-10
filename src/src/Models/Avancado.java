package Models;

import java.util.List;

public class Avancado extends Futebolista {
    private int drible;

    public Avancado(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int cabeceamento, int remate, int passe, List<String> historial, int drible) {
        super(nome, numero, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe, historial);
        this.drible = drible;
    }

    public Avancado(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int cabeceamento, int remate, int passe, int drible) {
        super(nome, numero, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe);
        this.drible = drible;
    }

    public Avancado(Avancado a) {
        super(a.getNome(), a.getNumero(), a.getVelocidade(), a.getResistencia(), a.getDestreza(), a.getImpulsao(), a.getCabeceamento(), a.getRemate(), a.getPasse(), a.getHistorial());
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
        int overall = (int) (0.2*this.getRemate() + 0.18*this.getCabeceamento() + 0.16*this.getVelocidade() + 0.14*this.getResistencia() + 0.12*this.getImpulsao() + 0.10*this.getDestreza() + 0.10*this.getPasse());

        return (int) (overall*0.80 + this.getDrible()*0.20);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Posicao: Avancado\n");
        sb.append("Drible: ").append(this.drible + "\n");
        sb.append("Overall: ").append(this.getOverall() + "\n");

        return super.toString() + sb.toString();
    }

    public String toStringEsp() {
        StringBuilder sb = new StringBuilder();

        sb.append("Avancado\t");
        sb.append(this.getOverall());

        return super.toStringEsp() + sb.toString();
    }

    public static Avancado parse(String input) {
        String[] campos = input.split(",");

        return new Avancado(campos[0], Integer.parseInt(campos[1]),
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
