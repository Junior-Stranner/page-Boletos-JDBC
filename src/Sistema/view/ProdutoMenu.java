package Sistema.view;

import Sistema.Controll.ProdutoController;

import java.util.Scanner;

public class ProdutoMenu {

    private static final int OP_REALIZAR_COMPRA = 1;
    private static final int OP_PAGAMENTO = 2;
    private static final int OP_BOLETOS = 3;
    private static final int OP_VOLTA_CLIENTE = 4;
    private static final int OP_VOLTA_USUARIO = 5;
    private static final int OP_VOLTAR_SISTEMA = 6;

    public static void produtoMenu() {
        Scanner in = new Scanner(System.in);
        int op = 0;

        try {
            do {
                exibirMenu();
                op = obterEntradaUsuario(in);

                switch (op) {
                    case OP_REALIZAR_COMPRA:
                        ProdutoController.realizarCompra();
                        break;
                    case OP_PAGAMENTO:
                        break;
                    case OP_BOLETOS:

                        break;
                    case OP_VOLTA_CLIENTE:
                        break;
                    case OP_VOLTA_USUARIO:
                        break;
                    case OP_VOLTAR_SISTEMA:
                        System.out.println("Voltando para o Sistema Principal");
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente.");
                }

            } while (op != OP_VOLTAR_SISTEMA);
        } catch (NumberFormatException e) {
            System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        } finally {
            // Scanner fechado fora do método para evitar o fechamento do System.in
        }
    }

    private static void exibirMenu() {
        System.out.println("Produto Menu"
                + "\n " + OP_REALIZAR_COMPRA + " - Realizar Compra"
                + "\n " + OP_PAGAMENTO + " - Pagamento"
                + "\n " + OP_BOLETOS + " - Boletos"
                + "\n " + OP_VOLTA_CLIENTE + " - Voltar Cliente"
                + "\n " + OP_VOLTA_USUARIO + " - Voltar Usuário"
                + "\n " + OP_VOLTAR_SISTEMA + " - Sistema Principal");
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
