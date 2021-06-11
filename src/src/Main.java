public class Main {

    public static void main(String[] args) {
        String[] options = {
                "Novo Campeonato",
                "Carregar Campeonato"
        };

        while (true) {
            int leitura = Menu.gerar(options);

            switch (leitura) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    Controller.novoJogo();
                    break;
                case 2:
                    //load game
                    break;
            }
        }
    }
}
