package Sistema.Controll;

import Sistema.Model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UsuarioController {

    private final List<Usuario> usuarios = new ArrayList<>();


    public static void usuarioTeste(List<Usuario> usuarios, Usuario usuario) {
        Usuario novoUsuario = new Usuario(
                "Junior",
                usuario.getCpf_cnpj(),
                "123",
                "abelinha@gmail.com",
                "21/10/2000"
        );
        usuarios.add(novoUsuario);
    }

    public static void cadastrarUsuario(List<Usuario> usuarios) {
        Scanner in = new Scanner(System.in);

        System.out.print("Digite o nome: ");
        String nome = in.nextLine();

        System.out.print("Digite o CPF/CNPJ: ");
        String cpf_cnpj = in.nextLine();

        System.out.print("Digite a senha: ");
        String senha = in.nextLine();

        System.out.print("Digite o email: ");
        String email = in.nextLine();

        System.out.print("Digite a data de nascimento (dd/mm/aaaa): ");
        String dataNascimento = in.nextLine();

        Usuario novoUsuario = new Usuario(nome, cpf_cnpj, senha, email, dataNascimento);
        usuarios.add(novoUsuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    public static void mostraUsuarios(List<Usuario> usuarios) {
       for(Usuario usuario : usuarios){
           System.out.println(usuario.toString());
       }
    }

    public static void atualizarUsuario(List<Usuario> usuarios) {
        Scanner in = new Scanner(System.in);

        // Solicita o email do usuário
        System.out.println("Digite o email do Usuário");
        String email = in.nextLine();

        if (email.contains("@") && email.endsWith(".com")) {
            boolean usuarioEncontrado = false;

            for (Usuario usuario : usuarios) {
                if (usuario.getEmail().equals(email)) {
                    usuarioEncontrado = true;
                    System.out.println("Olá " + usuario.getNome() + ", O que deseja alterar?");
                    System.out.println("1 - Nome de Usuário" +
                            "\n2 - Senha");

                    int op = Integer.parseInt(in.nextLine());

                    if (op == 1) {
                        System.out.println("Digite o novo nome de usuário:");
                        String novoNome = in.nextLine();
                        usuario.setNome(novoNome);
                        System.out.println("Nome atualizado com sucesso!");

                        // Alteração de senha
                    } else if (op == 2) {
                        System.out.println("Digite a nova senha:");
                        String novaSenha = in.nextLine();
                        usuario.setSenha(novaSenha);
                        System.out.println("Senha atualizada com sucesso!");

                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                }
            }
            if (!usuarioEncontrado) {
                System.out.println("Usuário com o email " + email + " não encontrado.");
            }
        } else {
            System.out.println("Email inválido. O email deve conter '@' e terminar com '.com'.");
        }
    }


    public static void deletarUsuario(List<Usuario> usuarios, String cpf_cnpj) {
        boolean usuarioDeletado = false;

        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);

            if (usuario.getCpf_cnpj().equals(cpf_cnpj)) {
                usuarios.remove(i);
                usuarioDeletado = true;
                System.out.println("Usuário com CPF/CNPJ " + cpf_cnpj + " deletado com sucesso.");
                break;
            }
        }
        if (!usuarioDeletado) {
            System.out.println("Usuário com CPF/CNPJ " + cpf_cnpj + " não encontrado.");
        }
    }
}
