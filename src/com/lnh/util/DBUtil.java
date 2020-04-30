package com.lnh.util;

import java.sql.*;

/**
 * @author 70888
 */
public class DBUtil {
    public static final String driver="com.mysql.cj.jdbc.Driver";
    public static final String url="jdbc:mysql://localhost:3306/Music?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String username="root";
    public static final String password="200623";
    public static Connection con=null;
    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        if(con==null){
            try {
                con= DriverManager.getConnection(url,username,password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return con;
    }

    public static void release(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
