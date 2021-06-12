package Models;

import java.util.*;
import java.util.stream.Collectors;

public class Mundo {
    private static Mundo instance = new Mundo();

    private Map<String, Equipa> equipas;
    private List<Futebolista> futebolistas;
    private List<Jogo> jogos;
    private String equipaEscolhida;

    private Mundo() {
        this.equipas = new HashMap<>();
        this.futebolistas = new ArrayList<>();
        this.jogos = new ArrayList<>();
        this.equipaEscolhida = "";
    }

    public Map<String, Equipa> getEquipas() {
        return equipas;
    }

    public Equipa getEquipa(String nome) {
        return this.equipas.get(nome);
    }

    public void setEquipas(Map<String, Equipa> equipas) {
        this.equipas = equipas;
    }

    public void addEquipa(Equipa nova) {
        this.equipas.put(nova.getNome(), nova);
    }

    public List<Futebolista> getFutebolistas() {
        return futebolistas;
    }

    public Futebolista getFutebolista(String nome) {
        for (Futebolista futebolista : futebolistas) {
            if (futebolista.getNome().equals(nome)) {
                return futebolista;
            }
        }
        return null;
    }

    public void setFutebolistas(List<Futebolista> futebolistas) {
        this.futebolistas = futebolistas;
    }

    public void addFutebolista(Futebolista futebolista) {
        this.futebolistas.add(futebolista);
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }

    public void addJogo(Jogo jogo) {
        this.jogos.add(jogo);
    }

    public String getEquipaEscolhida() {
        return equipaEscolhida;
    }

    public void setEquipaEscolhida(String equipaEscolhida) {
        this.equipaEscolhida = equipaEscolhida;
    }

    public List<Futebolista> getFutebolistasLivres() {
        ArrayList<String> contratados = new ArrayList<>();
        this.equipas.values().forEach(
                equipa -> contratados.addAll(equipa.getPlantel().keySet())
        );

        return this.getFutebolistas().stream()
                .filter(j -> !contratados.contains(j.getNome()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static Mundo getInstance(){
        return instance;
    }


}