package Models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 * Habilidade
 */

public abstract class Futebolista {
    private String nome;
    private Integer numero;
    private int velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe;
    private List<String> historial;

    public Futebolista(String nome, Integer numero, int velocidade, int resistencia, int destreza, int impulsao, int cabeceamento, int remate, int passe, List<String> historial) {
        this.nome = nome;
        this.numero = numero;
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.impulsao = impulsao;
        this.cabeceamento = cabeceamento;
        this.remate = remate;
        this.passe = passe;
        this.historial = historial;
    }

    public Futebolista(String nome, Integer numero, int velocidade, int resistencia, int destreza, int impulsao, int cabeceamento, int remate, int passe) {
        this.nome = nome;
        this.numero = numero;
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.impulsao = impulsao;
        this.cabeceamento = cabeceamento;
        this.remate = remate;
        this.passe = passe;
        this.historial = new ArrayList<>();
    }

    public Futebolista(Futebolista f) {
        this.nome = f.getNome();
        this.numero = f.getNumero();
        this.velocidade = f.getVelocidade();
        this.resistencia = f.getResistencia();
        this.destreza = f.getDestreza();
        this.impulsao = f.getImpulsao();
        this.cabeceamento = f.getCabeceamento();
        this.remate = f.getRemate();
        this.passe = f.getPasse();
        this.historial = f.getHistorial();
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
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

    public List<String> getHistorial() {
        return historial;
    }

    public void setHistorial(List<String> historial) {
        this.historial = historial;
    }

    public void addHistorial(String equipa) {
        this.historial.add(equipa);
    }

    public abstract Futebolista clone();

    public abstract int getOverall();


    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Nome: ").append(this.nome + "\n");
        sb.append("Numero: ").append(this.numero + "\n");
        sb.append("Velocidade: ").append(this.velocidade + "\n");
        sb.append("Resistencia: ").append(this.resistencia + "\n");
        sb.append("Destreza: ").append(this.destreza + "\n");
        sb.append("Impulsao: ").append(this.impulsao + "\n");
        sb.append("Cabeceamento: ").append(this.cabeceamento + "\n");
        sb.append("Remate: ").append(this.remate + "\n");
        sb.append("Passe: ").append(this.passe + "\n");
        sb.append("Historial: ").append(this.historial + "\n");

        return sb.toString();
    }
}
