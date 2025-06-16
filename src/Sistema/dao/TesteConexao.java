package Sistema.dao;

import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        try {
            Connection conn = Conexao.conectarBD();
            if (conn != null) {
                System.out.println("Conectado com sucesso!");
                Conexao.fecharConexao();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

