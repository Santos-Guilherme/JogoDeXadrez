import java.util.Locale;

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
        casas[7][0] = new Torre(1, 'b').getNome();
        casas[7][1] = new Cavalo(1, 'b').getNome();
        casas[7][2] = new Bispo(1, 'b').getNome();
        casas[7][3] = new Rainha('b').getNome();
        casas[7][4] = new Rei('b').getNome();
        casas[7][5] = new Bispo(2, 'b').getNome();
        casas[7][6] = new Cavalo(2, 'b').getNome();
        casas[7][7] = new Torre(2, 'b').getNome();

        for (int i = 0; i < 8; i++) {
            casas[6][i] = new Peao(i + 1, 'b').getNome();
        }

        casas[0][0] = new Torre(1, 'p').getNome();
        casas[0][1] = new Cavalo(1, 'p').getNome();
        casas[0][2] = new Bispo(1, 'p').getNome();
        casas[0][3] = new Rainha('p').getNome();
        casas[0][4] = new Rei('p').getNome();
        casas[0][5] = new Bispo(2, 'p').getNome();
        casas[0][6] = new Cavalo(2, 'p').getNome();
        casas[0][7] = new Torre(2, 'p').getNome();

        for (int i = 0; i < 8; i++) {
            casas[1][i] = new Peao(i + 1, 'p').getNome();
        }
    }

    public void mostrar() {
        System.out.println("TABULEIRO");
        System.out.println("   A  B  C  D  E  F  G  H");

        for (int i = 0; i < 8; i++) {
            System.out.print(8 - i);
            for (int j = 0; j < 8; j++) {
                System.out.print("|" + casas[i][j]);
            }
            System.out.println("|");
        }
    }

    public Boolean casaLivre(String casa) {
        int[] posicao = converterCasa(casa);
        return casas[posicao[0]][posicao[1]].equals("   ");
    }

    public boolean moverPeca(String nomeDaPeca, String casaDestino) {
        if (nomeDaPeca == null || casaDestino == null) {
            return false;
        }

        nomeDaPeca = nomeDaPeca.trim();
        casaDestino = casaDestino.trim().toUpperCase(Locale.ROOT);

        if (!posicaoValida(casaDestino)) {
            return false;
        }

        int[] posicaoOrigem = buscarPeca(nomeDaPeca);
        if (posicaoOrigem == null) {
            return false;
        }

        if (!casaLivre(casaDestino)) {
            return false;
        }

        int[] posicaoDestino = converterCasa(casaDestino);
        casas[posicaoDestino[0]][posicaoDestino[1]] = casas[posicaoOrigem[0]][posicaoOrigem[1]];
        casas[posicaoOrigem[0]][posicaoOrigem[1]] = "   ";

        return true;
    }

    private int[] buscarPeca(String nomeDaPeca) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (casas[i][j].equalsIgnoreCase(nomeDaPeca)) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private boolean posicaoValida(String casa) {
        if (casa.length() != 2) {
            return false;
        }

        char coluna = Character.toUpperCase(casa.charAt(0));
        char linha = casa.charAt(1);

        return coluna >= 'A' && coluna <= 'H' && linha >= '1' && linha <= '8';
    }

    private int[] converterCasa(String casa) {
        String codigo = casa.trim().toUpperCase(Locale.ROOT);
        int coluna = codigo.charAt(0) - 'A';
        int linha = 8 - Character.getNumericValue(codigo.charAt(1));
        return new int[]{linha, coluna};
    }

    public boolean acabouOJogo() {
        contadorJogadas++;
        return contadorJogadas >= 10;
    }
}