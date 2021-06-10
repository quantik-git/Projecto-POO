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

    public static void updateEquipa() {
        String[] options = {
                "Vender Jogador",
                "Comprar Jogador",
                "Trocar Titular",
                "Trocar Suplentes"
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
                break;
            case 4:
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
