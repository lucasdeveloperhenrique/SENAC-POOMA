class Horista extends Funcionario {
    private int quantidadeHorasTrabalhadas;
    private double valorHora;

    public Horista(String nome, int quantidadeHorasTrabalhadas, double valorHora) {
        super(nome);
        this.quantidadeHorasTrabalhadas = quantidadeHorasTrabalhadas;
        this.valorHora = valorHora;
    }

    @Override
    public double calcularPagamento() {
        return quantidadeHorasTrabalhadas * valorHora;
    }
}
