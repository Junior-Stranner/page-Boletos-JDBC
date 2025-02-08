package Sistema.Model;


public class Usuario {

    private short usuarioId;
    private String nome;
    private String email;
    private String senha;
    private String cpf_cnpj;
    private String dataNascimento;
    private TipoUsuario tipoUsuario = TipoUsuario.CLIENTE;

    public Usuario() {
    }

    public Usuario(short usuarioId, String nome, String email, String senha, String cpf_cnpj, String dataNascimento) {
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf_cnpj = cpf_cnpj;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuarioId=" + usuarioId +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", cpf_cnpj='" + cpf_cnpj + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                '}';
    }
}
