public class FuncionarioModel {
    private String nome;
    private String departamento;
    private String funcao;
    private double salario;

    public FuncionarioModel(String nome, String departamento, String funcao, double salario) {
        this.nome = nome;
        this.departamento = departamento;
        this.funcao = funcao;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getFuncao() {
        return funcao;
    }

    public double getSalario() {
        return salario;
    }
}
