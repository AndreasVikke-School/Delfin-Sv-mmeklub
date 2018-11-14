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
public class Result {
    private String ssn;
    private LocalDate date;
    private double time;
    private int placement;
    private String event;
    
    public Result (String ssn, LocalDate date, double time, int placement, String event){
        this.ssn = ssn;
        this.date = date;
        this.time = time;
        this.placement = placement;
        this.event = event;
    }

    public Result(String text, String text0, String text1, Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Result(String text, String text0, String text1, String text2, String text3, String text4, String text5) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
