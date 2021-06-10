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

    public static void parse() throws IOException {
        Mundo mundo = Mundo.getInstance();
        boolean debug = false;
        String ficheiro = "./src/configs/inicializacao.txt";

        List<String> linhas = lerFicheiro(ficheiro);
        Map<String, Equipa> equipas = new HashMap<>(); //nome, equipa
        List<Futebolista> futebolistas = new ArrayList<>(); //Futebolista
        List<Jogo> jogos = new ArrayList<>();

        Equipa ultima = null;
        Futebolista f = null;
        String[] linhaPartida;

        for (String linha : linhas) {
            linhaPartida = linha.split(":", 2);

            switch (linhaPartida[0]) {
                case "Equipa":
                    Equipa e = Equipa.parse(linhaPartida[1]);
                    equipas.put(e.getNome(), e);
                    ultima = e;
                    break;
                case "Guarda-Redes":
                    f = GuardaRedes.parse(linhaPartida[1]);
                    futebolistas.add(f);
                    if (ultima == null) throw new IOException(); //we need to insert the player into the team
                    ultima.addPlantel(f.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Defesa":
                    f = Defesa.parse(linhaPartida[1]);
                    futebolistas.add(f);
                    if (ultima == null) throw new IOException(); //we need to insert the player into the team
                    ultima.addPlantel(f.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Medio":
                    f = Medio.parse(linhaPartida[1]);
                    futebolistas.add(f);
                    if (ultima == null) throw new IOException(); //we need to insert the player into the team
                    ultima.addPlantel(f.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Lateral":
                    f = Lateral.parse(linhaPartida[1]);
                    futebolistas.add(f);
                    if (ultima == null) throw new IOException(); //we need to insert the player into the team
                    ultima.addPlantel(f.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Avancado":
                    f = Avancado.parse(linhaPartida[1]);
                    futebolistas.add(f);
                    if (ultima == null) throw new IOException(); //we need to insert the player into the team
                    ultima.addPlantel(f.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Jogo":
                    Jogo j = Jogo.parse(linhaPartida[1]);
                    jogos.add(j);
                    break;
                default:
                    throw new IOException();
            }
        }

        mundo.setFutebolistas(futebolistas);
        mundo.setEquipas(equipas);

        if (debug) {
            for (Equipa e: equipas.values()){
                System.out.println(e.toString());
            }
            for (Futebolista futebolista : futebolistas) {
                System.out.println(futebolista.toString());
            }
            for (Jogo j: jogos){
                System.out.println(j.toString());
            }
        }
    }

    public static List<String> lerFicheiro(String nomeFich) {
        List<String> lines;
        try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
        catch(IOException exc) { lines = new ArrayList<>(); }
        return lines;
    }
}
