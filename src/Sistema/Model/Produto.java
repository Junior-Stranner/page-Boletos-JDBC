package Sistema.Model;

public class Produto {
    
    private String nomeProduto;
    private String numProduto;
    private double valorProduto;

    public Produto(){

    }
    

    public Produto(String nomeProduto, String numProduto, double valorProduto) {
        this.nomeProduto = nomeProduto;
        this.numProduto = numProduto;
        this.valorProduto = valorProduto;
    }



    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNumProduto() {
        return numProduto;
    }

    public void setNumProduto(String numProduto) {
        this.numProduto = numProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    
}
