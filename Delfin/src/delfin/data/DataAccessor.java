package delfin.data;

import delfin.logic.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vikke
 */
public class DataAccessor {
    
    private DBConnector connector = null;

    public DataAccessor(DBConnector connector) {
        this.connector = connector;
    }
    
    public List<Member> getMembers() throws IllegalArgumentException {
        try{
            String query = "SELECT * FROM member;"; 

            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<Member> members = new ArrayList();

            while (rs.next()) {      
                members.add(new Member(rs.getString("ssn"), rs.getString("name"), rs.getString("adress"), rs.getString("phone"), new ActivityInfo(StatusEnum.ACTIVE, TeamEnum.SENIOR, ActivityEnum.COMPETITIOR)));
                
            }
            return members;       
        }catch (Exception ex) {     
            ex.printStackTrace();
            throw new IllegalArgumentException();
        }
    }
     
      public Member getSsn(String ssn) throws IllegalArgumentException {
        try{
            String query = "SELECT * FROM member WHERE ssn = '" + ssn + "';";

            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            
            while (rs.next()) {      
                return new Member (rs.getString("ssn"), rs.getString("name"), rs.getString("adress"), rs.getString("phone"), new ActivityInfo(StatusEnum.ACTIVE, TeamEnum.SENIOR, ActivityEnum.COMPETITIOR));
                
            }
            throw new IllegalArgumentException();       
        }catch (Exception ex) {     
            ex.printStackTrace();
            throw new IllegalArgumentException();
        } 
    }
    
      public Member createMember(String ssn, String name, String adress, String phone, ActivityInfo info) throws IllegalArgumentException {
        try{
            String query = "INSERT INTO members (ssn, name, adress, phone, info)";
          
            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
          
        }catch (Exception ex){
            ex.printStackTrace();
            throw new IllegalArgumentException();
        }

