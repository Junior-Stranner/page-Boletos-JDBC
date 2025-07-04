package Sistema.Controll;

import Sistema.Model.Boleto;
import Sistema.Model.Cliente;
import Sistema.Model.Pagamento;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoletoController {

    private static List<Pagamento> pagamentos = new ArrayList<>();
    private static List<Boleto> boletos = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();

    public static void metodoPagamento() {
        Scanner in = new Scanner(System.in);

        System.out.println("Digite o seu email:");
        String email = in.nextLine();

        boolean clienteEncontrado = false;

        for (Cliente c : clientes) {
            if (c.getEmail().equals(email)) {
                clienteEncontrado = true;
                System.out.println("Seja bem vindo " + c.getNome());
                for (Pagamento pag : pagamentos) {
                    System.out.println("Sua(s) compras a pagar " + pag.getProduto().toString());
                    System.out.println("\n qual seria a forma de pagamento? " +
                            "\n 1 - Bolteo" +
                            "\n 2 - Sair");
                    int op = Integer.parseInt(in.nextLine());

                    if (op != 2) {
                        gerarBoleto();
                    }
                    System.out.println("Saindo ...");
                    break;
                }
            }
        }
        if (!clienteEncontrado) {
            System.out.println("Cliente não encontrado. Tente novamente.");
        }
    }

    public static void gerarBoleto() {
        Scanner in = new Scanner(System.in);

        System.out.println("Digite seu email para identificação:");
        String email = in.nextLine();

        boolean boletoGerado = false;

        for (Pagamento pag : pagamentos) {
            if (pag.getProduto().toString().contains(email)) {
                boletoGerado = true;
                System.out.println("Data da Compra: " + pag.getBoleto().getDataCompra());
                System.out.println("Data de Vencimento: " + pag.getBoleto().getData_vencimento());
                System.out.println("Valor Total da Compra: R$" + pag.getBoleto().getValorCompra());
                break;
            }
        }

        if (!boletoGerado) {
            System.out.println("Boleto não encontrado para esse cliente.");
        }
    }

    private static void exibirInformacoesBoleto(Boleto boleto) {
        for(Pagamento pag : pagamentos){
        System.out.println("Produto: " + pag.getProduto().toString());
        System.out.println("Data da Compra: " + pag.getBoleto().getDataCompra());
        System.out.println("Data de Vencimento: " + pag.getBoleto().getData_vencimento());
        System.out.println("Valor: R$" + pag.getBoleto().getValorCompra());
        System.out.println("----");
    }
}
    private static boolean isBoletoVencido(Boleto boleto) {
        return boleto.getData_vencimento().isBefore(boleto.getDataCompra());
    }

    private static void calcularParcelas() {
        Scanner in = new Scanner(System.in);

        for (Boleto boleto : boletos) {

            exibirInformacoesBoleto(boleto);

            if (!isBoletoVencido(boleto)) { 
                System.out.println("Boleto não Vencido\n---------------");

                double valorTotal = boleto.getPagamentos().stream()
                        .mapToDouble(pagamento -> pagamento.getProduto().getValorProduto())
                        .sum();

                System.out.println("Valor total da compra é de R$ " + String.format("%.2f", valorTotal));

                System.out.println("Deseja Parcelar em quantas vezes ? ");
                short numParcelas = (short) Integer.parseInt(in.nextLine());
                boleto.setNumParcelas(numParcelas);

                double valorParcela = boleto.getValorCompra() / boleto.getNumParcelas();

                for (int parcela = 1; parcela <= boleto.getNumParcelas(); parcela++) {
                    boleto.setData_vencimento(boleto.getData_vencimento().plusMonths(1));

                    System.out.println("Número de Parcelas: " + parcela + "x vezes "
                            + boleto.getData_vencimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                            + " do mês " + parcela);

                }

                System.out.println("Valor Parcelado em " + boleto.getNumParcelas() + "x vezes de R$" + valorParcela);

            } else {
                System.out.println("Boleto Vencido - URGENTE");
                double valorComJuros = boleto.getValorCompra() * 1.05; 
                double valorParcelaComJuros = valorComJuros / boleto.getNumParcelas();

                for (int parcela = 1; parcela <= boleto.getNumParcelas(); parcela++) {
                    boleto.setData_vencimento(boleto.getData_vencimento().plusMonths(1));

                    System.out.println("Número de Parcelas: " + parcela + "x vezes "
                            + boleto.getData_vencimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                            + " do mês " + parcela);
                }

                System.out.println("Valor Parcelado em " + boleto.getNumParcelas() + "x vezes de R$" + valorParcelaComJuros);
                System.out.println("Valor Total com Juros: R$" + valorComJuros);
            }
        }
    }

    public static void pagarBoleto() {
        Scanner in = new Scanner(System.in);

        System.out.println("Digite seu email para identificação:");
        String email = in.nextLine();

        boolean boletoPago = false;

        for (Pagamento pag : pagamentos) {
            if (pag.getProduto().toString().contains(email)) {
                System.out.println("Pagando o boleto...");
                System.out.println("Produto: " + pag.getProduto().toString());
                System.out.println("Valor do Boleto: R$" + pag.getBoleto().getValorCompra());
                System.out.println("Data de Vencimento: " + pag.getBoleto().getData_vencimento());

                System.out.println("Boleto pago com sucesso!");
                boletoPago = true;
                break;
            }
        }

        if (!boletoPago) {
            System.out.println("Não foi encontrado boleto pendente para esse cliente.");
        }
    }

}
