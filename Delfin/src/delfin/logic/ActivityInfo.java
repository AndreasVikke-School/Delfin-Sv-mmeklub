package delfin.logic;

/**
 *
 * @author Andreas Vikke
 */
public class ActivityInfo extends DomainObject {
    
    private StatusEnum status;
    private TeamEnum team;
    private ActivityEnum activity;

    public ActivityInfo(StatusEnum status, TeamEnum team, ActivityEnum activity) {
        this.status = status;
        this.team = team;
        this.activity = activity;
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
