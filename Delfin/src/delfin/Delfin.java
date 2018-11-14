package delfin;

import delfin.logic.ActivityEnum;
import delfin.logic.ActivityInfo;
import delfin.logic.Member;
import delfin.logic.StatusEnum;
import delfin.logic.TeamEnum;
import delfin.presentation.Menu;

/**
 *
 * @author vikke
 */
public class Delfin {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
    
}
