package Sistema.Model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Boleto {
    private int boletoId;
    private String codigo_barras;
    private float valor;
    private LocalDateTime data_vencimento;
    private LocalDateTime data_pagamento;
    private Status status;
    private Cliente clienteId;
    private List<Pagamento> pagamentos;  // Lista de pagamentos relacionados a este boleto

    public Boleto() {
    }

    public Boleto(int boletoId, String codigo_barras, float valor, LocalDateTime data_vencimento, LocalDateTime data_pagamento, Status status, List<Pagamento> pagamentos) {
        this.boletoId = boletoId;
        this.codigo_barras = codigo_barras;
        this.valor = valor;
        this.data_vencimento = data_vencimento;
        this.data_pagamento = data_pagamento;
        this.status = status;
        this.pagamentos = pagamentos;
    }

    public int getBoletoId() {
        return boletoId;
    }

    public void setBoletoId(int boletoId) {
        this.boletoId = boletoId;
    }

    public String getCodigo_barras() {
        return codigo_barras;
    }

    public void setCodigo_barras(String codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public LocalDateTime getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(LocalDateTime data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public LocalDateTime getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(LocalDateTime data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "Boleto{" +
                "boletoId=" + boletoId +
                ", codigo_barras='" + codigo_barras + '\'' +
                ", valor=" + valor +
                ", data_vencimento=" + data_vencimento +
                ", data_pagamento=" + data_pagamento +
                ", status=" + status +
                ", clienteId=" + clienteId +
                ", pagamentos=" + pagamentos +
                '}';
    }
}
