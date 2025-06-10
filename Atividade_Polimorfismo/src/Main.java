import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        //HashMap armazena pares de chave-valor onde, por exemplo, 
        // a chave é a placa do carro e o valor é o objeto Carro     

        HashMap<String, Carro> mapaCarros = new HashMap<>();
        HashMap<String, Cliente> mapaClientes = new HashMap<>();
        HashMap<Carro, Emprestimo> mapaEmprestimos = new HashMap<>();

        ArrayList<String> padraoString = new ArrayList<>();
        ArrayList<Double> padraoDouble = new ArrayList<>();

        while (true) {
            int opcao = Integer.parseInt(JOptionPane.showInputDialog("****** Locadora de Carros Java ****** \nEscolha uma opção: \n1 - Cadastrar Carro \n2 - Cadastrar Cliente \n3 - Alugar Carro \n4 - Devolver Carro \n5 - Sair"));

            switch (opcao) {
                case 1:
                    Carro carro;

                    int tipoCarro;
                    while (true) {

                        tipoCarro = Integer.parseInt(JOptionPane.showInputDialog("Escolha o tipo de carro: \n1 - Carro Popular \n2 - Carro SUV \n3 - Carro Luxo"));


                        if (tipoCarro == 1 || tipoCarro == 2 || tipoCarro == 3) {
                            break;

                        } else {
                            JOptionPane.showMessageDialog(null, "Tente novamente.");
                        }
                    }


                    padraoString.add(JOptionPane.showInputDialog("Digite o marca do veículo: "));


                    padraoString.add(JOptionPane.showInputDialog("Digite o modelo do veículo: "));


                    padraoString.add(JOptionPane.showInputDialog("Digite o placa do veículo: "));

                    padraoString.add(JOptionPane.showInputDialog("Digite o ano do veículo: "));

                    padraoDouble.add(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da locação do veículo: ")));

                    padraoDouble.add(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da multa do veículo: ")));

                    if (tipoCarro == 1) {
                        boolean temAr = JOptionPane.showConfirmDialog(null, "O carro possui ar-condicionado?") == JOptionPane.YES_OPTION;
                        carro = new CarroPopular(padraoString.get(0), padraoString.get(1), padraoString.get(2), padraoString.get(3), padraoDouble.get(0), padraoDouble.get(1), temAr);
                    } else if (tipoCarro == 2) {

                        padraoDouble.add(Double.parseDouble(JOptionPane.showInputDialog("Insira o tamanho do porta-malas em metros ?")));

                        padraoString.add(JOptionPane.showInputDialog("Qual o tipo de tração ? "));

                        padraoString.add(JOptionPane.showInputDialog("Qual o tipo de combustível? "));


                        carro = new CarroSUV(padraoString.get(0),
                                padraoString.get(1),
                                padraoString.get(2),
                                padraoString.get(3),
                                padraoDouble.get(0),
                                padraoDouble.get(1),
                                padraoDouble.get(2),
                                padraoString.get(4),
                                padraoString.get(5));

                        mapaCarros.put(carro.getPlaca(), carro);

                    } else if (tipoCarro == 3) {
                        int qntdAirBags = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de Air-Bags: "));

                        padraoDouble.add(Double.parseDouble(JOptionPane.showInputDialog("Insira o tamanho do porta-malas em metros (Ex.: 2.3): ")));


                        boolean temGPS = JOptionPane.showConfirmDialog(null, "O carro possui GPS?") == JOptionPane.YES_OPTION;


                        carro = new CarroLuxo(padraoString.get(0),
                                padraoString.get(1),
                                padraoString.get(2),
                                padraoString.get(3),
                                padraoDouble.get(0),
                                padraoDouble.get(1),
                                qntdAirBags,
                                padraoDouble.get(2),
                                temGPS);

                        mapaCarros.put(carro.getPlaca(), carro);
                    }

                    JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso!");
                    break;

                case 2:
                    int tipoPessoa;

                    while (true) {

                        tipoPessoa = Integer.parseInt(JOptionPane.showInputDialog("Digite o tipo de Cliente:\n1. Pessoa Física.\n2. Pessoa Jurídica."));


                        if (tipoPessoa == 1 || tipoPessoa == 2) {
                            break;

                        } else {
                            JOptionPane.showMessageDialog(null, "Digite uma opção válida.");
                        }
                    }

                    padraoString.add(JOptionPane.showInputDialog("Digite o nome do cliente: "));

                    padraoString.add(JOptionPane.showInputDialog("Digite o endereço do cliente: "));
                    
                    padraoString.add(JOptionPane.showInputDialog("Digite o telefone do cliente: "));

                    if (tipoPessoa == 1) {
                        
                        padraoString.add(JOptionPane.showInputDialog("Digite o CPF do cliente: "));

                        ClientePF cliente = new ClientePF(padraoString.get(0),
                                padraoString.get(1),
                                padraoString.get(2),
                                padraoString.get(3));

                        mapaClientes.put(cliente.getCpf(), cliente);

                    } else if (tipoPessoa == 2) {

                        padraoString.add(JOptionPane.showInputDialog("Digite o nome do representante: "));

                        padraoString.add(JOptionPane.showInputDialog("Digite o CNPJ do cliente: "));

                        ClientePJ cliente = new ClientePJ(padraoString.get(0),
                                padraoString.get(1),
                                padraoString.get(2),
                                padraoString.get(3),
                                padraoString.get(4));

                        mapaClientes.put(cliente.getCnpj(), cliente);
                    }

                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                    break;

                case 3:
                    if (!mapaCarros.isEmpty() && !mapaClientes.isEmpty()) {
                        String identificadorCliente = "";
                        String placa = "";

                        identificadorCliente = JOptionPane.showInputDialog("Digite o identificador (CPF ou CNPJ) do cliente: ");

                        if (mapaClientes.get(identificadorCliente) == null) {
                            JOptionPane.showMessageDialog(null, "Identificador não encontrado.");
                            break;
                        }

                        placa = JOptionPane.showInputDialog("Digite a placa do carro: ");

                        if (mapaCarros.get(placa) == null) {
                            System.out.println("\nPlaca não encontrada.");
                            break;
                        }

                        if (mapaClientes.get(identificadorCliente) instanceof ClientePF && mapaClientes.get(identificadorCliente).getTotalEmprestimos() > 0) {
                            JOptionPane.showMessageDialog(null, "Cliente não pode mais realizar empréstimos.");
                            break;

                        } else if (!mapaCarros.get(placa).isDisponivel()) {
                            System.out.println("\nVeículo escolhido não disponível. ");
                            break;

                        } else {
                            Emprestimo emprestimo = new Emprestimo(mapaClientes.get(identificadorCliente), mapaCarros.get(placa));
                            mapaEmprestimos.put(mapaCarros.get(placa), emprestimo);
                            JOptionPane.showMessageDialog(null, "Empréstimo realizado com sucesso!\n" +
                                    "Cliente: " + emprestimo.getCliente().getNome() + "\n" +
                                    "Carro: " + emprestimo.getCarro().getMarca() + " " + emprestimo.getCarro().getModelo() + "\n" +
                                    "Placa: " + emprestimo.getCarro().getPlaca());
                            break;
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Erro: Cadastro de cliente ou veículo vazio.");
                    break;

                case 4:
                    if (!mapaEmprestimos.isEmpty()) {
                        String placa = "";

                        placa = JOptionPane.showInputDialog("Digite a placa do carro para devolução: ");

                        if (mapaCarros.get(placa) == null) {
                            JOptionPane.showMessageDialog(null, "Placa não encontrada.");
                            break;
                        }

                        if (mapaCarros.get(placa).isDisponivel()) {
                            JOptionPane.showMessageDialog(null, "Veículo escolhido não alocado.");
                            break;

                        } else {
                            mapaEmprestimos.get(mapaCarros.get(placa)).realizarDevolucao();
                            mapaEmprestimos.remove(mapaCarros.get(placa));
                            JOptionPane.showMessageDialog(null, "Devolução realizada com sucesso!\n" +
                                    "Cliente: " + mapaEmprestimos.get(placa).getCliente().getNome() + "\n" +
                                    "Carro: " + mapaCarros.get(placa).getMarca() + " " + mapaCarros.get(placa).getModelo() + "\n" +
                                    "Placa: " + mapaCarros.get(placa).getPlaca() + "\n" +
                                    "Valor final: R$" + mapaEmprestimos.get(mapaCarros.get(placa)).getValorFinal());
                            break;
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Erro: Cadastro de empréstimos vazio.");
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Obrigado por utilizar nosso sistema!");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
                    break;
            }


        }
    }

}
