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
    
    public void create(Object obj);
}
