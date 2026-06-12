public class JogadorSintetico extends Jogador {

    public JogadorSintetico(char cor) {
        super(cor);
    }

    @Override
    public boolean jogar(Tabuleiro tabuleiro,
                          String nomeDaPeca,
                          int numeroDaCasa) {

        System.out.println("Jogador sintético jogando...");
        return true;
    }
}