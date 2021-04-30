import java.util.Map;

/**
 * Habilidade
 */
public abstract class Futebolista extends Atleta{
    private int velocidade;
    private int resistencia;
    private int destreza;
    private int impulsao;
    private int cabeceamento;
    private int remate;
    private int passe;
    private Map<Integer, Equipa> historial; // lista de id's de equipas, Possibilidade de mover para o atleta para uma maior abstração

    public Futebolista(int velocidade, int resistencia, int destreza, int impulsao, int cabeceamento, int remate, int passe, Map<Integer, Equipa> historial) {
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.impulsao = impulsao;
        this.cabeceamento = cabeceamento;
        this.remate = remate;
        this.passe = passe;
        this.historial = historial;
    }

    public Futebolista(Futebolista f) {
        this.velocidade = f.getVelocidade();
        this.resistencia = f.getResistencia();
        this.destreza = f.getDestreza();
        this.impulsao = f.getImpulsao();
        this.cabeceamento = f.getCabeceamento();
        this.remate = f.getRemate();
        this.passe = f.getPasse();
        this.historial = f.getHistorial();
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getImpulsao() {
        return impulsao;
    }

    public void setImpulsao(int impulsao) {
        this.impulsao = impulsao;
    }

    public int getCabeceamento() {
        return cabeceamento;
    }

    public void setCabeceamento(int cabeceamento) {
        this.cabeceamento = cabeceamento;
    }

    public int getRemate() {
        return remate;
    }

    public void setRemate(int remate) {
        this.remate = remate;
    }

    public int getPasse() {
        return passe;
    }

    public void setPasse(int passe) {
        this.passe = passe;
    }

    public Map<Integer, Equipa> getHistorial() {
        return historial;
    }

    public void setHistorial(Map<Integer, Equipa> historial) {
        this.historial = historial;
    }

    public abstract Futebolista clone();

    public abstract int getOverall();
}
