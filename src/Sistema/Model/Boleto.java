package Sistema.Model;

import java.time.LocalDate;

public  class Boleto {

    private LocalDate dataCompra = LocalDate.now();
    private LocalDate dataVencimentoBoleto;
    private int numParcelasBoleto;
    private double valorPagar;
    private double valorJuros;
    private double percentualJuros;

    public Boleto(){
        
    }



    public Boleto(LocalDate dataCompra, LocalDate dataVencimentoBoleto, int numParcelasBoleto, double valorPagar,
            double valorJuros, double percentualJuros) {
        this.dataCompra = dataCompra;
        this.dataVencimentoBoleto = dataVencimentoBoleto;
        this.numParcelasBoleto = numParcelasBoleto;
        this.valorPagar = valorPagar;
        this.valorJuros = valorJuros;
        this.percentualJuros = percentualJuros;
    }



    public double getValorJuros() {
        return valorJuros;
    }



    public void setValorJuros(double valorJuros) {
        this.valorJuros = valorJuros;
    }



    public void setPercentualJuros(double percentualJuros) {
        this.percentualJuros = percentualJuros;
    }



    public double getPercentualJuros() {
        return percentualJuros;
    }



    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public LocalDate getDataVencimentoBoleto() {
        return dataVencimentoBoleto;
    }

    public void setDataVencimentoBoleto(LocalDate dataVencimentoBoleto) {
        this.dataVencimentoBoleto = dataVencimentoBoleto;
    }

    public int getNumParcelasBoleto() {
        return numParcelasBoleto;
    }

    public void setNumParcelasBoleto(int numParcelasBoleto) {
        this.numParcelasBoleto = numParcelasBoleto;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }



    @Override
    public String toString() {
        return "Boleto [dataCompra=" + dataCompra + ", dataVencimentoBoleto=" + dataVencimentoBoleto
                + ", numParcelasBoleto=" + numParcelasBoleto + ", valorPagar=" + valorPagar + ", valorJuros="
                + valorJuros + ", percentualJuros=" + percentualJuros + "]";
    }


    
}
