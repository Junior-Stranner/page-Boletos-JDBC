package Sistema.dao;

import Sistema.Model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            stmt.setString(5, usuario.getDataNascimento());

            stmt.executeUpdate();
            System.out.println("Usuário salvo com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao salvar usuário: " + e.getMessage());
            throw e;
        }
    }

    public ArrayList<Usuario> lerDadosBD() throws SQLException {
        String sql = "SELECT * from usuarios";

        ArrayList<Usuario> usuarios = new ArrayList<>();
        Connection con = null;
        PreparedStatement codigo = null;
        ResultSet dadosBD = null;

        try {
            con = Conexao.conectarBD();
            codigo = con.prepareStatement(sql);
            dadosBD = codigo.executeQuery();

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
        } finally {
            if (codigo != null) {
                codigo.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return usuarios;
    }

}