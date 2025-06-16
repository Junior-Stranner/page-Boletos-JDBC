package Sistema.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {

/*     private static final String PROPRIEDADES = "/db.properties";
    private static Properties propriedades = null;*/

    // Thread-local para evitar conflitos em ambientes multi-thread
    private static final ThreadLocal<Connection> conexaoThread = new ThreadLocal<>();

    private Conexao() {
        // Impede instanciamento
    }

    // Carrega as propriedades uma única vez
  /*   private static void carregarPropriedades() {
            try (InputStream input = Conexao.class.getResourceAsStream(PROPRIEDADES)) {
                if (input == null) {
                    throw new RuntimeException("Arquivo de configuração não encontrado: " + PROPRIEDADES);
                }
                propriedades = new Properties();
                propriedades.load(input);
            } catch (IOException e) {
                throw new RuntimeException("Erro ao carregar as propriedades do banco", e);
         }
    }*/

    public static Connection conectarBD() {
        try {
            Connection conn = conexaoThread.get();
            if (conn == null || conn.isClosed()) {
            //    carregarPropriedades();
                String url = "jdbc:postgresql://localhost:5432/page-boleto"; 
                String user = "postgres";
                String password = "123";

                conn = DriverManager.getConnection(url, user, password);
                conexaoThread.set(conn);
                
                System.out.println("Conexão estabelecida com sucesso.");
            }
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException("Falha ao conectar com o banco de dados: " + e.getMessage(), e);
        }
    }

    public static void fecharConexao() {
        Connection conn = conexaoThread.get();
        if (conn != null) {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                    System.out.println("Conexão fechada com sucesso.");
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            } finally {
                conexaoThread.remove();
            }
        }
    }
}
