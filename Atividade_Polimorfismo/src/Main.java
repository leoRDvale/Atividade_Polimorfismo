import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Carro> carros = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Emprestimo> emprestimos = new ArrayList<>();

        int op;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Cadastrar veículo");
            System.out.println("2 - Cadastrar cliente");
            System.out.println("3 - Realizar empréstimo");
            System.out.println("4 - Finalizar empréstimo");
            System.out.println("5 - Sair\n\n");
            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    System.out.println("Tipo de carro: 1-Popular 2-SUV 3-Luxo");
                    int tipo = Integer.parseInt(sc.nextLine());
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();
                    System.out.print("Ano: ");
                    String ano = sc.nextLine();
                    System.out.print("Valor da locação: ");
                    double valorLocacao = Double.parseDouble(sc.nextLine());
                    System.out.print("Valor da multa: ");
                    double valorMulta = Double.parseDouble(sc.nextLine());

                    Carro carro = null;
                    if (tipo == 1) {
                        System.out.print("Possui ar-condicionado (true/false): ");
                        boolean ar = Boolean.parseBoolean(sc.nextLine());
                        carro = new CarroPopular(marca, modelo, placa, ano, valorLocacao, valorMulta, ar);
                    }
                    else if (tipo == 2) {
                        System.out.print("Quantidade de airbags: ");
                        int qntAirBags = Integer.parseInt(sc.nextLine());
                        System.out.print("Tamanho do porta-malas: ");
                        double tamanhoPortaMalas = Double.parseDouble(sc.nextLine());
                        System.out.print("Possui GPS (true/false): ");
                        boolean temGPS = Boolean.parseBoolean(sc.nextLine());
                        carro = new CarroLuxo(marca, modelo, placa, ano, valorLocacao, valorMulta, qntAirBags, tamanhoPortaMalas, temGPS);
                    } else if (tipo == 3) {

                        System.out.print("Quantidade de airbags: ");
                        int qntAirBags = Integer.parseInt(sc.nextLine());
                        System.out.print("Tamanho do porta-malas: ");
                        double tamanhoPortaMalas = Double.parseDouble(sc.nextLine());
                        System.out.print("Possui GPS (true/false): ");
                        boolean temGPS = Boolean.parseBoolean(sc.nextLine());
                        carro = new CarroLuxo(marca, modelo, placa, ano, valorLocacao, valorMulta, qntAirBags, tamanhoPortaMalas, temGPS);

                    }

                    if (carro != null) {
                        carros.add(carro);
                        System.out.println("Veículo cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar veículo.");
                    }
                    break;

                case 2:
                    System.out.println("Tipo de cliente: 1-Física 2-Jurídica");
                    int tipoCli = Integer.parseInt(sc.nextLine());
                    if (tipoCli == 1) {
                        System.out.print("Nome: ");
                        String nomeCli = sc.nextLine();
                        System.out.print("Endereço: ");
                        String end = sc.nextLine();
                        System.out.print("Telefone: ");
                        String tel = sc.nextLine();
                        System.out.print("CPF: ");
                        String cpf = sc.nextLine();
                        Cliente pf = new ClientePF(nomeCli, end, tel, cpf);
                        clientes.add(pf);
                        System.out.println("Cliente cadastrado com sucesso!");
                    } else if (tipoCli == 2) {
                        System.out.print("Nome: ");
                        String nomeCli = sc.nextLine();
                        System.out.print("Endereço: ");
                        String end = sc.nextLine();
                        System.out.print("Telefone: ");
                        String tel = sc.nextLine();
                        System.out.print("CNPJ: ");
                        String cnpj = sc.nextLine();
                        System.out.print("Representante: ");
                        String representante = sc.nextLine();
                        Cliente pj = new ClientePJ(nomeCli, end, tel, cnpj, representante);
                        clientes.add(pj);
                        System.out.println("Cliente cadastrado com sucesso!");
                    }
                    break;

                case 3:
                    if (clientes.isEmpty() || carros.stream().noneMatch(Carro::isDisponivel)) {
                        System.out.println("Cadastre ao menos 1 cliente e 1 veículo disponível.");
                        break;
                    }
                    System.out.println("Clientes:");
                    for (int i = 0; i < clientes.size(); i++) {
                        System.out.println(i + " - " + clientes.get(i).getNome());
                    }
                    System.out.print("Escolha o cliente (índice): ");
                    int idxCli = Integer.parseInt(sc.nextLine());
                    Cliente cli = clientes.get(idxCli);

                    System.out.println("Veículos disponíveis:");
                    ArrayList<Carro> disponiveis = new ArrayList<>();
                    for (Carro c : carros) {
                        if (c.isDisponivel()) disponiveis.add(c);
                    }
                    for (int i = 0; i < disponiveis.size(); i++) {
                        System.out.println(i + " - " + disponiveis.get(i).getModelo() + " (" + disponiveis.get(i).getPlaca() + ")");
                    }
                    System.out.print("Escolha o veículo (índice): ");
                    int idxVei = Integer.parseInt(sc.nextLine());
                    Carro vei = disponiveis.get(idxVei);

                    Emprestimo emp = new Emprestimo(cli, vei);
                    emprestimos.add(emp);
                    System.out.println("Empréstimo realizado com sucesso!");
                    break;

                case 4:
                    if (emprestimos.isEmpty()) {
                        System.out.println("Nenhum empréstimo ativo.");
                        break;
                    }
                    System.out.println("Empréstimos ativos:");
                    for (int i = 0; i < emprestimos.size(); i++) {
                        Emprestimo e = emprestimos.get(i);
                        System.out.println(i + " - Cliente: " + e.getCliente().getNome() + ", Veículo: " + e.getCarro().getModelo() + " (" + e.getCarro().getPlaca() + ")");
                    }
                    System.out.print("Escolha o empréstimo (índice): ");
                    int idxEmp = Integer.parseInt(sc.nextLine());
                    Emprestimo emprest = emprestimos.get(idxEmp);
                    emprest.realizarDevolucao();
                    emprestimos.remove(emprest);
                    System.out.println("Empréstimo finalizado. Valor total: R$ " + emprest.getValorFinal());
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (op != 5);

        sc.close();
    }
}