package db;

public class MySQL implements IBaseDatos {
    //TODO: Implementar cada método para que funcione con la base de datos MySQL
    @Override
    public void connect(){
        System.out.println("Conectando a la base de datos MySql");
    }

    @Override
    public void disconnect(){
        System.out.println("Desconectando de la base de datos MySql");
    }

    @Override
    public void read(){
        System.out.println("Leyendo Registro con MySql");
    }

    @Override
    public void update(){
        System.out.println("Actualizando Registro con MySql");
    }
}
