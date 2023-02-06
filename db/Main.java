package db;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException
    {
        Factory conectar = new Factory();
        //Conexion a la base de datos MySQL
        IBaseDatos conexionMySql = conectar.ConnectDB(TipoDeConexion.MYSQL);
        conexionMySql.connect();
        conexionMySql.disconnect();

        System.out.println("------------------------------------");

        //Conexion a la base de datos SQLServer
        IBaseDatos conexionSql = conectar.ConnectDB(TipoDeConexion.SQLSERVER);
        conexionSql.connect();
        conexionSql.disconnect();
    }
}
