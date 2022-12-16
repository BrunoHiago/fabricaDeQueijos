package conectionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author bruno
 */
public class ConexaoBD {
    public static Connection getConexao(){
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/trbfinal","root","123456789");
        } catch (SQLException ex) {
            Logger.getLogger("Erro ao conectar: "+ex.toString());
        }
        
        return conexao;
    }
}
