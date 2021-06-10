public class Main {

    public static void main(String[] args) {
        String[] options = {
                "Novo Campeonato",
                "Carregar Campeonato",
                "Criar Campeonato"
        };

        while (true) {
            int leitura = Menu.gerar(options);

            switch (leitura) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    //jogar
                    Controller.novoJogo();

                    break;
                case 2:
                    //load game
                    break;
                case 3:

                    break;
                default:
                    System.out.println("Comando não reconhecido");
            }
        }
    }
}
