package db;

import java.util.Scanner;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException
    {
        Scanner scanner = new Scanner(System.in);
        Factory conectar = new Factory();
        boolean opcionInv = true;

        System.out.println("Bienvenido al sistema\nSelecciona tu base de datos preferida:\n\n[1] MySQL\n[2] SQLServer");

        while(opcionInv){
            String opcion = scanner.next();

            switch (opcion) {
                case "1":
                    //Conexión a la base de datos con el patrón desarrollado factory
                    IBaseDatos conexionMysql = conectar.ConnectDB(TipoDeConexion.MYSQL);
                    handleConnection(conexionMysql);
                    opcionInv = false;
                    break;
                case "2":
                    //Conexión a la base de datos con el patrón desarrollado factory
                    IBaseDatos conexionSql = conectar.ConnectDB(TipoDeConexion.SQLSERVER);
                    handleConnection(conexionSql);
                    opcionInv = false;
                    break;
                default:
                    System.err.println("-------------------------------\nError: Opción Invalida,\nintentelo de nuevo.\n-------------------------------\nOpciones predefinidas: [1] [2]\n-------------------------------");
                    break;
            }
        }
        //Buenas prácticas se cierra el scanner
        scanner.close();
    }

    public static void handleConnection(IBaseDatos conexion){
        Connection connection = null;

        connection = conexion.connect();
        if (connection != null) {
            System.out.println("-------------------------------------\nSe conecto a la base de forma exitosa\n-------------------------------------");
            conexion.read();
            conexion.disconnect();
        } else {
            System.out.println("No has podido conectarte");
        }
    }
}
