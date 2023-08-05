package Sistema;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class Usuario extends Boleto{
    private String nomeUsuario;
    private int numeroCompra;

    public Usuario(){
        
    }


    public Usuario(LocalDateTime dataAtualHoje, LocalDateTime dataVencimentoBoleto, int numParcelasBoleto,
            double valorCompra, String nomeUsuario, int numeroCompra) {
        this.nomeUsuario = nomeUsuario;
        this.numeroCompra = numeroCompra;
    }
    public Usuario(String nomeUsuario, int numeroCompra) {
        this.nomeUsuario = nomeUsuario;
        this.numeroCompra = numeroCompra;
    }
    public String getNomeUsuario() {
        return nomeUsuario;
    }
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    public int getNumeroCompra() {
        return numeroCompra;
    }
    public void setNumeroCompra(int numeroCompra) {
        this.numeroCompra = numeroCompra;
    }

    
}
