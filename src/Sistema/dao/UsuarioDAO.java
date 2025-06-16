package Sistema.dao;

import Sistema.Model.Usuario;
import java.sql.*;
import java.util.ArrayList;

public class UsuarioDAO {

    public void salvarUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nome, email, senha, cpf_cnpj, dataNascimento) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = Conexao.conectarBD();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getCpf_cnpj());
            stmt.setDate(5, Date.valueOf(usuario.getDataNascimento()));

            stmt.executeUpdate();
            System.out.println("Usuário salvo com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao salvar usuário: " + e.getMessage());
            throw e;
        }
    }

    public ArrayList<Usuario> lerDadosBD() throws SQLException {
        String sql = "SELECT * FROM usuarios";
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try (Connection con = Conexao.conectarBD();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet dadosBD = stmt.executeQuery()) {

            while (dadosBD.next()) {
                Usuario usuario = new Usuario();
                usuario.setUsuarioId(dadosBD.getShort("idusuario"));
                usuario.setNome(dadosBD.getString("nome"));
                usuario.setEmail(dadosBD.getString("email"));
                usuario.setSenha(dadosBD.getString("senha"));
                usuario.setCpf_cnpj(dadosBD.getString("cpf_cnpj"));
                usuario.setDataNascimento(dadosBD.getString("dataNascimento"));

                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao ler dados dos usuários: " + e.getMessage());
            throw e;
        }

        return usuarios;
    }

    public void alterarUsuario(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuarios SET nome = ? WHERE idusuario = ?";

        try (Connection con = Conexao.conectarBD();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setInt(2, usuario.getUsuarioId());

            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Usuário alterado com sucesso!");
            } else {
                System.out.println("Nenhum usuário encontrado com esse ID.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar usuário: " + e.getMessage());
            throw e;
        }
    }

    public void deletarUsuarioBD(Usuario usuario) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE cpf_cnpj = ?";

        try (Connection con = Conexao.conectarBD();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, usuario.getCpf_cnpj());
            int rowsDeleted = stmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Usuário deletado com sucesso!");
            } else {
                System.out.println("Nenhum usuário encontrado com esse CPF/CNPJ.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao deletar usuário: " + e.getMessage());
            throw e;
        }
    }
}
