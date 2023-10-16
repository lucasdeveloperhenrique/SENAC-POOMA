import java.util.ArrayList;
import java.util.List;

public class Time {
    private String nome;
    private String cidade;
    private List<Jogador> jogadores;

    public Time(String nome, String cidade) {
        this.nome = nome;
        this.cidade = cidade;
        this.jogadores = new ArrayList<>();
    }

    public void contratarJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    public List<Jogador> listarJogadores() {
        return jogadores;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }
}
