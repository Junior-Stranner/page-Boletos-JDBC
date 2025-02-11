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
        int op;

        try {
            do {
                exibirMenu();
                op = obterEntradaUsuario(in);

                switch (op) {
                    case OP_REALIZAR_COMPRA:
                        ProdutoController.realizarCompra();
                        break;
                    case OP_PAGAMENTO:
                        PagamentoMenu.pagamentoMenu();
                        break;
                    case OP_BOLETOS:
                        BoletoMenu.boletoMenu();
                        break;
                    case OP_VOLTA_CLIENTE:
                        ClienteMenu.clienteMenu(usuarios, clientes);
                        break;
                    case OP_VOLTA_USUARIO:
                        UsuarioMenu.usuarioMenu();
                        break;
                    case OP_VOLTAR_SISTEMA:
                        System.out.println("Voltando para o Sistema Principal...");
                        break;
                    default:
                        System.out.println("❌ Opção inválida. Por favor, tente novamente.");
                }
            } while (op != OP_VOLTAR_SISTEMA);
        } catch (Exception e) {
            System.out.println("⚠ Ocorreu um erro inesperado: " + e.getMessage());
        }
    }

    private static void exibirMenu() {
        System.out.println("\n🛒 Menu de Produtos"
                + "\n " + OP_REALIZAR_COMPRA + " - Realizar Compra"
                + "\n " + OP_PAGAMENTO + " - Efetuar Pagamento"
                + "\n " + OP_BOLETOS + " - Gerenciar Boletos"
                + "\n " + OP_VOLTA_CLIENTE + " - Voltar para o Cliente"
                + "\n " + OP_VOLTA_USUARIO + " - Voltar para o Usuário"
                + "\n " + OP_VOLTAR_SISTEMA + " - Retornar ao Sistema Principal");
    }

    private static int obterEntradaUsuario(Scanner in) {
        while (true) {
            try {
                System.out.print("🔹 Escolha uma opção: ");
                return Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida. Digite um número.");
            }
        }
    }
}
