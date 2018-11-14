package delfin.logic;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andreas Vikke
 */
public class QuotaTest {
    
    @Test
    public void testGetSsn() {
        Quota r = new Quota("0911920777", 1600, 800, new Member(null,null,null,null,null));
        assertNotNull(r);
        assertNotNull(r.getSsn());
        assertNotNull(r.getSubscription());
        assertNotNull(r.getPaid());
        assertEquals(r.getSubscription(), 1600, 0.001);
        assertEquals(r.getPaid(), 800, 0.001);
    }
    
}
