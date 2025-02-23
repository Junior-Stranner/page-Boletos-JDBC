package Sistema.Model;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Boleto {
    private static int boletoId;
//    private String codigo_barras;
    private static float valorCompra;
    private static LocalDateTime data_vencimento;
    private static LocalDate dataCompra = LocalDate.now();
    private static short numParcelas;
    private static Cliente clienteId;
    private static List<Pagamento> pagamentos;  // Lista de pagamentos relacionados a este boleto

    public Boleto() {
    }

    public Boleto(float valorCompra, LocalDateTime data_vencimento, LocalDate dataCompra, short numParcelas, Cliente clienteId, List<Pagamento> pagamentos) {
        this.valorCompra = valorCompra;
        this.data_vencimento = data_vencimento;
        this.dataCompra = dataCompra;
        this.numParcelas = numParcelas;
        this.clienteId = clienteId;
        this.pagamentos = pagamentos;
    }

    public void setBoletoId(int boletoId) {
        this.boletoId = boletoId;
    }

    public static float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
    }

    public static LocalDateTime getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(LocalDateTime data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public ChronoLocalDateTime<?> getDataCompra() {
        return dataCompra.atStartOfDay();
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public static short getNumParcelas() {
        return numParcelas;
    }

    public void setNumParcelas(short numParcelas) {
        this.numParcelas = numParcelas;
    }

  /*  public void calcularParcelas() {
        System.out.println("Data da Compra: " + dataCompra.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Data de Vencimento Inicial: " + data_vencimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        double valorComJuros = getValorCompra() * 1.03;
        double valorParcelaComJuros = valorComJuros / getNumParcelas();

        // Variável local para não alterar o valor original de data_vencimento
        LocalDate vencimentoParcela = LocalDate.from(data_vencimento);

        for (int parcela = 1; parcela <= getNumParcelas(); parcela++) {
            vencimentoParcela = vencimentoParcela.plusMonths(1);

            System.out.println("Parcela " + parcela + " de " + getNumParcelas() +
                    " | Vencimento: " + vencimentoParcela.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                    " | Valor da Parcela: R$ " + String.format("%.2f", valorParcelaComJuros));
        }
    }*/

    @Override
    public String toString() {
        return "Boleto{" +
                "boletoId=" + boletoId +
                ", valorCompra=" + valorCompra +
                ", data_vencimento=" + data_vencimento +
                ", data_Compra=" + dataCompra +
                ", numParcelas=" + numParcelas +
                ", clienteId=" + clienteId +
                ", pagamentos=" + pagamentos +
                '}';
    }
}
