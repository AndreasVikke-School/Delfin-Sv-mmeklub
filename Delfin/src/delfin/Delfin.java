package delfin;

import delfin.logic.ActivityEnum;
import delfin.logic.ActivityInfo;
import delfin.logic.StatusEnum;
import delfin.logic.controller.MemberFileController;
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
        
        /*MemberFileController mfc = new MemberFileController();
        //mfc.createMember("0101011113", "Bjørnen", "Bjørnehuse 13", "00001111", ActivityEnum.COMPETITIOR.toString(), StatusEnum.ACTIVE.toString());
        System.out.println(mfc.getAllMembers());
        System.out.println(mfc.getSingleMember("0101011113"));
        System.out.println(mfc.getSubscriptionPrice(mfc.getAllMembers(), "0101011113"));
        
        //mfc.updateMember("0101011111", "Bjørnen", "Bjørnehuse 13", "00001112", ActivityEnum.COMPETITIOR.toString(), StatusEnum.ACTIVE.toString());
        */
    }
}
