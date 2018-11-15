package delfin.logic;

import java.time.LocalDate;

/**
 *
 * @author Nina Lisakovski & Martin Frederiksen
 */
public class Result extends DomainObject {
    private String ssn;
    private LocalDate date;
    private double time;
    private int placement;
    private String event;
    private Member member;
    private DisciplinEnum disciplin;
    
    public Result (String ssn, LocalDate date, double time, int placement, String event, DisciplinEnum disciplin, Member member){
        this.ssn = ssn;
        this.date = date;
        this.time = time;
        this.placement = placement;
        this.event = event;
        this.member = member;
        this.disciplin = disciplin;
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
    
    public DisciplinEnum getDisciplin(){
        return disciplin;
    }
}