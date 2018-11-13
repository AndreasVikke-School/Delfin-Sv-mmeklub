/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class DataAccessorResult implements DataAccessor {

    private DBConnector connector = null;

    public DataAccessorResult(DBConnector connector) {
        this.connector = connector;
    }
    
    @Override
    public List<Object> getAll() {
        try{
            String query = "SELECT * FROM result;";
        
            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            ArrayList<Object> results = new ArrayList();

            while (rs.next()) {    
                results.add(new Result(rs.getString("ssn"), rs.getDate("date").toLocalDate(), rs.getDouble("time"), rs.getInt("placement"), rs.getString("event"))); 
            }
            return results;  
        }catch (Exception ex){
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }

    @Override
    public List<Object> getAllById(String id) {
        try{
            String query = "SELECT * FROM result WHERE ssn = '" + id + "';";
            
            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            ArrayList<Object> results = new ArrayList();
            
            while (rs.next()){
                results.add(new Result(rs.getString("ssn"), rs.getDate("date").toLocalDate(), rs.getDouble("time"), rs.getInt("placement"), rs.getString("event")));
            }
            return results; 
        }catch (Exception ex){
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }

    @Override
    public Object getSingleById(String id) {
        try{
            String query = "SELECT * FROM result WHERE id = " + id + ";";
            
            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()){
                return new Result(rs.getString("ssn"), rs.getDate("date").toLocalDate(), rs.getDouble("time"), rs.getInt("placement"), rs.getString("event"));
            }
            throw new NullPointerException();
        }catch (Exception ex){
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }

    @Override
    public void create(Object obj) {
        try{
            Result result = (Result)obj;
            
            String query = "INSERT INTO result (ssn, date, time, placement, event) VALUES ('" + result.getSsn() + "','" + result.getDate()+ "', " + result.getTime()+ ", " + result.getPlacement()+ ", '" + result.getEvent() + "');";

            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            stmt.execute(query);

        }catch (Exception ex){
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }

}
