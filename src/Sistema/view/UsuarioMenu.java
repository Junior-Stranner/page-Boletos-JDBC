package Sistema.view;

import Sistema.Controll.UsuarioController;
import java.util.Scanner;

public class UsuarioMenu {

    private static final int OP_USUARIO_TESTE = 0;
    private static final int OP_CADASTRAR_USUARIO = 1;
    private static final int OP_MOSTRAR_DADOS_USUARIO = 2;
    private static final int OP_ATUALIZAR_USUARIO = 3;
    private static final int OP_DELETAR_USUARIO = 4;
    private static final int OP_CLIENTE = 5;
    private static final int OP_VOLTAR = 9;

    public static void usuarioMenu() {
        Scanner in = new Scanner(System.in);
        int op;

        try {
            do {
                exibirMenu();
                op = obterEntradaUsuario(in);

                switch (op) {
                    case OP_USUARIO_TESTE:
                        UsuarioController.usuarioTeste();
                        break;
                    case OP_CADASTRAR_USUARIO:
                        UsuarioController.cadastrarUsuario();
                        break;
                    case OP_MOSTRAR_DADOS_USUARIO:
                        UsuarioController.mostraUsuarios();
                        break;
                    case OP_ATUALIZAR_USUARIO:
                        UsuarioController.atualizarUsuario();
                        break;
                    case OP_DELETAR_USUARIO:
                        UsuarioController.deletarUsuario();
                        break;
                    case OP_CLIENTE:
                        ClienteMenu.clienteMenu();
                        break;
                    case OP_VOLTAR:
                        System.out.println("Voltando para o Sistema Principal...");
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente.");
                }
            } while (op != OP_VOLTAR);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }

    private static void exibirMenu() {
        System.out.println("\n📌 Menu de Usuário"
                + "\n " + OP_USUARIO_TESTE + " - Criar Usuário de Teste"
                + "\n " + OP_CADASTRAR_USUARIO + " - Cadastrar Usuário"
                + "\n " + OP_MOSTRAR_DADOS_USUARIO + " - Mostrar Dados do Usuário"
                + "\n " + OP_ATUALIZAR_USUARIO + " - Atualizar Usuário"
                + "\n " + OP_DELETAR_USUARIO + " - Deletar Usuário"
                + "\n " + OP_CLIENTE + " - Gerenciar Clientes"
                + "\n " + OP_VOLTAR + " - Voltar ao Sistema Principal");
    }

    private static int obterEntradaUsuario(Scanner in) {
        while (true) {
            try {
                System.out.print("Escolha uma opção: ");
                return Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número.");
            }
        }
    }
}
