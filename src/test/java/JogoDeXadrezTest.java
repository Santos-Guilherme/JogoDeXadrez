import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class JogoDeXadrezTest {

    @Test
    public void jogoDeXadrezImplementaInterfaceJogo() {
        JogoDeXadrez jogo = new JogoDeXadrez();
        assertTrue(jogo instanceof Jogo);
    }

    @Test
    public void jogadorHumanoHerdaJogador() {
        JogadorHumano jogador = new JogadorHumano('b');
        assertTrue(jogador instanceof Jogador);
    }

    @Test
    public void jogadorSinteticoHerdaJogador() {
        JogadorSintetico jogador = new JogadorSintetico('p');
        assertTrue(jogador instanceof Jogador);
    }

    @Test
    public void tabuleiroEhCriado() {
        Tabuleiro tabuleiro = new Tabuleiro();
        assertNotNull(tabuleiro);
    }

    @Test
    public void casaLivreRetornaCorretoParaCasaVaziaEPreeenchida() {
        Tabuleiro tabuleiro = new Tabuleiro();
        assertTrue(tabuleiro.casaLivre("A3"));
        assertTrue(!tabuleiro.casaLivre("A2"));
    }

    @Test
    public void jogadorAceitaCorBranca() {
        JogadorHumano jogador = new JogadorHumano('b');
        assertEquals('b', jogador.getCor());
    }

    @Test
    public void jogadorAceitaCorPreta() {
        JogadorSintetico jogador = new JogadorSintetico('p');
        assertEquals('p', jogador.getCor());
    }

    @Test
    public void iniciarNaoDeveLancarExcecao() {
        JogoDeXadrez jogo = new JogoDeXadrez();
        assertDoesNotThrow(() -> jogo.iniciar());
    }
}