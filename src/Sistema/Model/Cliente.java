package Sistema.Model;

public class Cliente {
    private short clienteId;
    private String nome;
    private String cpf_cnpj;
    private String email;
    private String telefone;
    private String endereco;
    private short usuarioId;

    public Cliente(short usuarioId, String nome, String cpf_cnpj, String email) {
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.cpf_cnpj = cpf_cnpj;
        this.email = email;
    }
    public Cliente() {
    }



    public short getClienteId() {
        return clienteId;
    }

    public void setClienteId(short clienteId) {
        this.clienteId = clienteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "clienteId=" + clienteId +
                ", nome='" + nome + '\'' +
                ", cpf_cnpj='" + cpf_cnpj + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                ", usuarioId=" + usuarioId +
                '}';
    }
}
