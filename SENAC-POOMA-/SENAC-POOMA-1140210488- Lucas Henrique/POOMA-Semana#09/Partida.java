import java.util.Date;

public class Partida {
    private Date data;
    private Time timeCasa;
    private Time timeVisitante;
    private String resultado;

    public Partida(Date data, Time timeCasa, Time timeVisitante) {
        this.data = data;
        this.timeCasa = timeCasa;
        this.timeVisitante = timeVisitante;
    }

    public void definirResultado(String resultado) {
        this.resultado = resultado;
    }

    // Getters
    public Date getData() {
        return data;
    }

    public Time getTimeCasa() {
        return timeCasa;
    }

    public Time getTimeVisitante() {
        return timeVisitante;
    }
}
