import Models.Equipa;
import Models.Futebolista;
import Models.Jogo;

import java.util.*;

public class Mundo {
    private static Mundo instance = new Mundo();

    private Map<String, Equipa> equipas;
    private Map<String, Futebolista> futebolistas;
    private List<Jogo> jogos;

    private Mundo() {
        this.equipas = new HashMap<>();
        this.futebolistas = new HashMap<>();
        this.jogos = new ArrayList<>();
    }

    public Map<String, Equipa> getEquipas() {
        return equipas;
    }

    public void setEquipas(Map<String, Equipa> equipas) {
        this.equipas = equipas;
    }

    public Map<String, Futebolista> getFutebolistas() {
        return futebolistas;
    }

    public void setFutebolistas(Map<String, Futebolista> futebolistas) {
        this.futebolistas = futebolistas;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }

    public static Mundo getInstance(){
        return instance;
    }
}