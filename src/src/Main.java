import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Parser.parse();
        } catch (LinhaIncorretaException e) {
            e.printStackTrace();
        }

        int leitura = 1;
        Mundo mundo = Mundo.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (leitura != 0) {
            System.out.println("o que deseja fazer:");
            leitura = scanner.nextInt();

            switch (leitura) {
                case 0:
                    System.out.println("A terminar o programa");
                    break;
                case 1:
                    //jogar
                    SomethingController.novoJogo();

                    break;
                case 2:
                    //load game
                    break;
                case 3:
                    //save game
                    break;
                default:
                    System.out.println("Comando não reconhecido");
            }
        }
    }
}
