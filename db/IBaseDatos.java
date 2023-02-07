package db;

import java.sql.Connection;

public interface IBaseDatos {
    public Connection connect();
    public void disconnect();
    public void read();
}
