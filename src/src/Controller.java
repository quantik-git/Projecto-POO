import Models.Equipa;

import java.io.IOException;

public class Controller {

    public static void novoJogo() {
        Mundo mundo = Mundo.getInstance();
        String[] equipas;
        int equipaEscolhida;

        // inicializar os dados predefinidos do jogo
        try {
            Parser.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // escolher a equipa com que quer jogar
        equipas = mundo.getEquipas().keySet().toArray(String[]::new);
        equipaEscolhida = Menu.gerar(equipas) - 1;

        if (equipaEscolhida == -1) {
            return;
        }

        mundo.setEquipaEscolhida(equipas[equipaEscolhida]);

        // escolher os jogadores que quer como titulares / suplentes
        EquipaController.definirTitulares(mundo.getEquipaEscolhida());
        EquipaController.definirSuplentes(mundo.getEquipaEscolhida());

        EquipaController.show(mundo.getEquipaEscolhida());

        jogar();
    }

    // assume que o jogo já foi inicializado
    public static void jogar() {
        int opt;
        String[] options = {
                "Simular jogo",
                "Classificações",
                "Alterar Equipa",
                "Guardar Progresso",
                "Criar Jogador"
        };

        do {
            opt = Menu.gerar(options);

            switch (opt) {
                case 1:
                    // Simular o jogo
                    break;
                case 2:
                    // Classificações
                    break;
                case 3:
                    // Alterar Equipa
                    EquipaController.updateEquipa();
                    break;
                case 4:
                    // Guardar Progresso
                    break;
                case 5:
                    // Criar Jogador
                    FutebolistaController.create();
                    break;
            }
        } while (opt != 0);
    }

    public void menu() {
        System.out.println("O que pretende fazer?\n" +
                "1) Criar jogador" +
                "2) Criar Equipa" +
                "3) Associar jogador a uma equipa" +
                "4) Consultar os jogadores" +
                "5) Consultar as equipas" +
                "6) Mostrar um jogador" +
                "7) Mostrar uma equipa" +
                "8) Mudar um jogador de equipa");

    }

}
