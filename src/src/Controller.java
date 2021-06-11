import Models.Equipa;
import Models.Futebolista;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller {

    public static void novoJogo() {
        Mundo mundo = Mundo.getInstance();
        ArrayList<String> equipas;
        int equipaEscolhida;

        // inicializar os dados predefinidos do jogo
        try {
            Parser.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // escolher a equipa com que quer jogar
        equipas = new ArrayList<>(mundo.getEquipas().keySet());
        equipas.add("Nova Equipa");

        equipaEscolhida = Menu.gerar(equipas.toArray(String[]::new)) - 1;

        if (equipaEscolhida == -1) return;

        if (equipaEscolhida == equipas.size() - 1) {
            // criar nova equipa
            String nome = Form.inputLine("Insira o nome da nova equipa: ");

            for (int i = 0; i < 20; i++) {
                // create plantel
                FutebolistaController.create();
            }

            Equipa nova = EquipaController.create(nome);
            nova.setPlantel(
                    mundo.getFutebolistasLivres().stream().collect(
                            Collectors.toMap(Futebolista::getNome, fut -> fut)
                    )
            );

            mundo.setEquipaEscolhida(nome);
        } else {
            mundo.setEquipaEscolhida(equipas.get(equipaEscolhida));
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
        Map<Integer, Runnable> commands = new HashMap<>();
        String[] options = {
                "Simular jogo",
                "Classificações",
                "Alterar Equipa",
                "Guardar Progresso",
                "Criar Jogador",
                "Consultar Jogador",
                "Consultar Equipas"
        };

        commands.put(0, () -> {});
        commands.put(1, () -> {});
        commands.put(2, () -> {});
        commands.put(3, EquipaController::updateEquipa);
        commands.put(4, () -> {});
        commands.put(5, FutebolistaController::create);
        commands.put(6, FutebolistaController::consultarJogador);
        commands.put(7, EquipaController::consultarEquipa);

        do {
            opt = Menu.gerar(options);

            commands.get(opt).run();
        } while (opt != 0);
    }
}
