/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin.data;

import java.io.FileWriter;

/**
 *
 * @author Martin Frederiksen
 */
public class ShowMemberTextWriter{
    
    
    
    public void writeShowMember(){
        FileWriter fW = null;
        
    try{
        fW = new FileWriter("test.txt");
        fW.write("data 1");
        fW.write("data 2");
        fW.write("data 3");

        fW.close();
    }catch(Exception ex){
        ex.printStackTrace();
        }        
    }
}
