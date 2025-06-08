import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaDAO {
    private Connection conn;
    
    public Connection connectDB() {
        try {
            // URL de conexão com o banco uc11
            String url = "jdbc:mysql://localhost:3306/uc11?useSSL=false" +
                        "&allowPublicKeyRetrieval=true" +
                        "&serverTimezone=UTC" +
                        "&autoReconnect=true";
            
            // Credenciais de acesso
            String user = "root";
            String password = "v1e2r3a4";
            
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão estabelecida com sucesso!");
            return conn;
            
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco uc11: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    // Método para fechar a conexão (opcional, mas recomendado)
    public void disconnectDB() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexão encerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar conexão: " + e.getMessage());
        }
    }
}