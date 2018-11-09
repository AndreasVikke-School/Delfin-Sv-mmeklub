package delfin.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joe
 */
public class MemberTest {
    
    public MemberTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    //Member m = new Member("snn", "name", "adress", "phone", "Ny class");
    @Test
    public void createMemberTest(){
        Member m = new Member("0911920777", "Martin Frederiksen", "Skodsborgvej 190 2850 nærum", "61462577"/*, new Info()*/);
        assertNotNull(m);
        assertEquals(m.getSsn().length(), 10);
        assertEquals(m.getName(), "Martin Frederiksen");
        
    }
}
