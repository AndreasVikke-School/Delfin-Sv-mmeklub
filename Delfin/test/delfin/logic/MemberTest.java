package delfin.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Martin Frederiksen & Celina Dencker
 */
public class MemberTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createMemberTest(){
        ActivityInfo info = new ActivityInfo("0911920777", StatusEnum.ACTIVE, TeamEnum.JUNIOR, ActivityEnum.COMPETITIOR);
        Member m = new Member("0911920777", "Martin Frederiksen", "Skodsborgvej 190, 2850 Nærum", "61462577", info);
        assertNotNull(m);
        assertNotNull(m.getSsn());
        assertNotNull(m.getName());
        assertNotNull(m.getAddress());
        assertNotNull(m.getPhone());
        assertNotNull(m.getActivityInfo());
        assertNotNull(m.getAge());
        assertSame(m.getSsn(), m.getId());
        assertEquals(m.getSsn().length(), 10);
        assertEquals(m.getPhone().length(), 8);
        assertEquals(m.getAge(), 26);
        assertEquals(m.getName(), "Martin Frederiksen");
        assertNotEquals(m.getAddress(), "Bølgehaven 5, 2730 Ravnsborg");    
    }

    /**
     * Test of getId method, of class Member.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Member instance = null;
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSsn method, of class Member.
     */
    @Test
    public void testGetSsn() {
        System.out.println("getSsn");
        Member instance = null;
        String expResult = "";
        String result = instance.getSsn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAge method, of class Member.
     */
    @Test
    public void testGetAge() {
        System.out.println("getAge");
        Member instance = null;
        int expResult = 0;
        int result = instance.getAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Member.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Member instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class Member.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        Member instance = null;
        String expResult = "";
        String result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPhone method, of class Member.
     */
    @Test
    public void testGetPhone() {
        System.out.println("getPhone");
        Member instance = null;
        String expResult = "";
        String result = instance.getPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getActivityInfo method, of class Member.
     */
    @Test
    public void testGetActivityInfo() {
        System.out.println("getActivityInfo");
        Member instance = null;
        ActivityInfo expResult = null;
        ActivityInfo result = instance.getActivityInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}