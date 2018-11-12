/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin.logic;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Martin Frederiksen
 */
public class Member {
    private String ssn;
    private String name;
    private String adress;
    private String phone;
    private ActivityInfo info;

    public Member(String ssn, String name, String adress, String phone, ActivityInfo info) {
        this.ssn = ssn;
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        this.info = info;
    }
    
    public String getId() {
        return ssn;
    }

    public String getSsn() {
        return ssn;
    }
    
    public int getAge() {
        int day = Integer.parseInt(ssn.substring(0, 2));
        int month = Integer.parseInt(ssn.substring(2, 4));
        int year = 1900 + Integer.parseInt(ssn.substring(4, 6));
        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhone() {
        return phone;
    }

    public ActivityInfo getInfo() {
        return info;
    }
}
