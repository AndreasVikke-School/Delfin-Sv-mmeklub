package delfin.logic;

import java.time.LocalDate;

/**
 *
 * @author Nina Lisakovski & Martin Frederiksen
 */
public class Result extends DomainObject {
    private int id;
    private String ssn;
    private LocalDate date;
    private double time;
    private int placement;
    private Event event;
    private Member member;
    private DisciplinEnum disciplin;
    
    public Result (int id, String ssn, LocalDate date, double time, int placement, Event event, DisciplinEnum disciplin, Member member){
        this.id = id;
        this.ssn = ssn;
        this.date = date;
        this.time = time;
        this.placement = placement;
        this.event = event;
        this.member = member;
        this.disciplin = disciplin;
    }
    
    public int getId() {
        return id;
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
    
    public Event getEvent(){
        return event;
    }
    
    public Member getMember(){
        return member;
    }
    
    public DisciplinEnum getDisciplin(){
        return disciplin;
    }
}