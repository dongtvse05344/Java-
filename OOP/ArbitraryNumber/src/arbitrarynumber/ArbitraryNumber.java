/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbitrarynumber;

/**
 *
 * @author xhunt
 */
public class ArbitraryNumber {

    public double sum(double... group) //truyền vào 1 cái mảng
    {
        double S=0;
        for(double x : group) S+= x;
        return S;
    }
    
    public String concate(String... group)
    {
        String S ="";
        for (String x : group) S+= x+ " ";
        return S;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        ArbitraryNumber obj = new ArbitraryNumber();
        double total = obj.sum(5.4,3.2,9.08,4);
        System.out.println(total);
        String line = obj.concate("I","love","you","!");
        System.out.println(line);

    }
    
}
