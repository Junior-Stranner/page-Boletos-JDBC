package Sistema.view;

import Sistema.Controll.UsuarioController;

import java.util.Scanner;

public class UsuarioMenu {

    public static void usuarioMenu() {
        Scanner in = new Scanner(System.in);
        int op = 0;
        try {
            do {
                System.out.println("User Menu"
                        + "\n 1 - Cadastrar Usuario"
                        + "\n 2 - Mostrar Dados Usuário"
                        + "\n 3 - Atualizar Usuário"
                        + "\n 4 - Deletar Usuário"
                        + "\n 5 - Voltar");

                op = Integer.parseInt(in.nextLine());

                switch (op) {
                    case 1:
                        UsuarioController.CadastrarUsuario();  // Corrigido para chamar o método correto
                        break;
                    case 2:
                        UsuarioController.mostraUsuarios();
                        break;
                    case 3:
                        UsuarioController.atualizarUsuario();  // Corrigido para chamar o método correto
                        break;
                    case 4:
                        UsuarioController.deletarUsuario();
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
