package delfin;

import delfin.presentation.Menu;

/**
 *
 * @author Andreas Vikke, Nina Lisakovski, Martin Frederiksen & Celina Dencker
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
