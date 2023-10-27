class Mensalista extends Funcionario {
    private double salarioMensal;

    public Mensalista(String nome, double salarioMensal) {
        super(nome);
        this.salarioMensal = salarioMensal;
    }

    @Override
    public double calcularPagamento() {
        return salarioMensal;
    }
}
