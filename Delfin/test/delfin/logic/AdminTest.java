package delfin.logic;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andreas Vikke
 */
public class AdminTest {
    
    @Test
    public void createAdminTest() {
        Admin admin = new Admin("0911920777", "Martin", "Skodsborgvej 190 2850 Nærum", "12345678", new ActivityInfo("0911920777", StatusEnum.ACTIVE, TeamEnum.SENIOR, ActivityEnum.EXERCISER));
        assertNotNull(admin);
        assertEquals("0911920777", admin.getSsn());
        assertEquals("Martin", admin.getName());
        assertEquals("Skodsborgvej 190 2850 Nærum", admin.getAddress());
        assertEquals("12345678", admin.getPhone());
    }
}
