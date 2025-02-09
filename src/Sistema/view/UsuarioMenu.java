package Sistema.view;

import Sistema.Controll.ClienteController;
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
        int op = 0;

        try {
            do {
                exibirMenu();
                op = obterEntradaUsuario(in);

                switch (op) {
                    case OP_USUARIO_TESTE:
                        UsuarioController.usuarioTeste();
                        break;
                    case OP_CADASTRAR_USUARIO:
                        UsuarioController.CadastrarUsuario();
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
                        System.out.println("Voltando para o Sistema Principal");
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente.");
                }

            } while (op != OP_VOLTAR);
        } catch (NumberFormatException e) {
            System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        } finally {
            // Scanner fechado fora do método para evitar o fechamento do System.in
        }
    }

    private static void exibirMenu() {
        System.out.println("User Menu"
                + "\n " + OP_USUARIO_TESTE + " - Usuário Teste-(Criado auto)"
                + "\n " + OP_CADASTRAR_USUARIO + " - Cadastrar Usuario"
                + "\n " + OP_MOSTRAR_DADOS_USUARIO + " - Mostrar Dados Usuário"
                + "\n " + OP_ATUALIZAR_USUARIO + " - Atualizar Usuário"
                + "\n " + OP_DELETAR_USUARIO + " - Deletar Usuário"
                + "\n " + OP_CLIENTE + " - Cliente"
                + "\n " + OP_VOLTAR + " - Voltar ao Sistema Principal");
    }

    private static int obterEntradaUsuario(Scanner in) {
        int op = 0;
        try {
            op = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Tente novamente.");
        }
        return op;
    }
}
