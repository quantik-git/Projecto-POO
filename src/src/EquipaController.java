import Models.Equipa;
import Models.Futebolista;

import java.util.ArrayList;
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

    public Equipa create(String nome) {
        return new Equipa(nome);
    }
    
    public static void definirTitulares(String nome) {
        Equipa equipa = mundo.getEquipa(nome);

        for (int i = 0; i < Equipa.NUM_TITULARES; i++) {
            String[] options = equipa.getPlantel().keySet().stream()
                    .filter(n -> !equipa.getTitulares().contains(n) && !equipa.getSuplentes().contains(n))
                    .toArray(String[]::new);
            int escolha = Menu.gerar(options);

            // TODO podem escolher sair no menu e estourar isto
            equipa.addTitular(options[escolha - 1]);
        }
    }

    public static void definirSuplentes(String nome) {
        Equipa equipa = mundo.getEquipa(nome);

        for (int i = 0; i < Equipa.MIN_SUPLENTES; i++) {
            String[] options = equipa.getPlantel().keySet().stream()
                    .filter(n -> !equipa.getTitulares().contains(n) && !equipa.getSuplentes().contains(n))
                    .toArray(String[]::new);
            int escolha = Menu.gerar(options);

            // TODO podem escolher sair no menu e estourar isto
            equipa.addSuplente(options[escolha - 1]);
        }
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
        String[] options = {
                "Vender Jogador",
                "Comprar Jogador",
                "Trocar Titular",
                "Trocar Suplente"
        };

        int opt = Menu.gerar(options);

        switch (opt) {
            case 1:
                venderJogador();
                break;
            case 2:
                contratarJogador();
                break;
            case 3:
                trocarTitular();
                break;
            case 4:
                trocarSuplente();
                break;
        }
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

        //livres.forEach(FutebolistaController::show);

        int escolha = Menu.gerar(livres.stream().map(Futebolista::getNome).toArray(String[]::new));

        if (escolha == 0) return;

        mundo.getEquipa(mundo.getEquipaEscolhida()).addPlantel(livres.get(escolha - 1));
    }

    public void transferir(String vendedor, String comprador, String nome) {
        Equipa ant = mundo.getEquipa(vendedor);
        Equipa prox = mundo.getEquipa(comprador);


    }
}
