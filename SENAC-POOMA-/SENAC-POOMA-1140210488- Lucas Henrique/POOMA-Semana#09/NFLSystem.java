import java.util.ArrayList;
import java.util.List;

public class CampeonatoPaulista {
    private String nome;
    private int ano;
    private List<Time> times;
    private List<Partida> partidas;
    private List<TabelaClassificacao> tabelaClassificacao;

    public CampeonatoPaulista(String nome, int ano) {
        this.nome = nome;
        this.ano = ano;
        this.times = new ArrayList<>();
        this.partidas = new ArrayList<>();
        this.tabelaClassificacao = new ArrayList<>();
    }

    public void adicionarTime(Time time) {
        times.add(time);
    }

    public void agendarPartida(Partida partida) {
        partidas.add(partida);
    }

    public void gerarTabelaClassificacao() {
        // Implemente a lógica para gerar a tabela de classificação aqui
        // Você precisará iterar pelas partidas e atualizar os pontos, vitórias,
        // empates, etc., na tabelaClassificacao.
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public int getAno() {
        return ano;
    }

    public List<Time> getTimes() {
        return times;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public List<TabelaClassificacao> getTabelaClassificacao() {
        return tabelaClassificacao;
    }
}
