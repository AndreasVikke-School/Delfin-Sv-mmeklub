package delfin.logic.controller;

import delfin.data.DBConnector;
import delfin.data.DataAccessorActivityInfo;
import delfin.logic.ActivityEnum;
import delfin.logic.ActivityInfo;
import delfin.logic.StatusEnum;
import delfin.logic.TeamEnum;
import java.util.List;

/**
 *
 * @author Nina Lisakowski
 */
public class ActivityInfoController {
    
    DataAccessorActivityInfo daa = null;
    
    public ActivityInfoController(){
        try{
            daa = new DataAccessorActivityInfo(new DBConnector());
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("Setup fail!");
        }
    }
    
    public List<ActivityInfo> getAllActivityInfo(){
        return (List<ActivityInfo>)(Object)daa.getAll();
    }
    
    public ActivityInfo getSingleActivityInfoById(String ssn){
        return (ActivityInfo)daa.getSingleById(ssn);
    }
    
    public String createActivityInfo(String ssn, StatusEnum status, TeamEnum team, ActivityEnum activity){
        ActivityInfo activityInfo = new ActivityInfo(status, team, activity);
        
        daa.createWithSsn(ssn, activityInfo);
        return ("ActivityInfo created succesfully!");
    }
    
    public String updateActivityInfo(String ssn, StatusEnum status, TeamEnum team, ActivityEnum activity){
        ActivityInfo activityInfo = new ActivityInfo(status, team, activity);
        
        daa.update(ssn, activityInfo);
        return ("ActivityInfo updated succesfully!");
    }
}