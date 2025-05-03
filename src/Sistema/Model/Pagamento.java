package Sistema.Model;


public class Pagamento {
    private short pagId;
    private double valorPago;
    private MetodoPagamento metodoPagamento;
    private Boleto boleto;
    private Produto produto;
    private short clienteId;
    private Status status;

    public Pagamento() {
    }

    public Pagamento(double valorPago , MetodoPagamento metodoPagamento, Boleto boleto, Produto produto, short clienteId, Status status) {
        this.valorPago = valorPago;
        this.metodoPagamento = metodoPagamento;
        this.boleto = boleto;
        this.produto = produto;
        this.clienteId = clienteId;
        this.status = status;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public short getClienteId() {
        return clienteId;
    }

    public void setClienteId(short clienteId) {
        this.clienteId = clienteId;
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
                ", metodoPagamento=" + metodoPagamento +
                ", boleto=" + boleto + // Exibindo objeto boleto
                ", clienteId=" + clienteId +
                ", status=" + status +
                '}';
    }
}
