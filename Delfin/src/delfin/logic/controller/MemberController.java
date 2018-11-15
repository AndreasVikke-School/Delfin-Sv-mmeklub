/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin.logic.controller;

import delfin.data.DBConnector;
import delfin.data.DataAccessor;
import delfin.data.DataAccessorMember;
import delfin.logic.ActivityEnum;
import delfin.logic.ActivityInfo;
import delfin.logic.Member;
import delfin.logic.StatusEnum;
import delfin.logic.TeamEnum;
import java.util.regex.Pattern;

/**
 *
 * @author Nina Lisakowski
 */
public class MemberController {

    DataAccessorMember dam = null;
    
    public MemberController(){
        try {
            dam = new DataAccessorMember(new DBConnector());
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Setup fail!");
        }
    }
    
    public String createMember(String ssn, String name, String address, String phone, String activity, String status){
        try {
            if(ssn.length() != 10 || Pattern.matches("[a-zA-Z]+", ssn)) {
                return ("Please type a real SSN number (Only digits and 10 in length)");
            }
            else if(name.length() == 0) {
                return ("Please input a name");
            }
            else if(address.length() == 0) {
                return ("Please input an address");
            }
            else if(phone.length() == 0 || Pattern.matches("[a-zA-Z]+", phone)) {
                return ("Please input a phone number only digits");
            }
            else {
                Member newMember = new Member(ssn, name, address, phone, new ActivityInfo(ssn, StatusEnum.valueOf(status), null, ActivityEnum.valueOf(activity)));

                TeamEnum teamEnum = null;
                if(newMember.getAge() >= 18)
                    teamEnum = TeamEnum.SENIOR;
                else
                    teamEnum = TeamEnum.JUNIOR;

                newMember = new Member(ssn, name, address, phone, new ActivityInfo(ssn, StatusEnum.valueOf(status), teamEnum, ActivityEnum.valueOf(activity)));
                dam.create(newMember);
                return ("<html><font color='green'>Member is created successfully!</font></html>");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
            return (ex.getMessage());
        }
    }
}
