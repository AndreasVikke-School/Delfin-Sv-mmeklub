package delfin.data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import delfin.data.DataAccessor;
import delfin.logic.ActivityInfo;
import delfin.logic.Member;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Celina og Nina
 */
public class DataAccessorTest {
    
    private DataAccessor da;
    
    public DataAccessorTest() throws SQLException {
        da = new DataAccessor(new DBConnector());
    }
    
    @Test
    public void testGetMembers() {
        try {
            List<Member> members = da.getMembers();
            assertNotNull(members);
            
            int expected = 0;
            int actual = members.size();
            assertEquals(expected, actual);
            
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    /**
     * Test of getSsn method, of class DataAccessor.
     */
   /* @Test
    public void testGetSsn() {
        try {
            Member member = da.getSsn(ssn);
            assertNotNull(member);
            assertEquals(member.getName(), "");
            
                   
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }
*/
    /**
     * Test of createMember method, of class DataAccessor.
     */
    @Test
    public void testCreateMember() {
        System.out.println("createMember");
        String ssn = "";
        String name = "";
        String address = "";
        String phone = "";
        ActivityInfo info = null;
        DataAccessor instance = null;
        instance.createMember(ssn, name, address, phone, info);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
