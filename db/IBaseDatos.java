package db;

public interface IBaseDatos {
    public void connect();
    public void disconnect();
    public void read();
    public void update();
}
