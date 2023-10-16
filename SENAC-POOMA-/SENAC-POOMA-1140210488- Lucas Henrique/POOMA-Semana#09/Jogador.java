import java.util.Date;

public class Jogador {
    private String nome;
    private int numero;
    private String posicao;
    private Date dataNascimento;

    public Jogador(String nome, int numero, String posicao, Date dataNascimento) {
        this.nome = nome;
        this.numero = numero;
        this.posicao = posicao;
        this.dataNascimento = dataNascimento;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getPosicao() {
        return posicao;
    }
}
