import java.util.ArrayList;
import java.util.List;

public class Controller {

    public static void init() {
        List<Runnable> commands = new ArrayList<>();
        String[] options = {
                "Novo Campeonato",
                "Carregar Campeonato"
        };

        commands.add(0, () -> System.exit(0));
        commands.add(1, SaveLoadController::loadDefault);
        commands.add(2, SaveLoadController::load);

        while (true) {
            commands.get(
                    Menu.gerar(options)
            ).run();
        }
    }
}
