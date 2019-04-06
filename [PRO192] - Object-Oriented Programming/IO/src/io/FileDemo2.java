/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.*;

/**
 *
 * @author xhunt
 */
public class FileDemo2 {
    public static void main(String[] args) {
        File f = new File("../io");
        String S = f.isDirectory() ? "Thu muc " : " tap tin";
        System.out.println("../io la" + S);
        String L[] = f.list();
        System.out.println("Noi dung thu muc : ");
        for(int i=0; i< L.length;++i)
        {
            File f2 = new File(f,L[i]);
            System.out.println(L[i]+ " "+ (f2.isFile() ? "tap tin" : "Thu muc"));
        }
    }
}
