package delfin.logic;

/**
 *
 * @author Andreas Vikke
 */
public class ActivityInfo {
    
    private String ssn;
    private StatusEnum status;
    private TeamEnum team;
    private ActivityEnum activity;

    public ActivityInfo(String ssn, StatusEnum status, TeamEnum team, ActivityEnum activity) {
        this.ssn = ssn;
        this.status = status;
        this.team = team;
        this.activity = activity;
    }
    
    public String getSsn() {
        return ssn;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public TeamEnum getTeam() {
        return team;
    }

    public ActivityEnum getActivity() {
        return activity;
    }
    
}
