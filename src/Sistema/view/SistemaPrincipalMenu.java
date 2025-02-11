package Sistema.view;

import Sistema.Controll.UsuarioController;
import Sistema.Model.Cliente;
import Sistema.Model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaPrincipalMenu {

    private static final int OP_USUARIO = 1;
    private static final int OP_CLIENTE = 2;
    private static final int OP_PRODUTO = 3;
    private static final int OP_PAGAMENTO = 4;
    private static final int OP_BOLETO = 5;
    private static final int OP_VOLTAR = 9;

    public static void sistemaPrincipalMenu() {

        List<Usuario> usuarios = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        int op;

        try {
            do {
                exibirMenu();
                op = obterEntradaSistema(in);

                switch (op) {
                    case OP_USUARIO:
                        UsuarioMenu.usuarioMenu();
                        break;
                    case OP_CLIENTE:
                        ClienteMenu.clienteMenu(usuarios, clientes);
                        break;
                    case OP_PRODUTO:
                        ProdutoMenu.produtoMenu(usuarios,clientes);
                        break;
                    case OP_PAGAMENTO:
                        PagamentoMenu.pagamentoMenu(usuarios, clientes);
                        break;
                    case OP_BOLETO:
                        BoletoMenu.boletoMenu();
                        break;
                    case OP_VOLTAR:
                        System.out.println("Fechar Sistema...");
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
        System.out.println("\n📌 Menu de Sistema"
                + "\n " + OP_USUARIO + " - 1. Gerenciar Usuário"
                + "\n " + OP_CLIENTE + " - 2. Gerenciar Clientes"
                + "\n " + OP_PRODUTO + " - 3. Gerenciar Produtos"
                + "\n " + OP_PAGAMENTO + " - 4. Gerenciar Pagamentos"
                + "\n " + OP_BOLETO + " - 5. Gerenciar Boletos"
                + "\n " + OP_VOLTAR + " - 9. Voltar ao Sistema Principal");
    }

    private static int obterEntradaSistema(Scanner in) {
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
