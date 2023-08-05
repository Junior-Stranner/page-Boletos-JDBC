package Sistema;

import java.util.Date;


public class Boleto {
    private Date dataAtualHoje;
    private Date dataVencimentoBoleto;
    private int numParcelasBoleto;
    private double valorCompra;

    public Boleto(){


    }
    
    public Boleto(Date dataAtualHoje, Date dataVencimentoBoleto, int numParcelasBoleto,
            double valorCompra) {
        this.dataAtualHoje = dataAtualHoje;
        this.dataVencimentoBoleto = dataVencimentoBoleto;
        this.numParcelasBoleto = numParcelasBoleto;
        this.valorCompra = valorCompra;
    }
    public Date getDataAtualHoje() {
        return dataAtualHoje;
    }
    public void setDataAtualHoje(Date dataAtualHoje) {
        this.dataAtualHoje = dataAtualHoje;
    }
    public Date getDataVencimentoBoleto() {
        return dataVencimentoBoleto;
    }
    public void setDataVencimentoBoleto(Date dataVencimentoBoleto) {
        this.dataVencimentoBoleto = dataVencimentoBoleto;
    }
    public int getNumParcelasBoleto() {
        return numParcelasBoleto;
    }
    public void setNumParcelasBoleto(int numParcelasBoleto) {
        this.numParcelasBoleto = numParcelasBoleto;
    }
    public double getValorCompra() {
        return valorCompra;
    }
    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }



}
