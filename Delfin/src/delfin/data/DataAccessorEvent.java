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
 * @author Nina Lisakowski
 */
public class DataAccessorEvent implements DataAccessor {
    
    private DBConnector connector = null;
    
    public DataAccessorEvent(DBConnector connector){
        this.connector = connector;
    }
    
    public List<DomainObject> getAll() {
        try{
            String query = "SELECT * FROM event;";
            Connection connection = connector.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            ArrayList<DomainObject> events = new ArrayList();
            
            while (rs.next()) {
                events.add(new Event(rs.getInt("id"),rs.getString("name"), rs.getDate("date").toLocalDate()));
            }
            return events;
        }catch (Exception ex) {
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }

    @Override
    public List<DomainObject> getAllById(String id) {
        try{
            String query = "SELECT * FROM event WHERE id = '" + id + "';";
        
            Connection connection = connector.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query); 
            
            ArrayList<DomainObject> events = new ArrayList();
            
            while (rs.next()) {
                events.add(new Event(rs.getInt("id"), rs.getString("name"), rs.getDate("date").toLocalDate()));
            }
            return events;
        }catch (Exception ex){
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }

    @Override
    public DomainObject getSingleById(String id) {
        try{
            String query = "SELECT * FROM event WHERE id = '" + id + "';";
            
            Connection connection = connector.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                return new Event(rs.getInt("id"), rs.getString("name"), rs.getDate("date").toLocalDate());
            }
            throw new NullPointerException();
        }catch (Exception ex){
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }

    @Override
    public void create(DomainObject obj) {
        try{
            Event event = (Event)obj;

            String query = "INSERT INTO event (name, date) VALUES ('" + event.getName() + "','" + event.getDate() + "');";

            Connection connection = connector.getConnection();
            Statement stmt = connection.createStatement();
            stmt.execute(query);   

        }catch (Exception ex) {
        ex.printStackTrace();
        throw new IllegalAccessError();
        }
    }
    
    public void update(DomainObject obj) {
        try{
            Event event = (Event)obj;
            
            String query = "UPDATE event SET name = '" + event.getName() + "', date = '" + event.getDate() + "' WHERE id = '" + event.getId() + "';";
            
            Connection connection = connector.getConnection();
            Statement stmt = connection.createStatement();
            stmt.execute(query);
            
        }catch (Exception ex) {
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }
}
