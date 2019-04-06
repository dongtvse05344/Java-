/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

/**
 *
 * @author xhunt
 */
public class DSA {

    public long nhan(long a, long b)
    {
        if( b == 1) return a;
        return a + nhan(a,b-1);
    }
    
}
