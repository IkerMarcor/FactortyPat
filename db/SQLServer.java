package db;

public class SQLServer implements IBaseDatos {
    //TODO: Implementar cada método para que funcione con la base de datos SQLSERVER
    @Override
    public void connect(){
        System.out.println("Conectando a la base de datos Sql");
    }

    @Override
    public void disconnect(){
        System.out.println("Desconectando a la base de datos Sql");
    }

    @Override
    public void read(){
        System.out.println("Leyendo Registro con Sql");
    }
}
