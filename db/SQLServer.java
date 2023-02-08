package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLServer implements IBaseDatos {
    private static Connection connection = null;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    @Override
    public Connection connect(){
        String service = "sqlserver";
        String host = "localhost";
        int port = 1433;
        String user = "sa";
        String password = "1234";
        String database = "master";

        try {
            String url = String.format("jdbc:%s://%s:%d;DatabaseName=%s;encrypt=true;trustServerCertificate=true;", service, host, port, database);
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Error: " +e);
        } catch (Exception e){
            System.out.println("Error: " +e);
        }
        
        return connection;
    }

    @Override
    public void read(){
        try {
            preparedStatement = connection.prepareCall("SELECT name FROM master.dbo.sysdatabases");
            resultSet = preparedStatement.executeQuery();
            System.out.println("| DATABASES |");
            while(resultSet.next()){
                System.out.print("-------------\n  " + resultSet.getString(1) + "  \n");
            }
        } catch (SQLException e) {
            System.out.println("Error: " +e);
        }
    }

    @Override
    public void disconnect(){
        //cerramos conexion
        try {
            resultSet.close();
            preparedStatement.close();
            connection.close();
            System.out.println("-------------------------------------\nConexion cerrada de manera exitosa\n-------------------------------------");
        } catch (SQLException e) {
            System.out.println("Error: " +e);
        }
    }

    
}
