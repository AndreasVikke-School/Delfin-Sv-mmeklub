package delfin;

import delfin.data.DataAccessorMemberFile;
import delfin.logic.ActivityEnum;
import delfin.logic.ActivityInfo;
import delfin.logic.Member;
import delfin.logic.StatusEnum;
import delfin.logic.TeamEnum;
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
        /*
        DataAccessorMemberFile dAMF = new DataAccessorMemberFile();
        System.out.println(dAMF.getSingleById("2011020223"));
        
        Member m = new Member("0101021322", "Test", "Test", "23135434", new ActivityInfo(StatusEnum.ACTIVE, TeamEnum.SENIOR, ActivityEnum.EXERCISER));
        dAMF.create(m);
*/
    }
}
