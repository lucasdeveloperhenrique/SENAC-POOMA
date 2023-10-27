class Professor extends Funcionario {
    private double valorHoraAula;
    private int quantidadeAulas;

    public Professor(String nome, double valorHoraAula, int quantidadeAulas) {
        super(nome);
        this.valorHoraAula = valorHoraAula;
        this.quantidadeAulas = quantidadeAulas;
    }

    @Override
    public double calcularPagamento() {
        return valorHoraAula * quantidadeAulas;
    }
}
