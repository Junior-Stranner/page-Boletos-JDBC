package Sistema.Model;

import Sistema.Model.Boleto;
import Sistema.Model.MetodoPagamento;

import java.time.LocalDateTime;

public class Pagamento {
    private short pagId;
    private double valorPago;
    private LocalDateTime dataPagamento;
    private MetodoPagamento metodoPagamento;
    private Boleto boleto; // Referência direta ao objeto Boleto
    private short clienteId;
    private Status status;

    public Pagamento() {
    }

    public Pagamento(short pagId, double valorPago, LocalDateTime dataPagamento, MetodoPagamento metodoPagamento, Boleto boleto, Status status) {
        this.pagId = pagId;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.metodoPagamento = metodoPagamento;
        this.boleto = boleto;
        this.status = status;
    }

    public short getPagId() {
        return pagId;
    }

    public void setPagId(short pagId) {
        this.pagId = pagId;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public Boleto getBoleto() {
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "pagId=" + pagId +
                ", valorPago=" + valorPago +
                ", dataPagamento=" + dataPagamento +
                ", metodoPagamento=" + metodoPagamento +
                ", boleto=" + boleto + // Exibindo objeto boleto
                ", clienteId=" + clienteId +
                ", status=" + status +
                '}';
    }
}
