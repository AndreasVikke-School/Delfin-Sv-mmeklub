package delfin.data;

import delfin.logic.DomainObject;
import java.util.List;

/**
 *
 * @author Andreas Vikke
 */
public interface DataAccessor {
    public List<DomainObject> getAll();
    
    public List<DomainObject> getAllById(String id);
    public DomainObject getSingleById(String id);

    public void create(DomainObject obj);
}
