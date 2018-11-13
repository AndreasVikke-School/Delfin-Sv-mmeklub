package delfin.data;

import delfin.logic.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Celina og Nina
 */
public class DataAccessor {
    
    private DBConnector connector = null;

    public DataAccessor(DBConnector connector) {
        this.connector = connector;
    }

    DataAccessor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Member> getMembers() throws IllegalArgumentException {
        try{
            String query = "SELECT * FROM member NATURAL JOIN activityinfo;"; 

            Connection connection = connector.getConnection(); 
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<Member> members = new ArrayList();

            while (rs.next()) {    
                ActivityInfo info = new ActivityInfo(StatusEnum.values()[rs.getInt("status")], TeamEnum.values()[rs.getInt("team")], ActivityEnum.values()[rs.getInt("activity")]);
                members.add(new Member(rs.getString("ssn"), rs.getString("name"), rs.getString("address"), rs.getString("phone"), info));
                
            }
            return members;       
        }catch (Exception ex) {     
            ex.printStackTrace();
            throw new IllegalArgumentException();
        }
    }
     
    public Member getMemberBySsn(String ssn) throws IllegalArgumentException {
        try{
            String query = "SELECT * FROM member NATURAL JOIN activityinfo WHERE ssn = '" + ssn + "';";

            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);


            while (rs.next()) {      
                ActivityInfo info = new ActivityInfo(StatusEnum.values()[rs.getInt("status")], TeamEnum.values()[rs.getInt("team")], ActivityEnum.values()[rs.getInt("activity")]);
                return new Member (rs.getString("ssn"), rs.getString("name"), rs.getString("address"), rs.getString("phone"), info);

            }
            throw new IllegalArgumentException();       
        }catch (Exception ex) {     
            ex.printStackTrace();
            throw new IllegalArgumentException();
        } 
    }
    
    public void createMember(String ssn, String name, String address, String phone, ActivityInfo info) throws IllegalArgumentException {
        try{
            String query = "INSERT INTO member (ssn, name, address, phone) VALUES ('" + ssn + "','" + name + "','" + address + "','" + phone + "');";

            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            stmt.execute(query);
            
            createActivityInfo(ssn, info);

        }catch (Exception ex){
            ex.printStackTrace();
            throw new IllegalArgumentException();
        }
    }
    
    public List<ActivityInfo> getActivityInfo() throws IllegalArgumentException {
        try{
            String query = "SELECT * FROM activityinfo;";

            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            List<ActivityInfo> activityInfos = new ArrayList<ActivityInfo>();

            while (rs.next()) {  
                activityInfos.add(new ActivityInfo(StatusEnum.values()[rs.getInt("status")], TeamEnum.values()[rs.getInt("team")], ActivityEnum.values()[rs.getInt("activity")]));
            }
            return activityInfos;       
        }catch (Exception ex) {     
            ex.printStackTrace();
            throw new IllegalArgumentException();
        } 
    }
    
    public ActivityInfo getActivityInfoBySsn(String ssn) throws IllegalArgumentException {
        try{
            String query = "SELECT * FROM activityinfo WHERE ssn = '" + ssn + "';";

            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                return new ActivityInfo(StatusEnum.values()[rs.getInt("status")], TeamEnum.values()[rs.getInt("team")], ActivityEnum.values()[rs.getInt("activity")]);
            }
            throw new IllegalArgumentException();       
        }catch (Exception ex) {     
            ex.printStackTrace();
            throw new IllegalArgumentException();
        } 
    }
    
    public void createActivityInfo(String ssn, ActivityInfo info) throws IllegalArgumentException {
        try{
            String query = "INSERT INTO activityinfo (ssn, status, team, activity) VALUES ('" + ssn + "', " + info.getStatus().ordinal() + ", " + info.getTeam().ordinal() + ", " + info.getActivity().ordinal() + ")";

            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            stmt.execute(query);

        }catch (Exception ex){
            ex.printStackTrace();
            throw new IllegalArgumentException();
        }
    }
}

