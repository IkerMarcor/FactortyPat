package db;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException
    {
        Scanner scanner = new Scanner(System.in);
        Factory conectar = new Factory();
        boolean opcionInv = true;

        System.out.println("Bienvenido al sistema\nSelecciona tu base de datos preferida:\n\nMySQL -> 1\nSQLServer -> 2");

        while(opcionInv){
            String opcion = scanner.next();

            switch (opcion) {
                case "1":
                    //Conexion a la base de datos MySQL
                    IBaseDatos conexionMySql = conectar.ConnectDB(TipoDeConexion.MYSQL);
                    conexionMySql.connect();
                    conexionMySql.disconnect();
                    opcionInv = false;
                    break;
                case "2":
                    //Conexion a la base de datos SQLServer
                    IBaseDatos conexionSql = conectar.ConnectDB(TipoDeConexion.SQLSERVER);
                    conexionSql.connect();
                    conexionSql.disconnect();
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
}
