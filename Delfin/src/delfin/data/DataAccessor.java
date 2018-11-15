package delfin.data;

import delfin.logic.DomainObject;
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
    public List<DomainObject> getAll();
    
    public List<DomainObject> getAllById(String id);
    public DomainObject getSingleById(String id);

    public void create(DomainObject obj);
}
