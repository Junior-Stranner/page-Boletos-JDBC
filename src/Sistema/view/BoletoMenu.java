package Sistema.view;

import Sistema.Controll.BoletoController;
import java.util.Scanner;

public class BoletoMenu {

    private static final int OP_GERAR_BOLETO = 1;
    private static final int OP_MOSTRAR_BOLETOS = 2;
    private static final int OP_PAGAR_BOLETO = 3;
    private static final int OP_VOLTA_USUARIO = 4;

    public static void boletoMenu() {
        Scanner in = new Scanner(System.in);
        int op;

        try {
            do {
                exibirMenu();
                op = obterEntradaUsuario(in);

                switch (op) {
                    case OP_GERAR_BOLETO:
                        BoletoController.gerarBoleto();
                        break;
                    case OP_MOSTRAR_BOLETOS:
                        BoletoController.mostrarBoletos();
                        break;
                    case OP_PAGAR_BOLETO:
                        BoletoController.pagarBoleto();
                        break;
                    case OP_VOLTA_USUARIO:
                        System.out.println("🔙 Voltando para o Sistema Principal...");
                        return;
                    default:
                        System.out.println("❌ Opção inválida! Tente novamente.");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("⚠ Ocorreu um erro inesperado: " + e.getMessage());
        }
    }

    private static void exibirMenu() {
        System.out.println("\n📌 **Menu de Boletos**");
        System.out.println("1️⃣ - Gerar Boleto");
        System.out.println("2️⃣ - Mostrar Boletos");
        System.out.println("3️⃣ - Pagar Boleto");
        System.out.println("4️⃣ - 🔙 Voltar para o Sistema Principal");
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
