package delfin.data;

/**
 *
 * @author vikke
 */
public class DataAccessor {
    
    private DBConnector connector = null;

    public DataAccessor(DBConnector connector) {
        this.connector = connector;
    }
}
