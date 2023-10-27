public abstract class Funcionario {
	protected String nome;

	public Funcionario(String nome) {
		this.nome = nome;
	}

	public abstract double calcularPagamento();

	public void imprimirComprovante() {
		System.out.println("Nome: " + nome);
		System.out.println("Salário: R$ " + calcularPagamento());
	}
}
