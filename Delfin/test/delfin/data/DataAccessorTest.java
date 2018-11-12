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
            
            int expected = 1;
            int actual = members.size();
            assertEquals(expected, actual);
            
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    /**
     * Test of getSsn method, of class DataAccessor.
     */
    @Test
    public void testGetMemberBySsn() {
        try {
            Member member = da.getMemberBySsn("1202960495");
            assertNotNull(member);
            assertEquals(member.getName(), "Henning Hansen");
            assertEquals(member.getAge(), 22);
            assertEquals(member.getPhone(), "12345678");
            assertEquals(member.getAddress(), "Digterparken 57, 2750 Ballerup");
            assertEquals(member.getSsn(), "1202960495");
            
                   
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }
    
}
