package Models;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Habilidade global em falta
 */
public class Equipa {
    public static final int NUM_TITULARES = 11;
    public static final int MAX_SUPLENTES = 12;
    public static final int MIN_SUPLENTES = 3;

    private String nome;
    private Map<String, Futebolista> plantel; // Nome, Jogador
    private List<String> titulares;
    private List<String> suplentes;

    public Equipa(String nome, Map<String, Futebolista> plantel, List<String> titulares, List<String> suplentes) {
        this.nome = nome;
        this.plantel = plantel;
        this.titulares = titulares;
        this.suplentes = suplentes;
    }

    public Equipa(String nome) {
        this.nome = nome;
        this.plantel = new HashMap<>();
        this.titulares = new ArrayList<>();
        this.suplentes = new ArrayList<>();
    }

    public Equipa(Equipa equipa) {
        this.nome = equipa.getNome();
        this.plantel = equipa.getPlantel();
        this.titulares = equipa.getTitulares();
        this.suplentes = equipa.getSuplentes();
    }

    public static Equipa parse(String s) {
        return new Equipa(s);
    }

    public Equipa clone() {
        return new Equipa(this);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<String, Futebolista> getPlantel() {
        return plantel;
    }

    public void setPlantel(Map<String, Futebolista> plantel) {
        plantel.values().forEach(this::addPlantel);
    }

    public void addPlantel(Futebolista futebolista) {
        Futebolista novo = futebolista.clone();
        novo.addHistorial(this.nome);
        novo.setNumero(
                this.plantel.values().stream()
                        .map(Futebolista::getNumero)
                        .max(Comparator.naturalOrder())
                        .orElse(0) + 1
        );
        this.plantel.put(futebolista.getNome(), novo);
    }

    public void removePlantel(String nome) {
        this.plantel.get(nome).setNumero(null);
        this.plantel.remove(nome);

        this.setTitulares(
                this.getTitulares().stream().filter(fut -> !fut.equals(nome)).collect(Collectors.toList())
        );

        this.setSuplentes(
                this.getSuplentes().stream().filter(fut -> !fut.equals(nome)).collect(Collectors.toList())
        );
    }

    public List<String> getTitulares() {
        return titulares;
    }

    public void setTitulares(List<String> titulares) {
        titulares.forEach(this::addTitular);
    }

    //Decidir se vamos Throw Exception para sinalizar se foi possível adicionar o jogador TODO
    public void addTitular(String nome) {
        if (this.titulares.size() < NUM_TITULARES) {
            this.titulares.add(nome);
        }
    }

    public void replaceTitular(String antigo, String novo) {
        if (this.titulares.contains(antigo)) {
            this.titulares.remove(antigo);
            this.titulares.add(novo);
        }
    }

    public List<String> getSuplentes() {
        return suplentes;
    }

    public void setSuplentes(List<String> suplentes) {
        suplentes.forEach(this::addSuplente);
    }

    public void addSuplente(String suplente) {
        if (this.suplentes.size() < MAX_SUPLENTES) {
            this.suplentes.add(suplente);
        }
    }

    public void replaceSuplente(String antigo, String novo) {
        if (this.suplentes.contains(antigo)) {
            this.suplentes.remove(antigo);
            this.suplentes.add(novo);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Nome: ").append(this.nome + "\n");
        sb.append("Plantel: \n");
        for (Futebolista futebolista : plantel.values()) {
            sb.append(futebolista.toStringEsp()).append("\n");
        }
        sb.append("Titulares: ").append(this.titulares + "\n");
        sb.append("Suplentes: ").append(this.suplentes + "\n");

        return sb.toString();
    }
}
