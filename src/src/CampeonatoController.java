import Exceptions.LinhaIncorretaException;
import Models.Equipa;
import Models.Futebolista;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CampeonatoController {
    private static Mundo mundo = Mundo.getInstance();

    public static void novoCampeonato() {
        ArrayList<String> equipas;
        int equipaEscolhida;

        // escolher a equipa com que quer jogar
        equipas = new ArrayList<>(mundo.getEquipas().keySet());
        equipas.add("Nova Equipa");

        equipaEscolhida = Menu.gerar(equipas.toArray(String[]::new));

        if (equipaEscolhida == 0) {
            return;
        } else if (equipaEscolhida == equipas.size()) {
            // criar nova equipa
            String nome = Form.inputLine("Insira o nome da nova equipa: ");

            // create plantel
            for (int i = 0; i < 20; i++) {
                FutebolistaController.create();
            }

            Equipa nova = EquipaController.create(nome);
            nova.setPlantel(
                    mundo.getFutebolistasLivres().stream().collect(
                            Collectors.toMap(Futebolista::getNome, fut -> fut)
                    )
            );

            equipas.set(equipaEscolhida, nome);
        } else {
            mundo.setEquipaEscolhida(equipas.get(equipaEscolhida - 1));
        }

        // escolher os jogadores que quer como titulares / suplentes
        EquipaController.definirTitulares(mundo.getEquipaEscolhida());
        EquipaController.definirSuplentes(mundo.getEquipaEscolhida());

        EquipaController.show(mundo.getEquipaEscolhida());

        jogar();
    }

    // assume que o jogo já foi inicializado
    public static void jogar() {
        int opt;
        List<Runnable> commands = new ArrayList<>();
        String[] options = {
                "Simular jogo",
                "Consultar Jogos",
                "Alterar Equipa",
                "Consultar Equipas",
                "Criar Jogador",
                "Consultar Jogadores",
                "Guardar Progresso"
        };

        commands.add(0, () -> {});
        commands.add(1, JogoController::simularJogo);
        commands.add(2, JogoController::consultarJogo);
        commands.add(3, EquipaController::updateEquipa);
        commands.add(4, EquipaController::consultarEquipa);
        commands.add(5, FutebolistaController::create);
        commands.add(6, FutebolistaController::consultarJogador);
        commands.add(7, SaveLoadController::save);

        do {
            opt = Menu.gerar(options);
            commands.get(opt).run();
        } while (opt != 0);
    }
}
