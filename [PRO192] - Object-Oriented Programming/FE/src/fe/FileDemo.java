/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fe;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author xhunt
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
//        File f = new File("hello.txt");
//        f.createNewFile();

        Object o = new Object();
        String[] ar = new String[50];
        o = ar;
        o = ar[5];
    }
}
