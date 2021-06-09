import Models.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {

    public static void parse() throws LinhaIncorretaException {
        List<String> linhas = lerFicheiro("output.txt");
        Map<String, Equipa> equipas = new HashMap<>(); //nome, equipa
        List<Futebolista> futebolistas = new ArrayList<>(); //Models.Futebolista
        List<Jogo> jogos = new ArrayList<>();
        Equipa ultima = null;
        Futebolista f = null;
        String[] linhaPartida;
        String[] campos;

        for (String linha : linhas) {
            linhaPartida = linha.split(":", 2);
            campos = linhaPartida[1].split(",");

            switch(linhaPartida[0]) {
                case "Models.Equipa":
                    Equipa e = Equipa.parse(linhaPartida[1]);
                    equipas.put(e.getNome(), e);
                    ultima = e;
                    break;
                case "Guarda-Redes":
                    f = GuardaRedes.parse(linhaPartida[1]);
                    futebolistas.add(f);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addPlantel(Integer.parseInt(campos[1]), f.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Models.Defesa":
                    f = Defesa.parse(linhaPartida[1]);
                    futebolistas.add(f);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addPlantel(Integer.parseInt(campos[1]), f.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Models.Medio":
                    f = Medio.parse(linhaPartida[1]);
                    futebolistas.add(f);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addPlantel(Integer.parseInt(campos[1]), f.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Models.Lateral":
                    f = Lateral.parse(linhaPartida[1]);
                    futebolistas.add(f);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addPlantel(Integer.parseInt(campos[1]), f.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Models.Avancado":
                    f = Avancado.parse(linhaPartida[1]);
                    futebolistas.add(f);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addPlantel(Integer.parseInt(campos[1]), f.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Models.Jogo":
                    Jogo j = Jogo.parse(linhaPartida[1]);
                    jogos.add(j);
                    break;
                default:
                    throw new LinhaIncorretaException();
            }
        }

        // Debug
        for (Equipa e: equipas.values()){
            System.out.println(e.toString());
        }
        for (Jogo j: jogos){
            System.out.println(j.toString());
        }
    }

    public static List<String> lerFicheiro(String nomeFich) {
        List<String> lines;
        try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
        catch(IOException exc) { lines = new ArrayList<>(); }
        return lines;
    }
}
