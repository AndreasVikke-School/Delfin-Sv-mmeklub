package delfin;

import delfin.logic.*;

/**
 *
 * @author vikke
 */
public class Delfin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ActivityInfo info = new ActivityInfo(StatusEnum.ACTIVE, TeamEnum.JUNIOR, ActivityEnum.COMPETITIOR);
        Member m = new Member("0111920777", "Martin Frederiksen", "Skodsborgvej 190 2850 nærum", "61462577", info);
        System.out.println(m.getAge());
        
    }
    
}
