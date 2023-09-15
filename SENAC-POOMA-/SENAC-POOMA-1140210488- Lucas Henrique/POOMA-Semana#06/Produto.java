public class Produto {
    private int id;
    private int classificacao;
    private String nomeProduto;
    private double precoProduto;

    public Produto(int id, int classificacao, String nomeProduto, double precoProduto) {
        this.id = id;
        this.classificacao = classificacao;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    @Override
    public String toString() {
        return "Produto [id=" + id + ", classificacao=" + classificacao + ", nomeProduto=" + nomeProduto
                + ", precoProduto=" + precoProduto + "]";
    }
}
