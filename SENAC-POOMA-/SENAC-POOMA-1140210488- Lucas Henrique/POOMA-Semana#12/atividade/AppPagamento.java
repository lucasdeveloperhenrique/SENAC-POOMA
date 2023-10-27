import java.util.Scanner;

public class AppPagamento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FuncionarioView funcionarioView = new FuncionarioView();
        FuncionarioController funcionarioController = new FuncionarioController();

        System.out.println("Informe os dados do funcionário:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Departamento: ");
        String departamento = scanner.nextLine();
        System.out.print("Função (Tarefeiro, Horista, Mensalista): ");
        String funcao = scanner.nextLine();
        System.out.print("Salário: ");
        double salario = scanner.nextDouble();

        FuncionarioModel funcionario = funcionarioController.criarFuncionario(nome, departamento, funcao, salario);
        funcionarioView.imprimirComprovante(funcionario);

        scanner.close();
    }
}
