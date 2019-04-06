public class Console {

    public static void main(String[] args) 
    {
        System.out.println("Hello");
        int a[] = {1,2,3,4,5};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] +",");
        }
        System.out.println("");
        for (int _ : a) {
            System.out.print(_ +",");
        }
        System.out.println("");
        for (int _ : a) {
            _+=10;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] +",");
        }
        System.out.println("");
    }
    
}
