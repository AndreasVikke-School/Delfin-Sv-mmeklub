/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin.logic;

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
public class ActivityInfoTest {
    
    @Test
    public void createActivityInfoTest() {
        ActivityInfo activityInfo = new ActivityInfo("0202961234", StatusEnum.ACTIVE, TeamEnum.SENIOR, ActivityEnum.EXERCISER);
        
        assertNotNull(activityInfo);
        assertNotNull(activityInfo.getStatus());
        assertNotNull(activityInfo.getTeam());
        assertNotNull(activityInfo.getActivity());
        
        assertEquals(StatusEnum.ACTIVE, activityInfo.getStatus());
        assertEquals(TeamEnum.SENIOR, activityInfo.getTeam());
        assertEquals(ActivityEnum.EXERCISER, activityInfo.getActivity());
    }
}
