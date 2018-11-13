/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin.logic;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Nina
 */
public class Results {
    private String ssn;
    private LocalDate date;
    private double time;
    private int placement;
    private String event;
    
    public Results (String ssn, LocalDate date, double time, int placement, String event){
        this.ssn = ssn;
        this.date = date;
        this.time = time;
        this.placement = placement;
        this.event = event;
    }
    
    public String getSsn(){
        return ssn;
    }
    
    public LocalDate getDate(){
        return date;
    }
    
    public double getTime(){
        return time;
    }
    
    public int getPlacement(){
        return placement;
    }
    
    public String getEvent(){
        return event;
    }
}
