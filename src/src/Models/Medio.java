package Models;

import java.util.Date;
import java.util.Map;

public class Medio extends Futebolista {
    private int recuperacao;

    public Medio(String nome, Date data_de_nascimento, int velocidade, int resistencia, int destreza, int impulsao, int cabeceamento, int remate, int passe, Map<Integer, Equipa> historial, int recuperacao) {
        super(nome, data_de_nascimento, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe, historial);
        this.recuperacao = recuperacao;
    }

    public Medio(String nome, Date data_de_nascimento, int velocidade, int resistencia, int destreza, int impulsao, int cabeceamento, int remate, int passe, int recuperacao) {
        super(nome, data_de_nascimento, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe);
        this.recuperacao = recuperacao;
    }

    public Medio(Medio m) {
        super(m.getNome(), m.getData_de_nascimento(), m.getVelocidade(), m.getResistencia(), m.getDestreza(), m.getImpulsao(), m.getCabeceamento(), m.getRemate(), m.getPasse(), m.getHistorial());
        this.recuperacao = m.getRecuperacao();
    }

    public int getRecuperacao() {
        return recuperacao;
    }

    public void setRecuperacao(int recuperacao) {
        this.recuperacao = recuperacao;
    }

    public Medio clone() {
        return new Medio(this);
    }

    public int getOverall() {
        return this.recuperacao;
    }

    public static Medio parse(String input){
        String[] campos = input.split(",");
        Date data = new Date();

        return new Medio(campos[0], data,
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
