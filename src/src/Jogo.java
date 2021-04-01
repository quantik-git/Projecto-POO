package com.company;

public class Jogo {
    int idJogo;
    Equipa casa;
    Equipa visitante;

    public Jogo(Equipa casa, Equipa visitante) {
        this.casa = casa;
        this.visitante = visitante;
    }
}
