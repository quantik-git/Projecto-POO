package Models;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Jogo {
    private String casa;
    private String visitante;
    private int golosCasa;
    private int golosVisitante;
    private LocalDate date;
    private List<Integer> jogadoresCasa;
    private List<Integer> jogadoresVisitante;
    private Map<Integer, Integer> substituicoesCasa;
    private Map<Integer, Integer> substitucoesVisitante;


    public Jogo(String casa, String visitante, int golosCasa, int golosVisitante, LocalDate date, List<Integer> jogadoresCasa, List<Integer> jogadoresVisitante, Map<Integer, Integer> substituicoesCasa, Map<Integer, Integer> substitucoesVisitante) {
        this.casa = casa;
        this.visitante = visitante;
        this.golosCasa = golosCasa;
        this.golosVisitante = golosVisitante;
        this.date = date;
        this.jogadoresCasa = jogadoresCasa;
        this.jogadoresVisitante = jogadoresVisitante;
        this.substituicoesCasa = substituicoesCasa;
        this.substitucoesVisitante = substitucoesVisitante;
    }

    public Jogo(String casa, String visitante) {
        this.casa = casa;
        this.visitante = visitante;
        this.golosCasa = 0;
        this.golosVisitante = 0;
        this.date = LocalDate.now();
        this.jogadoresCasa = new ArrayList<>();
        this.jogadoresVisitante = new ArrayList<>();
        this.substituicoesCasa = new HashMap<>();
        this.substitucoesVisitante = new HashMap<>();
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public int getGolosCasa() {
        return golosCasa;
    }

    public void setGolosCasa(int golosCasa) {
        this.golosCasa = golosCasa;
    }

    public void addGolosCasa() {
        this.golosCasa++;
    }

    public int getGolosVisitante() {
        return golosVisitante;
    }

    public void setGolosVisitante(int golosVisitante) {
        this.golosVisitante = golosVisitante;
    }

    public void addGolosVisitante() {
        this.golosVisitante++;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Integer> getJogadoresCasa() {
        return jogadoresCasa;
    }

    public void setJogadoresCasa(List<Integer> jogadoresCasa) {
        this.jogadoresCasa = jogadoresCasa;
    }

    public List<Integer> getJogadoresVisitante() {
        return jogadoresVisitante;
    }

    public void setJogadoresVisitante(List<Integer> jogadoresVisitante) {
        this.jogadoresVisitante = jogadoresVisitante;
    }

    public Map<Integer, Integer> getSubstituicoesCasa() {
        return substituicoesCasa;
    }

    public void setSubstituicoesCasa(Map<Integer, Integer> substituicoesCasa) {
        this.substituicoesCasa = substituicoesCasa;
    }

    public Map<Integer, Integer> getSubstitucoesVisitante() {
        return substitucoesVisitante;
    }

    public void setSubstitucoesVisitante(Map<Integer, Integer> substitucoesVisitante) {
        this.substitucoesVisitante = substitucoesVisitante;
    }

    public String toString() {
        return "Jogo{" +
                "casa='" + casa + '\'' +
                ", visitante='" + visitante + '\'' +
                ", golosCasa=" + golosCasa +
                ", golosVisitante=" + golosVisitante +
                ", date=" + date +
                ", jogadoresCasa=" + jogadoresCasa +
                ", jogadoresVisitante=" + jogadoresVisitante +
                ", substituicoesCasa=" + substituicoesCasa +
                ", substitucoesVisitante=" + substitucoesVisitante +
                '}';
    }

    public String write() {
        StringBuilder sb = new StringBuilder();

        sb.append("Jogo:")
                .append(this.casa).append(",")
                .append(this.visitante).append(",")
                .append(this.golosCasa).append(",")
                .append(this.golosVisitante).append(",")
                .append(this.date).append(",")
                .append(this.jogadoresCasa.stream()
                        .map(Object::toString).collect(Collectors.joining(","))).append(",")
                .append(this.substituicoesCasa.entrySet().stream()
                        .map(n -> n.getKey() + "->" + n.getValue()).collect(Collectors.joining(","))).append(",")
                .append(this.jogadoresVisitante.stream()
                        .map(Object::toString).collect(Collectors.joining(","))).append(",")
                .append(this.substitucoesVisitante.entrySet().stream()
                        .map(n -> n.getKey() + "->" + n.getValue()).collect(Collectors.joining(","))).append("\n");

        return sb.toString();
    }

    public static Jogo parse(String input) {
        String[] campos = input.split(",");
        String[] data = campos[4].split("-");
        List<Integer> jc = new ArrayList<>();
        List<Integer> jf = new ArrayList<>();
        Map<Integer, Integer> subsC = new HashMap<>();
        Map<Integer, Integer> subsF = new HashMap<>();

        for (int i = 5; i < 16; i++){
            jc.add(Integer.parseInt(campos[i]));
        }
        for (int i = 16; i < 19; i++){
            String[] sub = campos[i].split("->");
            subsC.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        for (int i = 19; i < 30; i++){
            jf.add(Integer.parseInt(campos[i]));
        }
        for (int i = 30; i < 33; i++){
            String[] sub = campos[i].split("->");
            subsF.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        return new Jogo(campos[0], campos[1], Integer.parseInt(campos[2]), Integer.parseInt(campos[3]),
                LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])),
                jc, jf, subsC, subsF);
    }
}
