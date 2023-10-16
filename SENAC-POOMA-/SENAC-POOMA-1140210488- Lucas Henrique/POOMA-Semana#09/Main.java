import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Criar instâncias de Times
        Time time1 = new Time("Time A", "Cidade A");
        Time time2 = new Time("Time B", "Cidade B");

        // Contratar jogadores para os times
        Jogador jogador1 = new Jogador("Jogador 1", 10, "Atacante", new Date());
        time1.contratarJogador(jogador1);

        Jogador jogador2 = new Jogador("Jogador 2", 7, "Meio-campista", new Date());
        time2.contratarJogador(jogador2);

        // Criar instância de CampeonatoPaulista
        CampeonatoPaulista campeonato = new CampeonatoPaulista("Campeonato Paulista", 2023);

        // Adicionar times ao campeonato
        campeonato.adicionarTime(time1);
        campeonato.adicionarTime(time2);

        // Agendar partidas
        Partida partida1 = new Partida(new Date(), time1, time2);
        campeonato.agendarPartida(partida1);

        // Gerar tabela de classificação (lógica a ser implementada)

        // Exibir informações
        System.out.println("Campeonato: " + campeonato.getNome() + " " + campeonato.getAno());
        System.out.println("Times participantes:");
        for (Time time : campeonato.getTimes()) {
            System.out.println("- " + time.getNome() + " (" + time.getCidade() + ")");
            System.out.println("Jogadores:");
            for (Jogador jogador : time.listarJogadores()) {
                System.out.println("-- " + jogador.getNome() + " (" + jogador.getPosicao() + ")");
            }
        }
        System.out.println("Partidas agendadas:");
        for (Partida partida : campeonato.getPartidas()) {
            System.out.println("- " + partida.getData() + ": " + partida.getTimeCasa().getNome() + " vs. "
                    + partida.getTimeVisitante().getNome());
        }
    }
}
