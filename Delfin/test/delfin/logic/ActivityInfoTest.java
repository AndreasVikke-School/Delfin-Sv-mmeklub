package delfin.logic;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andreas Vikke
 */
public class ActivityInfoTest {
    
    @Test
    public void createActivityInfoTest() {
        ActivityInfo activityInfo = new ActivityInfo(StatusEnum.ACTIVE, TeamEnum.SENIOR, ActivityEnum.EXERCISER);
        
        assertNotNull(activityInfo);
        assertNotNull(activityInfo.getStatus());
        assertNotNull(activityInfo.getTeam());
        assertNotNull(activityInfo.getActivity());
        
        assertEquals(StatusEnum.ACTIVE, activityInfo.getStatus());
        assertEquals(TeamEnum.SENIOR, activityInfo.getTeam());
        assertEquals(ActivityEnum.EXERCISER, activityInfo.getActivity());
    }
}
