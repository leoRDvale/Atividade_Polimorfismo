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

        ArrayList<String> listaString = new ArrayList<>();
        ArrayList<Double> listaDouble = new ArrayList<>();

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


                    listaString.add(JOptionPane.showInputDialog("Digite o marca do veículo: "));


                    listaString.add(JOptionPane.showInputDialog("Digite o modelo do veículo: "));


                    listaString.add(JOptionPane.showInputDialog("Digite o placa do veículo: "));

                    listaString.add(JOptionPane.showInputDialog("Digite o ano do veículo: "));

                    listaDouble.add(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da locação do veículo: ")));

                    listaDouble.add(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da multa do veículo: ")));

                    if (tipoCarro == 1) {
                        boolean temAr = JOptionPane.showConfirmDialog(null, "O carro possui ar-condicionado?") == JOptionPane.YES_OPTION;
                        carro = new CarroPopular(listaString.get(0), listaString.get(1), listaString.get(2), listaString.get(3), listaDouble.get(0), listaDouble.get(1), temAr);
                    } else if (tipoCarro == 2) {


                        //TODO

                    }
            }

        }
    }
}
