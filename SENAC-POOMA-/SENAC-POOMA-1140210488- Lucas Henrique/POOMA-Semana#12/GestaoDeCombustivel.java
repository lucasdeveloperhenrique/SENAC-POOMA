import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

abstract class Veiculo {
    private String tipo;
    private String modelo;
    private String placa;
    private double capacidade;
    private double combustivelInicial;
    private Date dataAbastecimento;
    private Combustivel combustivel;
    private double valorAbastecido;

    public Veiculo(String tipo, String modelo, String placa, double capacidade, double combustivelInicial, Date dataAbastecimento, Combustivel combustivel, double valorAbastecido) {
        this.tipo = tipo;
        this.modelo = modelo;
        this.placa = placa;
        this.capacidade = capacidade;
        this.combustivelInicial = combustivelInicial;
        this.dataAbastecimento = dataAbastecimento;
        this.combustivel = combustivel;
        this.valorAbastecido = valorAbastecido;
    }

    public abstract double getDistanciaPercorrida();

    public abstract double getConsumo();

    public double getCombustivelInicial() {
        return combustivelInicial;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataAbastecimentoStr = sdf.format(dataAbastecimento);
        return "Tipo: " + tipo +
                ", Modelo: " + modelo +
                ", Placa: " + placa +
                ", Capacidade: " + capacidade + " litros" +
                ", Combustível Inicial: " + combustivelInicial + " litros" +
                ", Distância Percorrida: " + getDistanciaPercorrida() + " km" +
                ", Data do Abastecimento: " + dataAbastecimentoStr +
                ", Tipo de Combustível: " + combustivel.getTipo() +
                ", Consumo: " + getConsumo() + " km/l" +
                ", Valor Gasto para Abastecer: R$ " + valorAbastecido;
    }
}

class Carro extends Veiculo {
    private double distanciaPercorrida;

    public Carro(String modelo, String placa, double capacidade, double combustivelInicial, Date dataAbastecimento, Combustivel combustivel, double valorAbastecido, double distanciaPercorrida) {
        super("carro", modelo, placa, capacidade, combustivelInicial, dataAbastecimento, combustivel, valorAbastecido);
        this.distanciaPercorrida = distanciaPercorrida;
    }

    @Override
    public double getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    @Override
    public double getConsumo() {
        return distanciaPercorrida / getCombustivelInicial();
    }
}

class Caminhao extends Veiculo {
    private double distanciaPercorrida;

    public Caminhao(String modelo, String placa, double capacidade, double combustivelInicial, Date dataAbastecimento, Combustivel combustivel, double valorAbastecido, double distanciaPercorrida) {
        super("caminhao", modelo, placa, capacidade, combustivelInicial, dataAbastecimento, combustivel, valorAbastecido);
        this.distanciaPercorrida = distanciaPercorrida;
    }

    @Override
    public double getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    @Override
    public double getConsumo() {
        return distanciaPercorrida / getCombustivelInicial();
    }
}

class Moto extends Veiculo {
    private double distanciaPercorrida;

    public Moto(String modelo, String placa, double capacidade, double combustivelInicial, Date dataAbastecimento, Combustivel combustivel, double valorAbastecido, double distanciaPercorrida) {
        super("moto", modelo, placa, capacidade, combustivelInicial, dataAbastecimento, combustivel, valorAbastecido);
        this.distanciaPercorrida = distanciaPercorrida;
    }

    @Override
    public double getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    @Override
    public double getConsumo() {
        return distanciaPercorrida / getCombustivelInicial();
    }
}

public class GestaoDeCombustivel {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                criarInterface();
            }
        });
    }

    public static void criarInterface() {
        JFrame frame = new JFrame("Gestão de Combustível");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Gestão de Combustível");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(label);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        List<Veiculo> veiculos = new ArrayList<>();

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        JTextField tipoField = new JTextField(10);
        JTextField modeloField = new JTextField(20);
        JTextField placaField = new JTextField(10);
        JTextField capacidadeField = new JTextField(10);
        JTextField combustivelInicialField = new JTextField(10);
        JTextField distanciaPercorridaField = new JTextField(10);
        JTextField dataAbastecimentoField = new JTextField(10);
        JTextField tipoCombustivelField = new JTextField(10);
        JTextField valorAbastecidoField = new JTextField(10);

        inputPanel.add(new JLabel("Tipo do Veículo (carro, caminhao, moto):"));
        inputPanel.add(tipoField);
        inputPanel.add(new JLabel("Cor e Modelo do Veículo :"));
        inputPanel.add(modeloField);
        inputPanel.add(new JLabel("Placa do Veículo:"));
        inputPanel.add(placaField);
        inputPanel.add(new JLabel("Capacidade do Veículo (litros):"));
        inputPanel.add(capacidadeField);
        inputPanel.add(new JLabel("Quantidade de Combustível Inicial (litros):"));
        inputPanel.add(combustivelInicialField);
        inputPanel.add(new JLabel("Distância Percorrida (km):"));
        inputPanel.add(distanciaPercorridaField);
        inputPanel.add(new JLabel("Data do Abastecimento (dd/MM/yyyy):"));
        inputPanel.add(dataAbastecimentoField);
        inputPanel.add(new JLabel("Tipo de Combustível:"));
        inputPanel.add(tipoCombustivelField);
        inputPanel.add(new JLabel("Valor Gasto para Abastecer:"));
        inputPanel.add(valorAbastecidoField);

        JButton cadastrarButton = new JButton("Cadastrar Veículo");
        inputPanel.add(cadastrarButton);

        mainPanel.add(inputPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JTextArea resultadoArea = new JTextArea(10, 50);
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);

        mainPanel.add(scrollPane);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String tipo = tipoField.getText().toLowerCase();
                    String modelo = modeloField.getText();
                    String placa = placaField.getText();
                    double capacidade = Double.parseDouble(capacidadeField.getText());
                    double combustivelInicial = Double.parseDouble(combustivelInicialField.getText());
                    double distanciaPercorrida = Double.parseDouble(distanciaPercorridaField.getText());
                    String dataAbastecimentoStr = dataAbastecimentoField.getText();
                    String tipoCombustivel = tipoCombustivelField.getText();
                    double valorAbastecido = Double.parseDouble(valorAbastecidoField.getText());

                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataAbastecimento = sdf.parse(dataAbastecimentoStr);

                    Combustivel combustivel = new Combustivel(tipoCombustivel);
                    Veiculo veiculo;

                    switch (tipo) {
                        case "carro":
                            veiculo = new Carro(modelo, placa, capacidade, combustivelInicial, dataAbastecimento, combustivel, valorAbastecido, distanciaPercorrida);
                            break;
                        case "caminhao":
                            veiculo = new Caminhao(modelo, placa, capacidade, combustivelInicial, dataAbastecimento, combustivel, valorAbastecido, distanciaPercorrida);
                            break;
                        case "moto":
                            veiculo = new Moto(modelo, placa, capacidade, combustivelInicial, dataAbastecimento, combustivel, valorAbastecido, distanciaPercorrida);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Tipo de veículo não suportado", "Erro", JOptionPane.ERROR_MESSAGE);
                            return;
                    }

                    veiculos.add(veiculo);

                    tipoField.setText("");
                    modeloField.setText("");
                    placaField.setText("");
                    capacidadeField.setText("");
                    combustivelInicialField.setText("");
                    distanciaPercorridaField.setText("");
                    dataAbastecimentoField.setText("");
                    tipoCombustivelField.setText("");
                    valorAbastecidoField.setText("");

                    resultadoArea.append("Veículo cadastrado: " + veiculo + "\n");
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Formato de data inválido. Use dd/MM/yyyy", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton exibirButton = new JButton("Exibir Veículos Cadastrados");
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(exibirButton);

        exibirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultadoArea.setText("");
                resultadoArea.append("\nDados dos Veículos Cadastrados:\n");

                // Organizar os veículos por tipo, distância percorrida (maior para menor) e consumo (menor para maior)
                Collections.sort(veiculos, Comparator.comparing(Veiculo::getTipo)
                        .thenComparing(Comparator.comparing(Veiculo::getDistanciaPercorrida).reversed())
                        .thenComparing(Comparator.comparing(Veiculo::getConsumo)));

                for (Veiculo veiculo : veiculos) {
                    resultadoArea.append(veiculo.toString() + "\n");
                }
            }
        });

        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }
}

class Consumo {
    private String placaVeiculo;
    private double valorCombustivelUtilizado;

    public Consumo(String placaVeiculo, double valorCombustivelUtilizado) {
        this.placaVeiculo = placaVeiculo;
        this.valorCombustivelUtilizado = valorCombustivelUtilizado;
    }

    public double getValorCombustivelUtilizado() {
        return valorCombustivelUtilizado;
    }
}

class Combustivel {
    private String tipo;

    public Combustivel(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
