package delfin.logic;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Celina Dencker
 */
public class CoachTest {

    @Test
    public void createCoachTest(){
        ActivityInfo info = new ActivityInfo(StatusEnum.ACTIVE, TeamEnum.JUNIOR, ActivityEnum.COMPETITIOR);
        Coach c = new Coach("1705981598", "Anna Kofoed", "Dildhaven 9, 2730 Herlev", "17725889", info);
        assertNotNull(c);
        assertNotNull(c.getSsn());
        assertNotNull(c.getName());
        assertNotNull(c.getAddress());
        assertNotNull(c.getPhone());
        assertNotNull(c.getActivityInfo());
        assertNotNull(c.getAge());
        assertSame(c.getSsn(), c.getId());
        assertEquals(c.getSsn().length(), 10);
        assertEquals(c.getPhone().length(), 8);
        assertEquals(c.getAge(), 20);
        assertEquals(c.getName(), "Anna Kofoed");
        assertNotEquals(c.getAddress(), "Bølgehaven 5, 2730 Ravnsborg");
        
    }
}
