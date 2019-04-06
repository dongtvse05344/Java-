/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gift;

import java.util.Scanner;

/**
 *
 * @author xhunt
 */
public class Gift {
    int n,m;
    long ans;
    public long Doing()
    {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        m = Integer.parseInt(sc.nextLine());
        if(n >m)
        {
            for (int i = 1; i < m+1; i++) {
                ans*=i;
            }
        }
        else
        {
            for (int i = 1; i < n+1; i++) {
                ans *= i;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Gift g = new Gift();
        g.Doing();
    }
}
