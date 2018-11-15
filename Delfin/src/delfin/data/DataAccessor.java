package delfin.data;

import java.util.List;

/**
 *
<<<<<<< HEAD
 * @author Celina og Nina Lisakowski
=======
 * @author Andreas Vikke
>>>>>>> e97dad17a95c27824d268ce7207a39fe9fa1036d
 */
public interface DataAccessor {
    public List<Object> getAll();
    
    public List<Object> getAllById(String id);
    public Object getSingleById(String id);

    public void create(Object obj);
}
