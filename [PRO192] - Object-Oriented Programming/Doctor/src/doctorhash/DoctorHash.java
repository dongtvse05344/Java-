/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctorhash;

import doctor.Doctor;
import java.util.*;

/**
 *
 * @author xhunt
 */
public class DoctorHash {
    HashMap<String,Doctor> DoctorHash;

    public DoctorHash() {
        DoctorHash = new HashMap<String, Doctor>();
    }
    
    public void add(){
        String name;
        String specialization;
        int hours;
        String Code;
        //Nhap du lieu
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter doctor code");
        Code = sc.nextLine();
        
        System.out.println("Enter doctor name");
        name = sc.nextLine();
        
        System.out.println("Enter doctor specialization");
        specialization = sc.nextLine();
        
        System.out.println("Enter doctor hours");
        hours = Integer.parseInt(sc.nextLine()) ;
        
        Doctor d = new Doctor(name, specialization, hours, Code);
        DoctorHash.put(Code,d);
    }
    
    public void display()
    {
        String searchCode ="";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter doctor code ");
        searchCode = sc.nextLine();
        if(DoctorHash.containsKey(searchCode)){
            Doctor doc = DoctorHash.get(searchCode);
            System.out.println(doc);
        }
        else
        {
            System.out.println("Doctor not found");
        }
    }
    
    public void publish() {
        System.out.println("The size of DoctorHashMap = " + DoctorHash.size());
        System.out.println("The Doctor in the Panel are :");
        
        Set set = DoctorHash.keySet();
        Iterator it = set.iterator();
        int i = 1;
        while(it.hasNext())
        {
            System.out.println(" " + i + " ) "+ DoctorHash.get(it.next()));
            i++;
        }
    }
    
}
