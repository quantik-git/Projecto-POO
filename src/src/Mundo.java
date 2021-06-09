import Models.Equipa;
import Models.Futebolista;
import Models.Jogo;

import java.util.*;

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

    public void setEquipas(Map<String, Equipa> equipas) {
        this.equipas = equipas;
    }

    public List<Futebolista> getFutebolistas() {
        return futebolistas;
    }

    public void setFutebolistas(List<Futebolista> futebolistas) {
        this.futebolistas = futebolistas;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }

    public String getEquipaEscolhida() {
        return equipaEscolhida;
    }

    public void setEquipaEscolhida(String equipaEscolhida) {
        this.equipaEscolhida = equipaEscolhida;
    }

    public static Mundo getInstance(){
        return instance;
    }
}