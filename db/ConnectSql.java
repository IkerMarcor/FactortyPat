package db;

public class ConnectSql implements DB {
    public void connect(){
        System.out.println("Connectando a la base de datos de Sql");
    }
    public void read(){
        System.out.println("Leyendo Registro con Sql");
    }
    public void update(){
        System.out.println("Actualizando Registro con Sql");
    }
}
