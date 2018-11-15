/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package delfin.logic;

import delfin.data.*;
import java.sql.SQLException;
import java.util.regex.Pattern;

/**
 *
 * @author Andreas Vikke
 */
public class QuotaController {
    
    DataAccessorQuota daq = null;
    
    public QuotaController() {
        try {
            daq = new DataAccessorQuota(new DBConnector());
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public String createPayment(String ssn, String payment) {
        Quota firstSubscription = getFirstNotPaidQuotaById(ssn);
        
        if(payment.length() == 0 || Pattern.matches("[a-zA-Z]+", payment)) {
            return("Please enter a valid digit in payment");
        }
        else if(firstSubscription.getSubscription() - firstSubscription.getPaid() < Double.parseDouble(payment)) {
            return "This payment is not acceptable as the payment exceeds the users first non paid subscription.";
        }
        else {
            try {
                Quota quota = new Quota(ssn, 0, Double.parseDouble(payment), new Member(null,null,null,null,null));
                daq.createPayment(quota);
                return ("<html><font color='green'>Payment is created successfully!</font></html>");
            } catch(Exception ex) {
                ex.printStackTrace();
                return (ex.getMessage());
            }
        }
    }
    
    public String createQuota(String ssn, double subscriptionPrice) {
        try {
            Quota quota = new Quota(ssn, subscriptionPrice, 0, new Member(null,null,null,null,null));
            daq.create(quota);
            return ("<html><font color='green'>Quota is created successfully!</font></html>");
        } catch(Exception ex) {
            ex.printStackTrace();
            return (ex.getMessage());
        }
    }
    
    public Quota getFirstNotPaidQuotaById(String id) {
        return (Quota)daq.getFirstNotPaidQuotaById(id);
    }
}