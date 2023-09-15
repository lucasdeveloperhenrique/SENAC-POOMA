import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Produto> bancoDeDadosProdutos = new ArrayList<>();
    private static int proximoId = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Inclusão de produtos");
            System.out.println("2 - Consultar um determinado produto");
            System.out.println("3 - Excluir um determinado produto");
            System.out.println("4 - Alterar um determinado produto");
            System.out.println("5 - Listar todos os produtos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    incluirProduto();
                    break;
                case 2:
                    consultarProduto();
                    break;
                case 3:
                    excluirProduto();
                    break;
                case 4:
                    alterarProduto();
                    break;
                case 5:
                    listarProdutos();
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void incluirProduto() {
        System.out.println("\nInclusão de Produto:");
        System.out.print("Classificação: ");
        int classificacao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("Nome do Produto: ");
        String nomeProduto = scanner.nextLine();
        System.out.print("Preço do Produto: ");
        double precoProduto = scanner.nextDouble();

        Produto novoProduto = new Produto(proximoId, classificacao, nomeProduto, precoProduto);
        bancoDeDadosProdutos.add(novoProduto);
        proximoId++;

        System.out.println("Produto adicionado com sucesso.");
    }

    private static void consultarProduto() {
        System.out.println("\nConsulta de Produto:");
        System.out.print("Digite o ID do Produto a ser consultado: ");
        int idConsulta = scanner.nextInt();

        for (Produto produto : bancoDeDadosProdutos) {
            if (produto.getId() == idConsulta) {
                System.out.println("Produto encontrado:");
                System.out.println(produto);
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    private static void excluirProduto() {
        System.out.println("\nExclusão de Produto:");
        System.out.print("Digite o ID do Produto a ser excluído: ");
        int idExclusao = scanner.nextInt();

        for (Produto produto : bancoDeDadosProdutos) {
            if (produto.getId() == idExclusao) {
                bancoDeDadosProdutos.remove(produto);
                System.out.println("Produto excluído com sucesso.");
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    private static void alterarProduto() {
        System.out.println("\nAlteração de Produto:");
        System.out.print("Digite o ID do Produto a ser alterado: ");
        int idAlteracao = scanner.nextInt();

        for (Produto produto : bancoDeDadosProdutos) {
            if (produto.getId() == idAlteracao) {
                System.out.println("Produto encontrado:");
                System.out.println(produto);

                System.out.print("Nova classificação: ");
                int novaClassificacao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner
                System.out.print("Novo nome do Produto: ");
                String novoNomeProduto = scanner.nextLine();
                System.out.print("Novo preço do Produto: ");
                double novoPrecoProduto = scanner.nextDouble();

                produto.setClassificacao(novaClassificacao);
                produto.setNomeProduto(novoNomeProduto);
                produto.setPrecoProduto(novoPrecoProduto);

                System.out.println("Produto alterado com sucesso.");
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    private static void listarProdutos() {
        System.out.println("\nLista de Todos os Produtos:");
        for (Produto produto : bancoDeDadosProdutos) {
            System.out.println(produto);
        }
    }
}
