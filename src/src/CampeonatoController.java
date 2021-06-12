import Models.Equipa;
import Models.Futebolista;
import Models.Mundo;
import Views.Form;
import Views.Menu;

import java.util.ArrayList;
import java.util.List;

public class CampeonatoController {
    private static Mundo mundo = Mundo.getInstance();

    public static void novoCampeonato() {
        ArrayList<String> equipas = new ArrayList<>(mundo.getEquipas().keySet());
        equipas.add("Nova Equipa");
        int equipaEscolhida = Menu.gerar(equipas.toArray(String[]::new));

        if (equipaEscolhida == 0) {
            return;
        } else if (equipaEscolhida == equipas.size()) {
            String nome = Form.inputLine("Insira o nome da nova equipa: ");
            Equipa nova = EquipaController.create(nome);

            // create plantel
            for (int i = 0; i < 20; i++) {
                Futebolista futebolista = FutebolistaController.create();
                if (futebolista == null) return;
                nova.addPlantel(futebolista);
            }

            mundo.addEquipa(nova);
            equipas.set(equipaEscolhida - 1, nome);
        }

        mundo.setEquipaEscolhida(equipas.get(equipaEscolhida - 1));

        // escolher os jogadores que quer como titulares / suplentes
        if (!EquipaController.definirTitulares(mundo.getEquipaEscolhida())) return;
        if (!EquipaController.definirSuplentes(mundo.getEquipaEscolhida())) return;

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
