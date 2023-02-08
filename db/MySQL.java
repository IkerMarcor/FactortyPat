package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL implements IBaseDatos {
    private static Connection connection = null;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    @Override
    public Connection connect(){
        String service = "mysql";
        String host = "localhost";
        int port = 3306;
        String user = "root";
        String password = "password";
        String database = "escuela";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = String.format("jdbc:%s://%s:%d/%s", service, host, port, database);
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " +e);
        } catch (Exception e){
            System.out.println("Error: " +e);
        }
        
        return connection;
    }

    @Override
    public void read(){
        //obtenemos los alumnos
        try {
            preparedStatement = connection.prepareCall("SELECT * FROM alumnos");
            resultSet = preparedStatement.executeQuery();
            System.out.println("ID\t\tNOMBRE\t\tAPELLIDO\t\tEDAD");
            while(resultSet.next()){
                System.out.print(resultSet.getInt("id") + "\t\t");
                System.out.print(resultSet.getString("firstName") + "\t\t");
                System.out.print(resultSet.getString("LastName") + "\t\t");
                System.out.print(resultSet.getInt("age") + "\n");
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
