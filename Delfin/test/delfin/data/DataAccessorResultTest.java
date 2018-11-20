package delfin.data;

import delfin.data.DataAccessor;
import delfin.logic.*;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Celina Dencker & Nina Lisakovski
 */
public class DataAccessorResultTest {
    
    private DataAccessor da;
    
    public DataAccessorResultTest() throws SQLException {
        da = new DataAccessorResult(new DBConnector());
    }
    
    @Test
    public void testGetResults() {
        try {
            List<Result> results = (List<Result>)(Object)da.getAll();
            assertNotNull(results);
            
            int expected = 3;
            int actual = results.size();
            assertEquals(expected, actual);
            
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    /**
     * Test of getSsn method, of class DataAccessor.
     */
    @Test
    public void testGetResultsBySsn() {
        try {
            List<Result> results = (List<Result>)(Object)da.getAllById("0202961234");
            assertNotNull(results);
            
            int expected = 2;
            int actual = results.size();
            assertEquals(expected, actual);
            
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }
    
    @Test
    public void testGetTopFiveInDisciplin() {
        try {
            List<Result> results = (List<Result>)(Object)da.getAllById("0202961234");
            assertNotNull(results);
            
            int expected = 5;
            int actual = 3; 
            assertEquals(expected, actual);
        
        }catch(Exception ex) {
            fail(ex.getMessage());
        }
    }
}
