package Sistema.Controll;

import Sistema.Model.Usuario;
import Sistema.dao.UsuarioDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UsuarioController {

    public static void usuarioTeste(List<Usuario> usuarios) {
        Usuario novoUsuario = new Usuario("Junior", "jujuba@outlook.com", "123", Usuario.gerarCpf(), "21/10/2000");
        usuarios.add(novoUsuario);
        System.out.println("Usuário de teste criado com sucesso!");
    }


    public static void cadastrarUsuario(List<Usuario> usuarios) {
        Scanner in = new Scanner(System.in);

        System.out.print("Digite o nome: ");
        String nome = in.nextLine();

        System.out.print("Seu o CPF/CNPJ: "+Usuario.gerarCpf()+"\n");
        String cpf_cnpj = Usuario.gerarCpf();

        System.out.print("Digite a senha: ");
        String senha = in.nextLine();

        System.out.print("Digite o email: ");
        String email = in.nextLine();

        System.out.print("Digite a data de nascimento (dd/mm/aaaa): ");
        String dataNascimento = in.nextLine();

        Usuario novoUsuario = new Usuario(nome, cpf_cnpj, senha, email, dataNascimento);
        usuarios.add(novoUsuario);
        System.out.println("Usuário cadastrado com sucesso!");
         UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {
           usuarioDAO.salvarUsuario(novoUsuario);
        } catch (SQLException e) {
           System.out.println("Erro ao salvar no banco: " + e.getMessage());
         }
    }

   public static void mostraUsuarios() {
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    try {
        ArrayList<Usuario> usuarios = usuarioDAO.lerDadosBD();

        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário encontrado no banco de dados.");
        } else {
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }
        }

    } catch (SQLException e) {
        System.out.println("Erro ao ler usuários do banco: " + e.getMessage());
    }
}


    public static void atualizarUsuario() {
    Scanner in = new Scanner(System.in);
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    System.out.print("Digite o ID do usuário que deseja alterar: ");
    int id = Integer.parseInt(in.nextLine());

    try {
        ArrayList<Usuario> usuarios = usuarioDAO.lerDadosBD();
        boolean usuarioEncontrado = false;

        for (Usuario usuario : usuarios) {
            if (usuario.getUsuarioId() == id) {
                usuarioEncontrado = true;

                System.out.println("Olá " + usuario.getNome() + ", o que deseja alterar?");
                System.out.println("1 - Nome de Usuário\n2 - Senha");

                int op = Integer.parseInt(in.nextLine());

                if (op == 1) {
                    System.out.print("Digite o novo nome de usuário: ");
                    String novoNome = in.nextLine();
                    usuario.setNome(novoNome);

                } else if (op == 2) {
                    System.out.print("Digite a nova senha: ");
                    String novaSenha = in.nextLine();
                    usuario.setSenha(novaSenha);

                } else {
                    System.out.println("Opção inválida.");
                    return;
                }

                usuarioDAO.alterarUsuario(usuario); 
                System.out.println("Usuário atualizado com sucesso!");
                break;
            }
        }

        if (!usuarioEncontrado) {
            System.out.println("Usuário com ID " + id + " não encontrado.");
        }

    } catch (SQLException e) {
        System.out.println("Erro ao atualizar usuário: " + e.getMessage());
    }
}


  public static void deletarUsuario() {
    Scanner in = new Scanner(System.in);
    System.out.print("Digite o CPF/CNPJ do usuário que deseja deletar: ");
    String cpf_cnpj = in.nextLine();

    Usuario usuario = new Usuario();
    usuario.setCpf_cnpj(cpf_cnpj);

    UsuarioDAO usuarioDAO = new UsuarioDAO();

    try {
        usuarioDAO.deletarUsuarioBD(usuario);
    } catch (SQLException e) {
        System.out.println("Erro ao deletar usuário: " + e.getMessage());
    }
}

}
