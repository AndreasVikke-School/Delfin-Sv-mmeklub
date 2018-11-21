package delfin.data;

import delfin.logic.*;
import delfin.logic.controller.EventController;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nina Lisakovski, Martin Frederiksen & Celina Dencker
 */
public class DataAccessorResult implements DataAccessor {

    private DBConnector connector = null;

    public DataAccessorResult(DBConnector connector) {
        this.connector = connector;
    }

    @Override
    public List<DomainObject> getAll() {
        try {
            String query = "SELECT * FROM results;";

            Connection connection = connector.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<DomainObject> results = new ArrayList();
            DataAccessor da = new DataAccessorMember(new DBConnector());
            EventController ec = new EventController();
            
            while (rs.next()) {   
                Member member = (Member)da.getSingleById(rs.getString("ssn"));
                Event event = ec.getSingleEvent(String.valueOf(rs.getInt("event")));
                results.add(new Result(rs.getInt("id"), rs.getString("ssn"), rs.getDate("date").toLocalDate(), rs.getDouble("time"), rs.getInt("placement"), event, DisciplinEnum.values()[rs.getInt("disciplin")], member)); 
            }
            return results;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }

    @Override
    public List<DomainObject> getAllById(String id) {
        try {
            String query = "SELECT * FROM results WHERE ssn = '" + id + "';";

            Connection connection = connector.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<DomainObject> results = new ArrayList();
            DataAccessor da = new DataAccessorMember(new DBConnector());
            EventController ec = new EventController();
            
            while (rs.next()) {   
                Member member = (Member)da.getSingleById(rs.getString("ssn"));
                Event event = ec.getSingleEvent(String.valueOf(rs.getInt("event")));
                results.add(new Result(rs.getInt("id"), rs.getString("ssn"), rs.getDate("date").toLocalDate(), rs.getDouble("time"), rs.getInt("placement"), event, DisciplinEnum.values()[rs.getInt("disciplin")], member));
            }
            return results;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }

    @Override
    public DomainObject getSingleById(String id) {
        try {
            String query = "SELECT * FROM results WHERE id = " + id + ";";

            Connection connection = connector.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            DataAccessor da = new DataAccessorMember(new DBConnector());
            EventController ec = new EventController();
            
            while (rs.next()) {   
                Member member = (Member)da.getSingleById(rs.getString("ssn"));
                Event event = ec.getSingleEvent(String.valueOf(rs.getInt("event")));
                return new Result(rs.getInt("id"), rs.getString("ssn"), rs.getDate("date").toLocalDate(), rs.getDouble("time"), rs.getInt("placement"), event, DisciplinEnum.values()[rs.getInt("disciplin")], member);
            }
            throw new NullPointerException();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }

    
    public List<DomainObject> getTopFiveInDisciplin(DisciplinEnum de) {
        try {
            String query = "SELECT * FROM results WHERE disciplin = " + de.ordinal() + " LIMIT 5;";

            Connection connection = connector.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<DomainObject> results = new ArrayList();
            EventController ec = new EventController();
            
            DataAccessor da = new DataAccessorMember(new DBConnector());
            
            while (rs.next()) {
                Member member = (Member) da.getSingleById(rs.getString("ssn"));
                Event event = ec.getSingleEvent(String.valueOf(rs.getInt("event")));
                results.add(new Result(rs.getInt("id"), rs.getString("ssn"), rs.getDate("date").toLocalDate(), rs.getDouble("time"), rs.getInt("placement"), event, DisciplinEnum.values()[rs.getInt("disciplin")], member));
            }

            return results;
     
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }

    @Override
    public void create(DomainObject obj) {
        try {
            Result result = (Result) obj;

            String query = "INSERT INTO results (ssn, date, time, placement, event, disciplin) VALUES ('" + result.getSsn() + "','" + result.getDate() + "', '" + result.getTime() + "', '" + result.getPlacement() + "', '" + result.getEvent().getId() + "', '" + result.getDisciplin().ordinal() + "');";

            Connection connection = connector.getConnection();
            Statement stmt = connection.createStatement();
            stmt.execute(query);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }
    
    public void update(DomainObject obj) {
        try{
            Result result = (Result)obj;
            
            String query = "UPDATE results SET date = '" + result.getDate() + "', time = " + result.getTime() + ", placement = " + result.getPlacement() + ", event = '" + result.getEvent().getId() + "', disciplin = " + result.getDisciplin().ordinal() + " WHERE ssn = '" + result.getSsn() + "';";
            
            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            stmt.execute(query);
            
        }catch (Exception ex){
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }
}
