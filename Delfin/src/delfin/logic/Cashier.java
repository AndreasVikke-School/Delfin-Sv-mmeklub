package delfin.logic;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Nina Lisakowski
 */
public class Cashier implements PersonInterface {
    private String ssn;
    private String name;
    private String address;
    private String phone;
    private ActivityInfo activityInfo;

    public Cashier(String snn, String name, String address, String phone, ActivityInfo activityInfo) {
        this.ssn = snn;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.activityInfo = activityInfo;
    }
    
    @Override
    public String getSsn(){
        return ssn;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String getAddress(){
        return address;
    }
    
    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public String getId() {
        return ssn;
    }

    @Override
    public int getAge() {
        int day = Integer.parseInt(ssn.substring(0, 2));
        int month = Integer.parseInt(ssn.substring(2, 4));
        int year = 0;
        if(Integer.parseInt(ssn.substring(4, 6)) >= 0 && Integer.parseInt(ssn.substring(4, 6)) <= 18)
            year = 2000 + Integer.parseInt(ssn.substring(4, 6));
        else
            year = 1900 + Integer.parseInt(ssn.substring(4, 6));
        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }

    @Override
    public ActivityInfo getActivityInfo() {
        return activityInfo;
    }
    
}
