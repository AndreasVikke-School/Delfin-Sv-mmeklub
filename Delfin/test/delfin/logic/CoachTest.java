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
 * @author Celina
 */
public class CoachTest {

    @Test
    public void createCoachTest(){
        ActivityInfo info = new ActivityInfo("1705981598", StatusEnum.ACTIVE, TeamEnum.JUNIOR, ActivityEnum.COMPETITIOR);
        Coach c = new Coach("1705981598", "Anna Kofoed", "Dildhaven 9, 2730 Herlev", "17725889", info);
        assertNotNull(c);
        assertNotNull(c.getSsn());
        assertNotNull(c.getName());
        assertNotNull(c.getAddress());
        assertNotNull(c.getPhone());
        assertNotNull(c.getActivityInfo());
        assertNotNull(c.getAge());
        assertSame(c.getSsn(), c.getId());
        assertEquals(c.getSsn().length(), 10);
        assertEquals(c.getPhone().length(), 8);
        assertEquals(c.getAge(), 20);
        assertEquals(c.getName(), "Anna Kofoed");
        assertNotEquals(c.getAddress(), "Bølgehaven 5, 2730 Ravnsborg");
        
    }
}
