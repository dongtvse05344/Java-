/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_enum;

import java.util.Scanner;

/**
 *
 * @author xhunt
 */
 enum Day {
    SUNDAY,MONDAY, TUESDAY,WEDNESDAY, THURSDAY, FRIDAY, SATURDAY; 
}
public class Test_enum {
    Day d;
    Test_enum (Day d)
    {
        this.d = d;
    }
    public void tellItLikeItIs()
    {
        switch(d)
        {
            case MONDAY : System.out.println("Modays are bad."); break;
            case FRIDAY : System.out.println("Fridays are better."); break;
            case SATURDAY : 
            case SUNDAY :
                System.out.println("Weekends are best "); break;
            default : System.out.println("MidWeek days are so-so"); break;
        }
    }
}
class UseDay {
    public static void main(String[] args) {
        Test_enum te = new Test_enum(Day.FRIDAY);
        te.tellItLikeItIs();
        te = new Test_enum(Day.WEDNESDAY);
        te.tellItLikeItIs();
    }
}
