/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin.data;

import delfin.logic.ActivityEnum;
import delfin.logic.ActivityInfo;
import delfin.logic.StatusEnum;
import delfin.logic.TeamEnum;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vikke
 */
public class DataAccessorActivityInfoTest {
    
    private DataAccessor da;
    
    public DataAccessorActivityInfoTest() throws SQLException {
        da = new DataAccesorMember(new DBConnector());
    }
    
    @Test
    public void testGetActivityInfos() {
        try {
            List<ActivityInfo> activityInfos = (List<ActivityInfo>)(Object)da.getAll();
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
            ActivityInfo activityInfo = (ActivityInfo)da.getSingleById("0407982345");
            assertNotNull(activityInfo);
            assertEquals(activityInfo.getStatus(), StatusEnum.ACTIVE);
            assertEquals(activityInfo.getTeam(), TeamEnum.SENIOR);
            assertEquals(activityInfo.getActivity(), ActivityEnum.COMPETITIOR);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }
}
