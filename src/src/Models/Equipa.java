package Models;

import java.util.*;
import java.util.stream.Collectors;

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

    private int getCompatibilidadeTatica(int[] tatica, Map<Class<? extends Futebolista>, Integer> contar){
        int lateralAux = contar.get(Lateral.class);
        int total = 0;

        tatica[0] -= contar.get(GuardaRedes.class);
        tatica[1] -= contar.get(Defesa.class);
        tatica[2] -= contar.get(Medio.class);
        tatica[3] -= contar.get(Avancado.class);

        if (tatica[0] < 0) total += tatica[0];
        if (tatica[1] < 0) total += tatica[1];

        if (tatica[2] < 0) total += tatica[2];
        else lateralAux -= tatica[2];

        tatica[3] -= lateralAux;
        if (tatica[3] < 0) total += tatica[3];

        return total;
    }

    public int getOverall(){
        int overall = 0;
        int maxTatica = Integer.MIN_VALUE;
        Map<Class<? extends Futebolista>, Integer> contar = new HashMap<>();
        int[][] taticas = {
                {1, 4, 4, 2},
                {1, 4, 3, 3}
        };

        contar.put(GuardaRedes.class, 0);
        contar.put(Defesa.class, 0);
        contar.put(Medio.class, 0);
        contar.put(Avancado.class, 0);
        contar.put(Lateral.class, 0);

        for (String titular : this.titulares) {
            Futebolista jogador = this.plantel.get(titular);
            contar.put(jogador.getClass(), contar.get(jogador.getClass()) + 1);
            overall += jogador.getOverall();
        }

        for (int[] tatica : taticas) {
            int compatibilidadeTatica = getCompatibilidadeTatica(tatica, contar);
            if (compatibilidadeTatica > maxTatica) maxTatica = compatibilidadeTatica;
        }

        overall /= NUM_TITULARES; // avg overall
        overall = (int) (overall * ((float) (11 + maxTatica) / (float) 11)); // fator tático

        return overall;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Nome: ").append(this.nome).append("\n");
        sb.append("Plantel: \n");
        for (Futebolista futebolista : plantel.values()) {
            sb.append(futebolista.toStringEsp()).append("\n");
        }
        sb.append("Titulares: ").append(this.titulares).append("\n");
        sb.append("Suplentes: ").append(this.suplentes).append("\n");
        sb.append("Overall: ").append(this.getOverall()).append("\n");

        return sb.toString();
    }

    public String write() {
        return "Equipa:" + this.nome + "\n";
    }
}
