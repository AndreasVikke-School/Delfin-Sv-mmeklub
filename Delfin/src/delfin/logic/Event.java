/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
