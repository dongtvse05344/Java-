/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryfile;
import java.io.*;
/**
 *
 * @author xhunt
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) throws IOException {
        String fName ="RandomAccessFileDemo.txt";
        String S1 = "Mắt nai"; boolean b = true; int n = 1234;
        double x =37.456; String S2= "Hoang an Huan";
        byte[] ar = new byte[100];
        try {
            RandomAccessFile f = new RandomAccessFile(fName,"rw");
            //write data , position 0,1,2,3,4
            f.writeUTF(S1); f.writeBoolean(b); f.writeInt(n);
            f.writeDouble(x); f.writeBytes(S2);
            //read data
            f.seek(0); // Seek to BOP
            System.out.println(f.readUTF());
            System.out.println(f.readBoolean());
            System.out.println(f.readInt());
            System.out.println(f.readDouble());
            f.read(ar);
            System.out.println(new String (ar));
            System.out.println("File length: "+f.length());
            f.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
