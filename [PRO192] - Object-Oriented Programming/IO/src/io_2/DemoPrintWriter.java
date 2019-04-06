/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io_2;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author xhunt
 */
public class DemoPrintWriter {
    public static void main(String[] args) throws IOException {
        try {
            //BufferedReader in = new BufferedReader(new InputStreamReader(System.in) );
            Scanner sc = new Scanner(System.in);
            System.out.println("File name : ");
            String fileName = sc.nextLine();
            PrintWriter out = new PrintWriter(new FileWriter(fileName));
            
            System.out.println("Enter some wordings : | Enter 'stop' to quit |");
            String textLine = sc.nextLine();
            while (!textLine.equals("stop"))
            {
                out.println(textLine);
                textLine = sc.nextLine();
            }
            out.close();
            //in.close();
        }
        catch( IOException error)
        {
            System.out.print("Error making file :");
            System.out.println("\t"+ error);
        }
    }
}
