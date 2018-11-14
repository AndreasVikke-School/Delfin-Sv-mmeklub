package delfin.data;

import delfin.logic.ActivityEnum;
import delfin.logic.ActivityInfo;
import delfin.logic.Member;
import delfin.logic.StatusEnum;
import delfin.logic.TeamEnum;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vikke
 */
public class DataAccesorMember implements DataAccessor {
    
    private DBConnector connector = null;

    public DataAccesorMember(DBConnector connector) {
        this.connector = connector;
    }
    
    @Override
    public List<Object> getAll() {
        try{
            String query = "SELECT * FROM member NATURAL JOIN activityinfo;"; 

            Connection connection = connector.getConnection(); 
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<Object> members = new ArrayList();

            while (rs.next()) {    
                ActivityInfo info = new ActivityInfo(rs.getString("ssn"), StatusEnum.values()[rs.getInt("status")], TeamEnum.values()[rs.getInt("team")], ActivityEnum.values()[rs.getInt("activity")]);
                members.add(new Member(rs.getString("ssn"), rs.getString("name"), rs.getString("address"), rs.getString("phone"), info));
            }
            return members;       
        }catch (Exception ex) {     
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }

    @Override
    public List<Object> getAllById(String id) {
        try{
            String query = "SELECT * FROM member NATURAL JOIN activityinfo WHERE ssn = '" + id + "';";

            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            ArrayList<Object> members = new ArrayList<>();

            while (rs.next()) {      
                ActivityInfo info = new ActivityInfo(rs.getString("ssn"), StatusEnum.values()[rs.getInt("status")], TeamEnum.values()[rs.getInt("team")], ActivityEnum.values()[rs.getInt("activity")]);
                members.add(new Member (rs.getString("ssn"), rs.getString("name"), rs.getString("address"), rs.getString("phone"), info));
            }
            return members;      
        }catch (Exception ex) {     
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }
    
    @Override
    public Object getSingleById(String id) {
        try{
            String query = "SELECT * FROM member NATURAL JOIN activityinfo WHERE ssn = '" + id + "';";

            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                ActivityInfo info = new ActivityInfo(rs.getString("ssn"), StatusEnum.values()[rs.getInt("status")], TeamEnum.values()[rs.getInt("team")], ActivityEnum.values()[rs.getInt("activity")]);
                return new Member (rs.getString("ssn"), rs.getString("name"), rs.getString("address"), rs.getString("phone"), info);
            }
            throw new NullPointerException();   
        }catch (Exception ex) {     
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }

    @Override
    public void create(Object obj) {
        try{
            Member member = (Member)obj;
            
            String query = "INSERT INTO member (ssn, name, address, phone) VALUES ('" + member.getSsn() + "','" + member.getName() + "','" + member.getAddress() + "','" + member.getPhone() + "');";

            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            stmt.execute(query);
            
            DataAccesorActivityInfo daai = new DataAccesorActivityInfo(connector);
            daai.create(member.getActivityInfo());

        }catch (Exception ex){
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }
    
    
}
