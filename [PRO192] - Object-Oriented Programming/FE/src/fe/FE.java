/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fe;

/**
 *
 * @author xhunt
 */
class AA{
    int x;
}
public class FE {

    /**
     * @param args the command line arguments
     */
    
    static int i;
    static Boolean check(int a)
    {
        return null;
    }
    static int se(int i)
    {
        return i^i;
    }
    static void fun(AA a)
    {
        a.x+=2;
    }
    
    public static void main(String[] args) {
        int j;
      //  j+=2;
      //  System.out.println(j);
//        String str = "Welcome";
//        str = str.concat(" to Java");
//        System.out.println(str);
        //System.out.println(se(4123));
        
//        Integer i =  null;
//        if(i != null & i.intValue()==5)
//        {
//            System.out.println("abc");
//        }
        
//        try{
//            
//        }
//        catch(Exception e){
//            
//        }
//        catch(ArithmeticException a)
//        {
//            
//        }
        
//        String s = new String("Hello");
//        char c ='H';
//        c+=s;
//        System.out.println(c);

//System.out.println(i);
        
        
           AA a = new AA();
           a.x = 100;
           fun(a);
           System.out.println(a.x);
        
        
//        int prim =5;
//        Integer wrap = new Integer(10);
//        //prim = wrap;
//        //wrap = prim;
//        //wrap = 9;
//        prim = new Integer(9);
//        System.out.println(prim+" , " +wrap);
    }
    
}
