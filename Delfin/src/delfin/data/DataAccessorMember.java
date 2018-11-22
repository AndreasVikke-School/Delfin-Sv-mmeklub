package delfin.data;

import delfin.logic.*;
import delfin.logic.controller.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nina Lisakovski & Celina Dencker
 */
public class DataAccessorMember implements DataAccessor {
    
    private DBConnector connector = null;

    public DataAccessorMember(DBConnector connector) {
        this.connector = connector;
    }
    
    @Override
    public List<DomainObject> getAll() {
        try{
            String query = "SELECT * FROM member;"; 

            Connection connection = connector.getConnection(); 
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<DomainObject> members = new ArrayList();
            ActivityInfoController activityInfoController = new ActivityInfoController();

            while (rs.next()) {
                ActivityInfo info = activityInfoController.getSingleActivityInfoById(rs.getString("ssn"));
                members.add(new Member(rs.getString("ssn"), rs.getString("name"), rs.getString("address"), rs.getString("phone"), info));
            }
            return members;       
        }catch (Exception ex) {     
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }

    @Override
    public List<DomainObject> getAllById(String id) {
        try{
            String query = "SELECT * FROM member WHERE ssn = '" + id + "';";

            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            ArrayList<DomainObject> members = new ArrayList<>();
            ActivityInfoController activityInfoController = new ActivityInfoController();

            while (rs.next()) {
                ActivityInfo info = activityInfoController.getSingleActivityInfoById(rs.getString("ssn"));
                members.add(new Member (rs.getString("ssn"), rs.getString("name"), rs.getString("address"), rs.getString("phone"), info));
            }
            return members;      
        }catch (Exception ex) {     
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }
    
    @Override
    public DomainObject getSingleById(String id) {
        try{
            String query = "SELECT * FROM member WHERE ssn = '" + id + "';";

            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            ActivityInfoController activityInfoController = new ActivityInfoController();

            while (rs.next()) {
                ActivityInfo info = activityInfoController.getSingleActivityInfoById(rs.getString("ssn"));
                return new Member (rs.getString("ssn"), rs.getString("name"), rs.getString("address"), rs.getString("phone"), info);
            }
            throw new NullPointerException();   
        }catch (Exception ex) {     
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }

    @Override
    public void create(DomainObject obj) {
        try{
            Member member = (Member)obj;
            
            String query = "INSERT INTO member (ssn, name, address, phone) VALUES ('" + member.getSsn() + "','" + member.getName() + "','" + member.getAddress() + "','" + member.getPhone() + "');";

            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            stmt.execute(query);
            
            ActivityInfoController activityInfoController = new ActivityInfoController();
            activityInfoController.createActivityInfo(member.getSsn(), member.getActivityInfo().getStatus(), member.getActivityInfo().getTeam(), member.getActivityInfo().getActivity());

        }catch (Exception ex){
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }
    
    public void update(DomainObject obj) {
        try{
            Member member = (Member)obj;
            
            String query = "UPDATE member SET name = '" + member.getName() + "', address = '" + member.getAddress() + "', phone = '" + member.getPhone() + "' WHERE ssn = '" + member.getSsn() + "';";
            
            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            stmt.execute(query);
            
            ActivityInfoController activityInfoController = new ActivityInfoController();
            activityInfoController.updateActivityInfo(member.getSsn(), member.getActivityInfo().getStatus(), member.getActivityInfo().getTeam(), member.getActivityInfo().getActivity());

        }catch (Exception ex){
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }
}
