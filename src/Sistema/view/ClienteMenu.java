package Sistema.view;

import Sistema.Controll.ClienteController;
import Sistema.Controll.UsuarioController;

import java.util.Scanner;

public class ClienteMenu {
    public static void clienteMenu() {
        Scanner in = new Scanner(System.in);
        int op = 0;
        try {
            do {
                System.out.println("User Menu"
                        + "\n 1 - Cadastrar Cliente"
                        + "\n 2 - Mostrar Dados Cliente"
                        + "\n 3 - Atualizar Cliente"
                        + "\n 4 - Deletar Cliente"
                        + "\n 5 - Voltar");

                op = Integer.parseInt(in.nextLine());

                switch (op) {
                    case 1:
                        ClienteController.cadastarCliente();
                        break;
                    case 2:
                        ClienteController.mostraClientes();
                        break;
                    case 3:
                        ClienteController.atualizarCliente();
                        break;
                    case 4:
                        ClienteController.deletarCliente();
                        break;
                    case 5:
                        System.out.println("Voltando para o Sistema Principal");
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente.");
                }

            } while (op != 5);
        } catch (NumberFormatException e) {
            System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        } finally {
            in.close();
        }
    }
}
