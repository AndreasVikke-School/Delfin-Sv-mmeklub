package delfin.data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import delfin.data.DataAccessor;
import delfin.logic.*;
import java.sql.SQLException;
import java.util.List;
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
            Member member = da.getMemberBySsn("0407982345");
            assertNotNull(member);
            assertEquals(member.getName(), "Henning Hansen");
            assertEquals(member.getAge(), 20);
            assertEquals(member.getPhone(), "12345678");
            assertEquals(member.getAddress(), "Test");
            assertEquals(member.getSsn(), "0407982345");
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }
    
    @Test
    public void testGetActivityInfos() {
        try {
            List<ActivityInfo> activityInfos = da.getActivityInfo();
            assertNotNull(activityInfos);
            
            int expected = 1;
            int actual = activityInfos.size();
            assertEquals(expected, actual);
            
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }
    
    @Test
    public void testGetActivityInfoBySsn() {
        try {
            ActivityInfo activityInfo = da.getActivityInfoBySsn("0407982345");
            assertNotNull(activityInfo);
            assertEquals(activityInfo.getStatus(), StatusEnum.ACTIVE);
            assertEquals(activityInfo.getTeam(), TeamEnum.SENIOR);
            assertEquals(activityInfo.getActivity(), ActivityEnum.COMPETITIOR);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }
}
