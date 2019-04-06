/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor;

/**
 *
 * @author xhunt
 */
public class Doctor {

   String name;
   String specialization;
   int hours;
   String Code;

    public Doctor() {
    }


    public Doctor(final String name, final String specialization, final int hours, final String Code) {
        this.name = name;
        this.specialization = specialization;
        this.hours = hours;
        this.Code = Code;
    }
    
    
    
    public String toString(){
        return "\nDoctor code = "+ Code + "\nName = " + name + "\nSpecialization = " + specialization + "\nAvailability = " + hours; 
    }
   
    
    
}
