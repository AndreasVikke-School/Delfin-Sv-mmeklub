/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin.logic;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nina
 */
public class CashierTest {

    @Test
    public void createCashierTest(){
        Cashier cashier = new Cashier("0102907654", "Tine", "Nørgaardsvej 30 2800 Kongens Lyngby", "29384756", new ActivityInfo("0102907654", StatusEnum.ACTIVE, TeamEnum.SENIOR, ActivityEnum.EXERCISER));
        assertNotNull(cashier);
        assertEquals("0102907654", cashier.getSsn());
        assertEquals("Tine", cashier.getName());
        assertEquals("Nørgaardsvej 30 2800 Kongens Lyngby", cashier.getAddress());
        assertEquals("29384756", cashier.getPhone());
    }
}
