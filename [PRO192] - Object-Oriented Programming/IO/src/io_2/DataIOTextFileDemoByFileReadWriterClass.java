/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io_2;

import java.io.*;


/**
 *
 * @author xhunt
 */
public class DataIOTextFileDemoByFileReadWriterClass {
    public static void main(String[] args) throws IOException {
        try {
            File f = new  File("example.txt");
            //tao file
            BufferedWriter output = new BufferedWriter(new FileWriter(f));
            output.write("Hello world");
            output.write("\n");
            output.write("Java SE 9");
            output.close();
            //Doc file
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String s;
            while((s= reader.readLine())!= null)
            {
                System.out.println(s);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
