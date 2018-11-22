package delfin.logic;

import delfin.logic.DomainObject;
import java.time.LocalDate;

/**
 *
 * @author Nina Lisakowski
 */
public class Event extends DomainObject {

    private int id;
    private String name;
    private LocalDate date;
    
    public Event(int id, String name, LocalDate date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public LocalDate getDate() {
        return date;
    }
}
