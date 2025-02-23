package Sistema.Model;


import java.util.Random;

public class Usuario {

    private static short contadorId = 1;
    private short usuarioId;
    private String nome;
    private String email;
    private String senha;
    private String cpf_cnpj;
    private String dataNascimento;

    public Usuario(String nome, String email, String senha, String cpf_cnpj, String dataNascimento) {
        this.usuarioId = contadorId++;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf_cnpj = cpf_cnpj;
        this.dataNascimento = dataNascimento;
    }

    public short getUsuarioId(){
        return usuarioId;
    }

    public Usuario() {
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
        if (cpf_cnpj == null || cpf_cnpj.length() < 12) {
            this.cpf_cnpj = gerarCpf();
        } else {
            this.cpf_cnpj = cpf_cnpj;
        }
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setUsuarioId(short usuarioId) {
        this.usuarioId = usuarioId;
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

        public static String gerarCpf() {
            Random random = new Random();

            int[] cpf = new int[9];
            for (int i = 0; i < 9; i++) {
                cpf[i] = random.nextInt(10);
            }

            // Calcula o primeiro dígito verificador
            int digito1 = calcularDigitoVerificador(cpf, 10);
            // Calcula o segundo dígito verificador
            int digito2 = calcularDigitoVerificador(cpf, 11);

            return String.format("%d%d%d.%d%d%d.%d%d%d-%d%d", cpf[0], cpf[1], cpf[2], cpf[3], cpf[4], cpf[5], cpf[6], cpf[7], cpf[8], digito1, digito2);
        }

        private static int calcularDigitoVerificador(int[] cpf, int peso) {
            int soma = 0;
            for (int i = 0; i < cpf.length; i++) {
                soma += cpf[i] * peso--;
                if (peso == 1) break;
            }
            int resto = soma % 11;

            if (resto < 2) {
                return 0;
            } else {
                return 11 - resto;
            }
    }

}
