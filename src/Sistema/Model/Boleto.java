package Sistema.Model;

import java.time.LocalDate;

public  class Boleto {

    private LocalDate dataCompra = LocalDate.now();
    private LocalDate dataVencimentoBoleto;
    private int numParcelasBoleto;
    private double valorPagar;

    public Boleto(){
        
    }

    

    public Boleto(LocalDate dataCompra, LocalDate dataVencimentoBoleto, int numParcelasBoleto, double valorPagar) {
        this.dataCompra = dataCompra;
        this.dataVencimentoBoleto = dataVencimentoBoleto;
        this.numParcelasBoleto = numParcelasBoleto;
        this.valorPagar = valorPagar;
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
                + ", numParcelasBoleto=" + numParcelasBoleto + ", valorPagar=" + valorPagar + "]";
    }


    
}
