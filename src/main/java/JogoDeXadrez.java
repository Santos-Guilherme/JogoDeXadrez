import java.util.Locale;
import java.util.Scanner;

public class JogoDeXadrez implements Jogo {

    @Override
    public void iniciar() {
        Tabuleiro tabuleiro = new Tabuleiro();

        if (System.console() == null) {
            return;
        }

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            String nomeDaPeca = perguntarNomeDaPeca(scanner);
            String destino = perguntarCasaDestino(scanner);

            while (!tabuleiro.moverPeca(nomeDaPeca, destino)) {
                System.out.println("Não é possível mover a peça para a casa de destino. Tente novamente.");
                nomeDaPeca = perguntarNomeDaPeca(scanner);
                destino = perguntarCasaDestino(scanner);
            }

            tabuleiro.mostrar();
            continuar = perguntarContinuar(scanner);
        }

        scanner.close();
    }

    private String perguntarNomeDaPeca(Scanner scanner) {
        System.out.print("Qual peça deseja mover? (código de 3 caracteres): ");
        return scanner.nextLine().trim();
    }

    private String perguntarCasaDestino(Scanner scanner) {
        System.out.print("Para qual casa deseja mover? (ex: A2): ");
        return scanner.nextLine().trim().toUpperCase(Locale.ROOT);
    }

    private boolean perguntarContinuar(Scanner scanner) {
        System.out.print("Deseja continuar jogando? (SIM/NAO): ");
        String resposta = scanner.nextLine().trim().toUpperCase(Locale.ROOT);
        return resposta.startsWith("S");
    }

    public static void main(String[] args) {
        JogoDeXadrez jogo = new JogoDeXadrez();
        jogo.iniciar();
        System.out.println("Guilherme Henrique dos Santos");
    }
}