package db;

public class Factory {

    public IBaseDatos ConnectDB(TipoDeConexion tipoDeConexion) throws NoSuchFieldException {

        return switch (tipoDeConexion) {
            case MYSQL -> new MySQL();
            case SQLSERVER -> new SQLServer();
            default -> throw new NoSuchFieldException("El tipo de conexión no Existe");
        };
    }
}
