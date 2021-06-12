import Exceptions.LinhaIncorretaException;
import Models.*;
import Views.Form;
import Views.Menu;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaveLoadController {
    private static Mundo mundo = Mundo.getInstance();

    public static void loadDefault() {
        try {
            parse("./src/configs/inicializacao.txt");
        } catch (LinhaIncorretaException e) {
            e.printStackTrace(); // TODO dizer que o ficheiro está mal construído
        }

        CampeonatoController.novoCampeonato();
    }

    public static void load() {
        File f = new File("./src/saves/");
        String[] pathnames = f.list();

        if (pathnames == null) return;

        int opt = Menu.gerar(pathnames);
        if (opt == 0) return;

        try {
            parse("./src/saves/" + pathnames[opt - 1]);
        } catch (LinhaIncorretaException e) {
            e.printStackTrace(); // TODO dizer que o ficheiro está mal construído
        }

        CampeonatoController.novoCampeonato();
    }

    public static void save() {
        String filename = Form.inputLine("Nome do ficheiro: ");

        try {
            write("./src/saves/" + filename + ".txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(String ficheiro) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(ficheiro, false);
        StringBuilder str = new StringBuilder();

        for (Equipa equipa : mundo.getEquipas().values()) {
            str.append(equipa.write());
            for (Futebolista futebolista : equipa.getPlantel().values()) {
                str.append(futebolista.write());
            }
        }

        for (Jogo jogo : mundo.getJogos()) {
            str.append(jogo.write());
        }

        outputStream.write(str.toString().getBytes());
        outputStream.close();
    }

    public static void parse(String ficheiro) throws LinhaIncorretaException {
        boolean debug = false;
        Map<String, Equipa> equipas = new HashMap<>(); //nome, equipa
        List<Futebolista> futebolistas = new ArrayList<>(); //Futebolista
        List<Jogo> jogos = new ArrayList<>();
        List<String> linhas = lerFicheiro(ficheiro);

        Equipa ultima = null;
        Futebolista f = null;

        for (String linha : linhas) {
            String[] linhaPartida = linha.split(":", 2);

            switch (linhaPartida[0]) {
                case "Equipa":
                    Equipa e = Equipa.parse(linhaPartida[1]);
                    equipas.put(e.getNome(), e);
                    ultima = e;
                    break;
                case "Guarda-Redes":
                    f = GuardaRedes.parse(linhaPartida[1]);
                    futebolistas.add(f);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addPlantel(f.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Defesa":
                    f = Defesa.parse(linhaPartida[1]);
                    futebolistas.add(f);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addPlantel(f.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Medio":
                    f = Medio.parse(linhaPartida[1]);
                    futebolistas.add(f);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addPlantel(f.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Lateral":
                    f = Lateral.parse(linhaPartida[1]);
                    futebolistas.add(f);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addPlantel(f.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Avancado":
                    f = Avancado.parse(linhaPartida[1]);
                    futebolistas.add(f);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addPlantel(f.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Jogo":
                    Jogo j = Jogo.parse(linhaPartida[1]);
                    jogos.add(j);
                    break;
                default:
                    throw new LinhaIncorretaException();
            }
        }

        mundo.setFutebolistas(futebolistas);
        mundo.setEquipas(equipas);
        mundo.setJogos(jogos);

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
