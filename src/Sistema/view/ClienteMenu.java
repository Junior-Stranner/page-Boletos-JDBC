package Sistema.view;

import Sistema.Controll.ClienteController;
import Sistema.Model.Cliente;
import Sistema.Model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteMenu {

    private static final int OP_CADASTRAR_CLIENTE = 1;
    private static final int OP_MOSTRAR_DADOS_CLIENTE = 2;
  //  private static final int OP_ATUALIZAR_CLIENTE = 3;
    private static final int OP_DELETAR_CLIENTE = 4;
    private static final int OP_PRODUTO = 5;
    private static final int OP_PAGAMENTO = 6;
    private static final int OP_BOLETOS = 7;
    private static final int OP_VOLTA_SISTEMA = 9;

    public static void clienteMenu(List<Usuario> usuarios, List<Cliente> clientes) {
        Scanner in = new Scanner(System.in);
        int op;

        try {
            do {
                exibirMenu();
                op = obterEntradaUsuario(in);

                switch (op) {
                    case OP_CADASTRAR_CLIENTE:
                        ClienteController.cadastarCliente(usuarios, clientes);
                        break;
                    case OP_MOSTRAR_DADOS_CLIENTE:
                        ClienteController.mostraClientes(usuarios, clientes);
                        break;
                  /*  case OP_ATUALIZAR_CLIENTE:
                        ClienteController.atualizarCliente(clientes);
                        break;*/
                    case OP_DELETAR_CLIENTE:
                        ClienteController.deletarCliente(clientes);
                        break;
                    case OP_PRODUTO:
                        ProdutoMenu.produtoMenu();
                        break;
                    case OP_PAGAMENTO:
                        PagamentoMenu.pagamentoMenu();
                        break;
                    case OP_BOLETOS:
                        BoletoMenu.boletoMenu();
                        break;
                    case OP_VOLTA_SISTEMA:
                        System.out.println("🔙 Voltando para o Sistema Principal...");
                        return; // Sai do método e retorna ao sistema principal
                    default:
                        System.out.println("❌ Opção inválida! Tente novamente.");
                }
            } while (op != OP_VOLTA_SISTEMA);
        } catch (Exception e) {
            System.out.println("⚠ Ocorreu um erro inesperado: " + e.getMessage());
        }
    }

    private static void exibirMenu() {
        System.out.println("\n📌 **Menu do Cliente**");
        System.out.println("1️⃣ - Cadastrar Cliente");
        System.out.println("2️⃣ - Mostrar Dados do Cliente");
     //   System.out.println("3️⃣ - Atualizar Cliente");
        System.out.println("4️⃣ - Deletar Cliente");
        System.out.println("5️⃣ - Acessar Produtos");
        System.out.println("6️⃣ - Acessar Pagamento");
        System.out.println("7️⃣ - Gerenciar Boletos");
        System.out.println("9️⃣ - 🔙 Voltar para o Sistema Principal");
    }

    private static int obterEntradaUsuario(Scanner in) {
        while (true) {
            try {
                System.out.print("🔹 Escolha uma opção: ");
                return Integer.parseInt(in.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida! Digite um número.");
            }
        }
    }
}
