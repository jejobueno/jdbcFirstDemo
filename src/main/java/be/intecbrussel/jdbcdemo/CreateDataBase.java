package be.intecbrussel.jdbcdemo;

import java.sql.*;

public class CreateDataBase {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost?serverTimezone=UTC";
    static final String CREATE_TABLE_SQL="CREATE TABLE beersdb.beers ("
            + "ID INT NOT NULL AUTO_INCREMENT,"
            + "NAME VARCHAR(45) NOT NULL,"
            + "ALCOHOL DOUBLE NOT NULL,"
            + "PRICE DOUBLE NOT NULL,"
            + "STOCK INT NOT NULL,"
            + "PRIMARY KEY (ID))";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //Execute a query
            System.out.println("Creating database...");
            stmt = conn.createStatement();

            String sql = "CREATE DATABASE beersdb";
            //stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");

            stmt.executeUpdate(CREATE_TABLE_SQL);
            System.out.println("Table created");

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Have A Nice Day");
    }
}