package delfin.logic;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vikke
 */
public class AdminTest {
    
    public AdminTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void createAdminTest() {
        Admin admin = new Admin("0911920777", "Martin", "Skodsborgvej 190 2850 Nærum", "12345678", new ActivityInfo(StatusEnum.ACTIVE, TeamEnum.SENIOR, ActivityEnum.EXERCISEIST));
        assertNotNull(admin);
        assertEquals("0911920777", admin.getSsn());
        assertEquals("Martin", admin.getName());
        assertEquals("Skodsborgvej 190 2850 Nærum", admin.getAddres());
        assertEquals("12345678", admin.getPhone());
        assertEquals(StatusEnum.ACTIVE, admin.getActivityInfo().getStatus());
        assertEquals(TeamEnum.SENIOR, admin.getActivityInfo().getTeam());
        assertEquals(ActivityEnum.EXERCISEIST, admin.getActivityInfo().getActivity());
    }
}
