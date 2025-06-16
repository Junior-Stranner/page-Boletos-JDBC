package Sistema.view;

import Sistema.Controll.ProdutoController;
import Sistema.Model.Cliente;
import Sistema.Model.Usuario;

import java.util.List;
import java.util.Scanner;

public class ProdutoMenu {

    private static final int OP_REALIZAR_COMPRA = 1;
    private static final int OP_MOSTRAR_PRODUTOS = 2;
    private static final int OP_PAGAMENTO = 3;
    private static final int OP_BOLETOS = 4;
    private static final int OP_VOLTA_CLIENTE = 5;
    private static final int OP_VOLTA_USUARIO = 6;
    private static final int OP_VOLTAR_SISTEMA = 9;

    public static void produtoMenu(List<Usuario> usuarios, List<Cliente> clientes) {
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
                    case OP_MOSTRAR_PRODUTOS:
                        ProdutoController.mostrarProdutos();

                    case OP_PAGAMENTO:
                        PagamentoMenu.pagamentoMenu(usuarios,clientes);
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
                + "\n " + OP_REALIZAR_COMPRA + " - 1. Realizar Compra"
                + "\n " + OP_MOSTRAR_PRODUTOS + " - 2. Mostrar Produto"
                + "\n " + OP_PAGAMENTO + " - 3. Efetuar Pagamento"
                + "\n " + OP_BOLETOS + " - 4. Gerenciar Boletos"
                + "\n " + OP_VOLTA_CLIENTE + " - 5. Voltar para o Cliente"
                + "\n " + OP_VOLTA_USUARIO + " - 6. Voltar para o Usuário"
                + "\n " + OP_VOLTAR_SISTEMA + " - 9. Retornar ao Sistema Principal");
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
