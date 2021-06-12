import Models.Equipa;
import Models.Futebolista;
import Models.Mundo;
import Views.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EquipaController {
    private static Mundo mundo = Mundo.getInstance();

    public static int index() {
        return Menu.gerar(mundo.getEquipas().keySet().toArray(String[]::new));
    }

    public static void show(String nome) {
        Equipa escolhido = mundo.getEquipa(nome);

        System.out.println(escolhido.toString());
    }

    public static Equipa create(String nome) {
        return new Equipa(nome);
    }
    
    public static boolean definirTitulares(String nome) {
        Equipa equipa = mundo.getEquipa(nome);

        for (int i = 0; i < Equipa.NUM_TITULARES; i++) {
            ArrayList<Futebolista> futebolistas = (ArrayList<Futebolista>) equipa.getPlantel().entrySet().stream()
                    .filter(n -> !equipa.getTitulares().contains(n.getKey()) && !equipa.getSuplentes().contains(n.getKey()))
                    .map(Map.Entry::getValue)
                    .collect(Collectors.toList());

            String[] options = futebolistas.stream()
                    .map(Futebolista::toStringEsp)
                    .toArray(String[]::new);

            int escolha = Menu.gerar(options);

            if (escolha == 0) return false;

            equipa.addTitular(futebolistas.get(escolha - 1).getNome());
        }
        return true;
    }

    public static boolean definirSuplentes(String nome) {
        Equipa equipa = mundo.getEquipa(nome);

        for (int i = 0; i < Equipa.MIN_SUPLENTES; i++) {
            ArrayList<Futebolista> futebolistas = (ArrayList<Futebolista>) equipa.getPlantel().entrySet().stream()
                    .filter(n -> !equipa.getTitulares().contains(n.getKey()) && !equipa.getSuplentes().contains(n.getKey()))
                    .map(Map.Entry::getValue)
                    .collect(Collectors.toList());

            String[] options = futebolistas.stream()
                    .map(Futebolista::toStringEsp)
                    .toArray(String[]::new);

            int escolha = Menu.gerar(options);

            if (escolha == 0) return false;

            equipa.addSuplente(futebolistas.get(escolha - 1).getNome());
        }
        return true;
    }

    private static void trocarSuplente() {
        Equipa equipa = mundo.getEquipa(mundo.getEquipaEscolhida());
        String[] livres = equipa.getPlantel().keySet().stream()
                .filter(jog -> !equipa.getSuplentes().contains(jog) && !equipa.getTitulares().contains(jog))
                .toArray(String[]::new);
        String[] suplentes = equipa.getSuplentes().toArray(String[]::new);

        int livre = Menu.gerar(livres);
        int suplente = Menu.gerar(suplentes);

        equipa.replaceSuplente(suplentes[suplente - 1], livres[livre - 1]);
    }

    private static void trocarTitular() {
        Equipa equipa = mundo.getEquipa(mundo.getEquipaEscolhida());
        String[] livres = equipa.getPlantel().keySet().stream()
                .filter(jog -> !equipa.getSuplentes().contains(jog) && !equipa.getTitulares().contains(jog))
                .toArray(String[]::new);
        String[] titulares = equipa.getTitulares().toArray(String[]::new);

        int livre = Menu.gerar(livres);
        int titular = Menu.gerar(titulares);

        equipa.replaceTitular(titulares[titular - 1], livres[livre - 1]);
    }

    public static void updateEquipa() {
        List<Runnable> commands = new ArrayList<>();
        String[] options = {
                "Vender Jogador",
                "Comprar Jogador",
                "Trocar Titular",
                "Trocar Suplente"
        };

        int opt = Menu.gerar(options);

        commands.add(0, () -> {});
        commands.add(1, EquipaController::venderJogador);
        commands.add(2, EquipaController::contratarJogador);
        commands.add(3, EquipaController::trocarTitular);
        commands.add(4, EquipaController::trocarSuplente);

        commands.get(opt).run();
    }

    public static void venderJogador() {
        Equipa equipa = mundo.getEquipa(mundo.getEquipaEscolhida());
        if (equipa.getPlantel().size() == Equipa.MIN_SUPLENTES + Equipa.NUM_TITULARES) {
            return;
        }
        String[] plantel = equipa.getPlantel().keySet().toArray(new String[0]);

        int escolha = Menu.gerar(plantel);

        if (escolha == 0) return;

        // TODO verificar se esqueceu de fazer -1 nos outras ocasiões
        equipa.removePlantel(plantel[escolha - 1]);
    }

    public static void contratarJogador() {
        ArrayList<String> contratados = new ArrayList<>();
        for (Equipa equipa : mundo.getEquipas().values()) {
            contratados.addAll(equipa.getPlantel().keySet());
        }

        ArrayList<Futebolista> livres = mundo.getFutebolistas().stream()
                .filter(j -> !contratados.contains(j.getNome()))
                .collect(Collectors.toCollection(ArrayList::new));

        int escolha = Menu.gerar(livres.stream().map(Futebolista::getNome).toArray(String[]::new));

        if (escolha == 0) return;

        mundo.getEquipa(mundo.getEquipaEscolhida()).addPlantel(livres.get(escolha - 1));
    }

    public static void consultarEquipa() {
        String[] equipas = mundo.getEquipas().keySet().toArray(String[]::new);
        int escolha = Menu.gerar(equipas);

        show(equipas[escolha - 1]);
    }
}
