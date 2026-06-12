
public class JogoDeXadrez implements Jogo {

    @Override
    public void iniciar() {

        Tabuleiro tabuleiro = new Tabuleiro();

        Jogador jogadorHumano =
                new JogadorHumano('b');

        Jogador jogadorSintetico =
                new JogadorSintetico('p');

        while (!tabuleiro.acabouOJogo()) {

            jogadorHumano.jogar(
                    tabuleiro,
                    "P1b",
                    1
            );

            jogadorSintetico.jogar(
                    tabuleiro,
                    "P1p",
                    1
            );
        }
    }

    public static void main(String[] args) {

        JogoDeXadrez jogo =
                new JogoDeXadrez();

        jogo.iniciar();

        System.out.println("Guilherme Henrique dos Santos");
    }
}