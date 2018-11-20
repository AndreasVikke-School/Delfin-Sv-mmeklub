/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin.logic.controller;

import delfin.data.DBConnector;
import delfin.data.DataAccessorEvent;
import delfin.logic.Event;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Nina Lisakowski
 */
public class EventController {
    
    DataAccessorEvent dae = null;
    
    public EventController() {
        try{
            dae = new DataAccessorEvent(new DBConnector());
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("Setup fail!");
        }
    }
    
    public List<Event> getAllEvents(){
        return (List<Event>)(Object)dae.getAll();
    }
    
    public String createEvent(String name, String day, String month, String year){
        try{
            if(name.length() == 0){
                return ("Please input a name");
            }  
            else if(day.length() != 2 || Pattern.matches("[a-zA-Z]+", day)) {
                return ("Please type a valid day with two digits");
            }
            else if(Integer.parseInt(day) > 31 && 0 > Integer.parseInt(day)){
                return ("Please type a valid day between 1 and 31");
            }
            else if(month.length() != 2 || Pattern.matches("[a-zA-Z]+", month)) {
                return ("Please type a valid month with two digits");
            }
            else if (Integer.parseInt(month) > 12 && 0 > Integer.parseInt(month)){
                return ("Please type a valid month between 1 and 12");
            }
            else if (year.length() != 4 || Pattern.matches("[a-zA-Z]+",year)){
                return ("Please type a valid year with four digits");
            }
            else{
                Event event = new Event(0, name, LocalDate.of(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year)));
                dae.create(event);
                return ("<html><font color='green'>Event is created successfully!</font></html>");
            }
        }catch(Exception ex) {
            return (ex.getMessage());
        }
    }
}
