package delfin.data;

import java.util.List;

/**
 *
 * @author Celina og Nina
 */
public interface DataAccessor {
    public List<Object> getAll();
    
    public List<Object> getAllById(String id);
    public Object getSingleById(String id);
    /*
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
    
    public List<Results> getResults() throws IllegalArgumentException {
        try{
            String query = "SELECT * FROM result;";
        
            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            ArrayList<Results> results = new ArrayList();

            while (rs.next()) {    
                ActivityInfo info = new ActivityInfo(StatusEnum.values()[rs.getInt("status")], TeamEnum.values()[rs.getInt("team")], ActivityEnum.values()[rs.getInt("activity")]);
                results.add(new Results(rs.getString("ssn"), rs.getDate("date").toLocalDate(), rs.getDouble("time"), rs.getInt("placement"), rs.getString("event")));
                
            }
            return results;  
        }catch (Exception ex){
            ex.printStackTrace();
            throw new IllegalArgumentException();
        }
    }
    
    public List<Results> getResultsBySsn(String ssn) throws IllegalArgumentException {
        try{
            String query = "SELECT * FROM result WHERE ssn = '" + ssn + "';";
            
            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            ArrayList<Results> results = new ArrayList();
            
            while (rs.next()){
                ActivityInfo info = new ActivityInfo(StatusEnum.values()[rs.getInt("status")], TeamEnum.values()[rs.getInt("team")], ActivityEnum.values()[rs.getInt("activity")]);
                results.add(new Results(rs.getString("ssn"), rs.getDate("date").toLocalDate(), rs.getDouble("time"), rs.getInt("placement"), rs.getString("event")));
            }
            throw new IllegalArgumentException();  
        }catch (Exception ex){
            ex.printStackTrace();
            throw new IllegalArgumentException();
        }
    }
*/
    public void create(Object obj);
}
