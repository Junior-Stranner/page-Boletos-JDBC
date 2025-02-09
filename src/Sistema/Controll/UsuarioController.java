package Sistema.Controll;

import Sistema.Model.Usuario;

import java.net.StandardSocketOptions;

public class UsuarioController {

    Usuario usuario = new Usuario();

    public static void usuarioTeste(Usuario usuario) {

        usuario.setNome("Junior");
        usuario.setCpf_cnpj("");
    }

    public static void cadastrarUsuario() {
    }

    public static void mostraUsuarios() {
        // Simulação de exibição de dados do usuário
        System.out.println("Mostrando dados do usuário...");
        // Lógica para exibir os dados do usuário
    }

    public static void atualizarUsuario() {
        // Simulação de atualização de dados do usuário
        System.out.println("Atualização de usuário iniciada...");
        // Lógica para atualizar os dados do usuário
    }

    public static void deletarUsuario() {
        // Simulação de exclusão de usuário
        System.out.println("Usuário deletado com sucesso.");
        // Lógica para deletar o usuário
    }


}
