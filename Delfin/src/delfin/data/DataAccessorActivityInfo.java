package delfin.data;

import delfin.logic.ActivityEnum;
import delfin.logic.ActivityInfo;
import delfin.logic.DomainObject;
import delfin.logic.StatusEnum;
import delfin.logic.TeamEnum;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author Andreas Vikke
 */
public class DataAccessorActivityInfo implements DataAccessor {

    private DBConnector connector = null;

    public DataAccessorActivityInfo(DBConnector connector) {
        this.connector = connector;
    }
    
    @Override
    public List<DomainObject> getAll() {
        try{
            String query = "SELECT * FROM activityinfo;";

            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            List<DomainObject> activityInfos = new ArrayList<>();

            while (rs.next()) {  
                activityInfos.add(new ActivityInfo(StatusEnum.values()[rs.getInt("status")], TeamEnum.values()[rs.getInt("team")], ActivityEnum.values()[rs.getInt("activity")]));
            }
            return activityInfos;       
        }catch (Exception ex) {     
            ex.printStackTrace();
            throw new IllegalArgumentException();
        } 
    }

    @Override
    public List<DomainObject> getAllById(String id) {
        try{
            String query = "SELECT * FROM activityinfo WHERE ssn = '" + id + "';";

            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            List<DomainObject> activityInfos = new ArrayList<>();
            
            while (rs.next()) {
                activityInfos.add(new ActivityInfo(StatusEnum.values()[rs.getInt("status")], TeamEnum.values()[rs.getInt("team")], ActivityEnum.values()[rs.getInt("activity")]));
            }
            return activityInfos;       
        }catch (Exception ex) {     
            ex.printStackTrace();
            throw new IllegalArgumentException();
        } 
    }

    @Override
    public DomainObject getSingleById(String id) {
        try{
            String query = "SELECT * FROM activityinfo WHERE ssn = '" + id + "';";

            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                return new ActivityInfo(StatusEnum.values()[rs.getInt("status")], TeamEnum.values()[rs.getInt("team")], ActivityEnum.values()[rs.getInt("activity")]);
            }
            throw new NullPointerException();       
        }catch (Exception ex) {     
            ex.printStackTrace();
            throw new IllegalArgumentException();
        } 
    }

    @Override
    public void create(DomainObject obj) {
        throw new NotImplementedException(); // "User CreateWithSsn instead"
    }
    
    public void createWithSsn(String ssn, DomainObject obj) {
        try{
            ActivityInfo activityInfo = (ActivityInfo)obj;
            
            String query = "INSERT INTO activityinfo (ssn, status, team, activity) VALUES ('" + ssn + "', " + activityInfo.getStatus().ordinal() + ", " + activityInfo.getTeam().ordinal() + ", " + activityInfo.getActivity().ordinal() + ")";

            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            stmt.execute(query);

        }catch (Exception ex){
            ex.printStackTrace();
            throw new IllegalArgumentException();
        }
    }
    
    public void update(String ssn, DomainObject obj) {
        try{
            ActivityInfo activityInfo = (ActivityInfo)obj;
            
            String query = "UPDATE activityinfo SET status = " + activityInfo.getStatus().ordinal() + ", team = " + activityInfo.getTeam().ordinal() + ", activity = " + activityInfo.getActivity().ordinal() + " WHERE ssn = '" + ssn + "';";
            
            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            stmt.execute(query);
            
        }catch (Exception ex){
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }
}
