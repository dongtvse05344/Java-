/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.*;
import java.util.Date;

/**
 *
 * @author xhunt
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        File f = new File("f1.txt");
        System.out.println("ten file la : " + f.getName());
        System.out.println("Ten file tuyet doi la : " + f.getAbsoluteFile());
        System.out.println("Duong dan tuyet doi la : " + f.getAbsolutePath());
        System.out.println("Path chuan la : "+ f.getCanonicalPath());
        System.out.println("Ngay cap nhat cuoi cung la : " + new Date(f.lastModified()));
        System.out.println("Thuoc tinh hidden : " +f.isHidden());
        System.out.println("thuoc tinh can-read : " +f.canRead());
        System.out.println("Thuoc tinh can-write : " +f.canWrite());
        System.out.println("Kich thuoc " + f.length()+" bytes");
        
    }
}
