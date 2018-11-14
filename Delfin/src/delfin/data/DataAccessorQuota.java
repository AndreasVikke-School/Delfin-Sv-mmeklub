/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin.data;

import delfin.logic.Quota;
import delfin.logic.Member;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nina
 */
public class DataAccessorQuota implements DataAccessor {
    private DBConnector connector = null;
    
    public DataAccessorQuota (DBConnector connector) {
        this.connector = connector;
    }

    @Override
    public List<Object> getAll() {
        try{
            String query = "SELECT * FROM quota;";
            
            Connection connection = connector.getConnection(); 
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            ArrayList <Object> quotas = new ArrayList();
            DataAccessor da = new DataAccessorMember(new DBConnector());
            
            while (rs.next()) {
                Member member = (Member)da.getSingleById(rs.getString("ssn"));
                quotas.add(new Quota (rs.getString("ssn"), rs.getDouble("subscription"), rs.getDouble("paid"), member));
            }
            return quotas;
        }catch(Exception ex){
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }

    @Override
    public List<Object> getAllById(String id) {
        try{
            String query = "SELECT * FROM quota WHERE ssn = '" + id + "';";
            
            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            ArrayList<Object> quotas = new ArrayList();
            DataAccessor da = new DataAccessorMember(new DBConnector());
            
            while (rs.next()) {
                Member member = (Member)da.getSingleById(rs.getString("ssn"));
                quotas.add(new Quota (rs.getString("ssn"), rs.getDouble("subscription"), rs.getDouble("paid"), member));
            }
            return quotas;
        }catch (Exception ex) {
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }

    @Override
    public Object getSingleById(String id) {
        try{
            String query = "SELECT * FROM quota WHERE ssn = '" + id + "';";

            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            DataAccessor da = new DataAccessorMember(new DBConnector());

            while (rs.next()) {
                Member member = (Member)da.getSingleById(rs.getString("ssn"));
                return (new Quota (rs.getString("ssn"), rs.getDouble("subscription"), rs.getDouble("paid"), member));
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
            Quota quotas = (Quota)obj;
            
            String query = "INSERT INTO quota (ssn, subscription, paid) VALUES ('" + quotas.getSsn() + "','" + quotas.getSubscription() + "','" + quotas.getPaid() + "');";

            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            stmt.execute(query);

        }catch (Exception ex){
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }
}