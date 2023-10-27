public class FuncionarioView {
    public void imprimirComprovante(FuncionarioModel funcionario) {
        System.out.println("Nome do Funcionário: " + funcionario.getNome());
        System.out.println("Departamento: " + funcionario.getDepartamento());
        System.out.println("Função: " + funcionario.getFuncao());
        System.out.println("Salário: R$ " + funcionario.getSalario());
        System.out.println();
    }
}
