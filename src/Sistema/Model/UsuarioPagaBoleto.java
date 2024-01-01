package Sistema.Model;

public class UsuarioPagaBoleto {
    
    private Usuario usuario;
    private Produto produto;
    private Boleto boleto;

public UsuarioPagaBoleto(){
    
}
    
    public UsuarioPagaBoleto(Usuario usuario, Produto produto, Boleto boleto) {
        this.usuario = usuario;
        this.produto = produto;
        this.boleto = boleto;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Boleto getBoleto() {
        return boleto;
    }
    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

    @Override
    public String toString() {
        return "UsuarioPagaBoleto [usuario=" + usuario + ", produto=" + produto + ", boleto=" + boleto + "]";
    }


    
}
