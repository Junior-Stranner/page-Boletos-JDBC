package Sistema.view;

import Sistema.Controll.ClienteController;
import Sistema.Controll.ProdutoController;

import java.util.Scanner;

public class ClienteMenu {

    private static final int OP_CADASTRAR_CLIENTE = 1;
    private static final int OP_MOSTRAR_DADOS_CLIENTE = 2;
    private static final int OP_ATUALIZAR_CLIENTE = 3;
    private static final int OP_DELETAR_CLIENTE = 4;
    private static final int OP_PRODUTO = 5;
    private static final int OP_PAGAMENTO = 6;
    private static final int OP_BOLETOS = 7;
    private static final int OP_VOLTA_USUARIO = 9;

    public static void clienteMenu() {
        Scanner in = new Scanner(System.in);
        int op = 0;

        try {
            do {
                exibirMenu();
                op = obterEntradaUsuario(in);

                switch (op) {
                    case OP_CADASTRAR_CLIENTE:
                        ClienteController.cadastarCliente();
                        break;
                    case OP_MOSTRAR_DADOS_CLIENTE:
                        ClienteController.mostraClientes();
                        break;
                    case OP_ATUALIZAR_CLIENTE:
                        ClienteController.atualizarCliente();
                        break;
                    case OP_DELETAR_CLIENTE:
                        ClienteController.deletarCliente();
                        break;
                    case OP_PRODUTO:
                        ProdutoMenu.produtoMenu();
                        break;
                    case OP_PAGAMENTO:
                        break;
                    case OP_BOLETOS:
                        break;
                    case OP_VOLTA_USUARIO:
                        System.out.println("Voltando para o Sistema Principal");
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente.");
                }

            } while (op != OP_VOLTA_USUARIO);
        } catch (NumberFormatException e) {
            System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        } finally {
            // Scanner fechado fora do método para evitar o fechamento do System.in
        }
    }

    private static void exibirMenu() {
        System.out.println("Cliente Menu"
                + "\n " + OP_CADASTRAR_CLIENTE + " - Cadastrar Cliente"
                + "\n " + OP_MOSTRAR_DADOS_CLIENTE + " - Mostrar Dados Cliente"
                + "\n " + OP_ATUALIZAR_CLIENTE + " - Atualizar Cliente"
                + "\n " + OP_DELETAR_CLIENTE + " - Deletar Cliente"
                + "\n " + OP_PRODUTO + " - Produto"
                + "\n " + OP_PAGAMENTO + " - Pagamento"
                + "\n " + OP_BOLETOS + " - Boletos"
                + "\n " + OP_VOLTA_USUARIO + " - Voltar Usuário");
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
