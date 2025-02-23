package Sistema.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class Conexao {

    private static Connection conexao = null;
    private static final String PROPRIEDADES = "/db.properties";

    private Conexao() { }

    public static Connection conectarBD() {
        if (conexao == null) {
            try (InputStream input = Conexao.class.getResourceAsStream(PROPRIEDADES)) {
                Properties prop = new Properties();
                prop.load(input);

                String url = prop.getProperty("db.url");
                String user = prop.getProperty("db.user");
                String password = prop.getProperty("db.password");

                conexao = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.err.println("ERRO: Conexão com o banco de dados falhou: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("ERRO: Não foi possível carregar as propriedades do banco: " + e.getMessage());
            }
        }
        return conexao;
    }
}
