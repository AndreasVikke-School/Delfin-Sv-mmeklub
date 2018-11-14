/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin.logic;

import delfin.logic.Member;

/**
 *
 * @author Nina
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
