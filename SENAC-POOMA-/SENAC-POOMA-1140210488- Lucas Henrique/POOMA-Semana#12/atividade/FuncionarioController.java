public class FuncionarioController {
    public FuncionarioModel criarFuncionario(String nome, String departamento, String funcao, double salario) {
        return new FuncionarioModel(nome, departamento, funcao, salario);
    }
}
