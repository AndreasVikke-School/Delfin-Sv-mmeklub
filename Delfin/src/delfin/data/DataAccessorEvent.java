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
            DataAccessor dae = new DataAccessorEvent(new DBConnector());
            
            while (rs.next()) {
                Event event = (Event) dae.getSingleById(rs.getString("id"));
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
            
            ArrayList<DomainObject> events = new ArrayList();
            DataAccessor dae = new DataAccessorEvent(new DBConnector());
            
            while (rs.next()) {
                Event event = (Event)dae.getSingleById(rs.getString("id"));
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

            String query = "INSERT INTO event (id, name, date) VALUES ('" + event.getId() + "','" + event.getName() + "','" + event.getDate() + "');";

            Connection connection = connector.getConnection();
            Statement stmt = connection.createStatement();
            stmt.execute(query);   

        }catch (Exception ex) {
        ex.printStackTrace();
        throw new IllegalAccessError();
        }
    }
}