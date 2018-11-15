package delfin.data;

import delfin.logic.*;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nina Lisakovski
 */
public class DataAccessorQuotansTest {
    
    private DataAccessor da;
    
    public DataAccessorQuotansTest() throws SQLException {
        da = new DataAccessorQuota(new DBConnector());
    }
    
    /**
     * Test of getAll method, of class DataAccessorQuotans.
     */
    @Test
    public void testGetAll() {
        try {
            List<Quota> quotas = (List<Quota>)(Object)da.getAll();
            assertNotNull(quotas);
            
            int expected = 1;
            int actual = quotas.size();
            assertEquals(expected, actual);
            
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    /**
     * Test of getAllById method, of class DataAccessorQuotans.
     */
    @Test
    public void testGetAllById() {
        try {
            List<Quota> quotas = (List<Quota>)(Object)da.getAllById("0407982345");
            assertNotNull(quotas);
            
            int expected = 1;
            int actual = quotas.size();
            assertEquals(expected, actual);

        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    /**
     * Test of getSingleById method, of class DataAccessorQuotans.
     */
    @Test
    public void testGetSingleById() {
       try {
            Quota quotas = (Quota)da.getSingleById("0407982345");
            assertNotNull(quotas);
            assertEquals(quotas.getSsn(), "0407982345");
            assertEquals(quotas.getSubscription(), 24.06, 0.001);
            assertEquals(quotas.getPaid(), 200.00, 0.001); 
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }
}
