public abstract class Jogador implements JogadorInterface {

    protected char cor;

    public Jogador(char cor) {

        if (cor != 'b' && cor != 'p') {
            throw new IllegalArgumentException(
                    "A cor deve ser 'b' ou 'p'.");
        }

        this.cor = cor;
    }

    public char getCor() {
        return cor;
    }
}