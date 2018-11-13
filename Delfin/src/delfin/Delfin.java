package delfin;

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
