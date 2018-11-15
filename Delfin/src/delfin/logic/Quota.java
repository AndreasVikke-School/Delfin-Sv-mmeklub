package delfin.logic;

import delfin.logic.Member;

/**
 *
 * @author Nina Lisakowski
*/

public class Quota extends DomainObject {
    
    private String ssn;
    private double subscription;
    private double paid;
    private Member member;

    public Quota(String ssn, double subscription, double paid, Member member) {
        this.ssn = ssn;
        this.subscription = subscription;
        this.paid = paid;
        this.member = member;
    }

    public String getSsn() {
        return ssn;
    }

    public double getSubscription() {
        return subscription;
    }

    public double getPaid() {
        return paid;
    }

    public Member getMember() {
        return member;
    }
    
}
