package delfin.logic;

import java.time.LocalDate;

/**
 *
<<<<<<< HEAD
 * @author Nina Lisakowski
=======
 * @author Nina Lisakovski
>>>>>>> e97dad17a95c27824d268ce7207a39fe9fa1036d
 */
public class Result {
    private String ssn;
    private LocalDate date;
    private double time;
    private int placement;
    private String event;
    private Member member;
    
    public Result (String ssn, LocalDate date, double time, int placement, String event, Member member){
        this.ssn = ssn;
        this.date = date;
        this.time = time;
        this.placement = placement;
        this.event = event;
        this.member = member;
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
    
    // giver en hel member klasse memningn når man ikke er interesseret i adresse osv?
    public Member getMember(){
        return member;
    }
    
    public String getDisciplin(){
        return "Crawl";
    }
}
