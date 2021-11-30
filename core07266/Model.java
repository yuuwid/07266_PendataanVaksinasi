package core07266;

import java.sql.*;
import helper07266.Database07266;

public abstract class Model {
    /* Database Connection Requirements */
    protected Connection conn;
    protected ResultSet rs;
    protected PreparedStatement pstmt;
    protected Statement stmt;

    /* String untuk proses execute Query */
    protected String query;
    protected String sql;

    /* Method getConnection Database */
    protected Connection connect(){
        conn = Database07266.getConnection();
        return conn;
    }
}
