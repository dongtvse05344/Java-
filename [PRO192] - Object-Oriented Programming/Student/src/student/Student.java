/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.util.Date;

/**
 *
 * @author xhunt
 */
public class Student {
    private String mID;
    private String mFullName;
    private Date mDoB;
    private String mPhone;
    private String mAddress;
    public Student() {}

    public Student(String ID, String mFullName, Date mDoB, String mPhone, String mAddress) {
        this.mID = ID;
        this.mFullName = mFullName;
        this.mDoB = mDoB;
        this.mPhone = mPhone;
        this.mAddress = mAddress;
    }

    public String getID() {
        return mID;
    }

    public String getFullName() {
        return mFullName;
    }

    public Date getDoB() {
        return mDoB;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setID(String mID) {
        this.mID = mID;
    }

    public void setFullName(String mFullName) {
        this.mFullName = mFullName;
    }

    public void setDoB(Date mDoB) {
        this.mDoB = mDoB;
    }

    public void setPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public void setAddress(String mAddress) {
        this.mAddress = mAddress;
    }
    
    public void ToString()
    {
        System.out.println("ID          :" +mID);
        System.out.println("FullName    :" +mFullName);
        System.out.println("DoB         :" +mDoB);
        System.out.println("Phone       :" +mPhone);
        System.out.println("Address     :" +mAddress);
    }
}
