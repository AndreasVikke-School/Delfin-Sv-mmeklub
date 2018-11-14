package delfin.logic;

import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nina Lisakovski
 */
public class ResultTest {
    
    @Test
    public void testGetSsn() {
        Result r = new Result("0911920777", LocalDate.now(), 10.02, 0, null, new Member(null,null,null,null,null));
        assertNotNull(r);
        assertNotNull(r.getSsn());
        assertNotNull(r.getDate());
        assertNotNull(r.getTime());
        assertNotNull(r.getPlacement());
        assertSame(r.getSsn(), "0911920777");
        assertEquals(r.getSsn().length(), 10);
        assertEquals(r.getDate(), LocalDate.now());
        assertNotEquals(r.getTime(), 10.03); 
    }
    
}
