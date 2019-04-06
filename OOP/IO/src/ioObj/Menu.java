/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioObj;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author xhunt
 */
public class Menu extends Vector<String> {
    public Menu() {
        super();
    }
    void addMenuItem(String S){
        this.add(S);
    }
    int getUserchoice(){
        Scanner sc = new Scanner(System.in);
        for(String x:this)System.out.println(x);
        int choice = Integer.parseInt(sc.nextLine());
        return choice;
    }
}
