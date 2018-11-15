package delfin.logic;

import delfin.logic.Member;

/**
 *
<<<<<<< HEAD
 * @author Nina Lisakowski
=======
 * @author Nina Lisakovski
>>>>>>> e97dad17a95c27824d268ce7207a39fe9fa1036d
 */
public class Quota {
    
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
