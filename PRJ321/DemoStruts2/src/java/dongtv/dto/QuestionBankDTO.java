/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.dto;

import java.io.Serializable;

/**
 *
 * @author xhunt
 */
public class QuestionBankDTO implements Serializable{
    private int id;
    private String name,chap, ques,ans,rightAns,count,reason;
    private boolean used;

    public QuestionBankDTO(int id, String name, String chap, String ques, String ans, String rightAns, String count, String reason, boolean used) {
        this.id = id;
        this.name = name;
        this.chap = chap;
        this.ques = ques;
        this.ans = ans;
        this.rightAns = rightAns;
        this.count = count;
        this.reason = reason;
        this.used = used;
    }
    
    

    public QuestionBankDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChap() {
        return chap;
    }

    public void setChap(String chap) {
        this.chap = chap;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public String getRightAns() {
        return rightAns;
    }

    public void setRightAns(String rightAns) {
        this.rightAns = rightAns;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
    
}
