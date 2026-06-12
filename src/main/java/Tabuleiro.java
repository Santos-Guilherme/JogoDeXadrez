public class Tabuleiro {

    private String[][] casas = new String[8][8];

    private int contadorJogadas = 0;

    public Tabuleiro() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                casas[i][j] = "   ";
            }
        }

        colocarPecas();

        mostrar();
    }

    public void colocarPecas() {

        Rei reiBranco = new Rei('b');
        Rei reiPreto = new Rei('p');

        Rainha rainhaBranca = new Rainha('b');
        Rainha rainhaPreta = new Rainha('p');

        Torre torre1Branca = new Torre(1, 'b');
        Torre torre2Branca = new Torre(2, 'b');

        Torre torre1Preta = new Torre(1, 'p');
        Torre torre2Preta = new Torre(2, 'p');

        Bispo bispo1Branco = new Bispo(1, 'b');
        Bispo bispo2Branco = new Bispo(2, 'b');

        Bispo bispo1Preto = new Bispo(1, 'p');
        Bispo bispo2Preto = new Bispo(2, 'p');

        Cavalo cavalo1Branco = new Cavalo(1, 'b');
        Cavalo cavalo2Branco = new Cavalo(2, 'b');

        Cavalo cavalo1Preto = new Cavalo(1, 'p');
        Cavalo cavalo2Preto = new Cavalo(2, 'p');

        for (int i = 1; i <= 8; i++) {
            new Peao(i, 'b');
            new Peao(i, 'p');
        }

        casas[0][4] = reiBranco.getNome();
        casas[7][4] = reiPreto.getNome();
    }

    public void mostrar() {

        System.out.println("TABULEIRO");

        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {
                System.out.print("|" + casas[i][j]);
            }

            System.out.println("|");
        }
    }

    public boolean acabouOJogo() {

        contadorJogadas++;

        return contadorJogadas >= 10;
    }
}