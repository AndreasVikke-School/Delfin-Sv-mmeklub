package delfin.logic;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Martin Frederiksen
 */
public class MemberTest {

    @Test
    public void createMemberTest(){
        ActivityInfo info = new ActivityInfo(StatusEnum.ACTIVE, TeamEnum.JUNIOR, ActivityEnum.COMPETITIOR);
        Member m = new Member("0911920777", "Martin Frederiksen", "Skodsborgvej 190, 2850 Nærum", "61462577", info);
        assertNotNull(m);
        assertNotNull(m.getSsn());
        assertNotNull(m.getName());
        assertNotNull(m.getAddress());
        assertNotNull(m.getPhone());
        assertNotNull(m.getInfo());
        assertNotNull(m.getAge());
        assertSame(m.getSsn(), m.getId());
        assertEquals(m.getSsn().length(), 10);
        assertEquals(m.getPhone().length(), 8);
        assertEquals(m.getAge(), 26);
        assertEquals(m.getName(), "Martin Frederiksen");
        assertNotEquals(m.getAddress(), "Bølgehaven 5, 2730 Ravnsborg");    
    }
}
