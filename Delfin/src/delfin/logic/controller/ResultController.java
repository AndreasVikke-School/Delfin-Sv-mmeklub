/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin.logic.controller;

import delfin.data.DBConnector;
import delfin.data.DataAccessorResult;
import delfin.logic.DisciplinEnum;
import delfin.logic.Event;
import delfin.logic.Result;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Nina Lisakowski
 */
public class ResultController {
    
    DataAccessorResult dar = null;
    EventController eventController = null;
    
    public ResultController(){
        try{
            dar = new DataAccessorResult(new DBConnector());
            eventController = new EventController();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Setup fail!");

        }
    }
    
    public List<Result> getAllResults(){
        return (List<Result>)(Object)dar.getAll();
    }
    
    public Result getSingleResult(String id){
        return (Result)dar.getSingleById(id);
    }
    
    public List<Result> getTopFiveInDisciplin(DisciplinEnum de) {
        return (List<Result>)(Object)dar.getTopFiveInDisciplin(de);
    }
    
    public String createResult(String ssn, String day, String month, String year, String time, String placement, String event, String disciplin){
        try {
            if(day.length() != 2 || Pattern.matches("[a-zA-Z]+", day)) {
                return ("Please type a valid day with two digits");
            }
            else if(Integer.parseInt(day) > 31 && 0 > Integer.parseInt(day)) {
                return ("Please type a valid day between 1 and 31");
            }
            else if(month.length() != 2 || Pattern.matches("[a-zA-Z]+", month)) {
                return ("Please type a valid month with two digits");
            }
            else if(Integer.parseInt(month) > 12 && 0 > Integer.parseInt(month)) {
                return ("Please type a valid month between 1 and 12");
            }
            else if(year.length() !=4 || Pattern.matches("[a-zA-Z]+",year)){
                return ("Please type a valid year with four digits");
            }
            else if (Pattern.matches("[a-zA-Z]+",time)){
                return ("Please type a valid digit");
            }
            else if (Pattern.matches("[a-zA-Z]+",placement)){
                return ("Please type a valid digit");
            }
            else{
                Result result = new Result(0, ssn, LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day)), Double.parseDouble(time), Integer.parseInt(placement), eventController.getSingleEventByName(event), DisciplinEnum.valueOf(disciplin), null);
                dar.create(result);
                return ("<html><font color='green'>Result is created successfully!</font></html>");
            }
        } catch(Exception ex) {
            return (ex.getMessage());        
        }  
    }  
    
    public String updateResult(String ssn, String day, String month, String year, String time, String placement, String event, String disciplin){
        try {
            if(day.length() != 2 || Pattern.matches("[a-zA-Z]+", day)) {
                return ("Please type a valid day with two digits");
            }
            else if(Integer.parseInt(day) > 31 && 0 > Integer.parseInt(day)) {
                return ("Please type a valid day between 1 and 31");
            }
            else if(month.length() != 2 || Pattern.matches("[a-zA-Z]+", month)) {
                return ("Please type a valid month with two digits");
            }
            else if(Integer.parseInt(month) > 12 && 0 > Integer.parseInt(month)) {
                return ("Please type a valid month between 12 and 1");
            }
            else if(year.length() !=4 || Pattern.matches("[a-zA-Z]+",year)){
                return ("Please type a valid year with four digits");
            }
            else if (Pattern.matches("[a-zA-Z]+",time)){
                return ("Please type a valid digit");
            }
            else if (Pattern.matches("[a-zA-Z]+",placement)){
                return ("Please type a valid digit");
            }
            else{
                Result result = new Result(0, ssn, LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day)), Double.parseDouble(time), Integer.parseInt(placement), eventController.getSingleEventByName(event), DisciplinEnum.valueOf(disciplin), null);
                dar.update(result);
                return ("<html><font color='green'>Result is updated successfully!</font></html>");
            }
        } catch(Exception ex) {
            return (ex.getMessage());        
        } 
    }
}
