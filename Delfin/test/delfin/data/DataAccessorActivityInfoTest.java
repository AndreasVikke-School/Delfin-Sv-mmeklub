package delfin.data;

import delfin.logic.ActivityEnum;
import delfin.logic.ActivityInfo;
import delfin.logic.StatusEnum;
import delfin.logic.TeamEnum;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andreas Vikke
 */
public class DataAccessorActivityInfoTest {
    
    private DataAccessor da;
    
    public DataAccessorActivityInfoTest() throws SQLException {
        da = new DataAccessorMember(new DBConnector());
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
