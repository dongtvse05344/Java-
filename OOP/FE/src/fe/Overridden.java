/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fe;

/**
 *
 * @author xhunt
 */
public class Overridden{

   public static void main(String[] args){

        System.out.println(new Overridden());


       System.out.println(new Overridden(){

        public String toString(){
             return "manual override";
         }

       });



      System.out.println(new Overridden(){

              public String gm(){
                    return  "manual gm";
               }
        }.gm());
     }  //end of main method

   public String gm(){
     return "gm";
    }
}
