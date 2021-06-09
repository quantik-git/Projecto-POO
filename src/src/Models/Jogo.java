package Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jogo {
    //private int idJogo;
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
