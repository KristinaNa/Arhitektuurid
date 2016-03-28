
package packages.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;

public class db_connect {
    //static Logger logger = Logger.getLogger(dbconnection.class);

    public db_connect() {
    }

    public static Connection getConnection() {
        Connection var0 = null;
        String var1 = "";
        String var2 = "";
        String var3 = "";

        try {
            ResourceBundle var4 = ResourceBundle.getBundle("DBConnection");
            Class.forName(var4.getString("Driver"));
            var3 = var4.getString("url");
            var2 = var4.getString("usr");
            var1 = var4.getString("pwd");
            var0 = DriverManager.getConnection(var3, var2, var1);
        } catch (Exception var5) {
            logger.error("db_connect.getConnection():" + var5.getMessage());
        }

        return var0;
    }

    public static void close(Connection var0) {
        if(var0 != null) {
            try {
                var0.close();
            } catch (SQLException var2) {
                logger.error(var0, var2);
            }
        }

    }

    public static void closeStatement(Statement var0) {
        if(var0 != null) {
            try {
                var0.close();
            } catch (SQLException var2) {
                logger.error(var0, var2);
            }
        }

    }

    public static void closeResultSet(ResultSet var0) {
        if(var0 != null) {
            try {
                var0.close();
            } catch (SQLException var2) {
                logger.error(var0, var2);
            }
        }

    }
}
