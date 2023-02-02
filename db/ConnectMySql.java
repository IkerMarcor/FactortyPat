package db;

public class ConnectMySql implements DB {
    public void connect(){
        System.out.println("Connectando a la base de datos de MySql");
    }
    public void read(){
        System.out.println("Leyendo Registro con MySql");
    }
    public void update(){
        System.out.println("Actualizando Registro con MySql");
    }
}
