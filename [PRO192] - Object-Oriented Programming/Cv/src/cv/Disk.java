/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv;

/**
 *
 * @author xhunt
 */
public class Disk {
    private String owner;
    private  String color; 
    private String smile;
    private double radius;
    private double area;
    private double primeter;
    
            
   // làm cá phễu để đổ thông tin con dog cụ thể nào đó vào khuôn- hàm khởi tạo
    public Disk(String owner, String color, String smile, double radius) {
        this.owner = owner;// phễu quy tắc k có void
        this.color = color;// this nói về chính mình
        this.smile = smile;
        this.radius = radius;
    }
    
    public void showDisk() {
        System.out.println("Owner is " + owner);
        System.out.println("Color is " + color);
        System.out.println("Smile is " + smile);
        System.out.println("Radius is " + radius);
        

        
             
        
    }
     @Override //dính dáng đến kế thừa( Inheritance )
    public String toString() {
        return "Disk{" + "owner=" + owner+ ", color=" + color + ", smile=" + smile + ", radius=" + radius + '}';
    }
    
    public void computerArea(){
        
        area = radius * radius * 3.14;
        System.out.println("Area is: "+area);
    }
    public void computerPrimeter(){
        primeter = 2 * 3.14 * radius;
        System.out.println("Primeter is :" +primeter);
    
    
}
     public void setowner (String owner) {
        this.owner = owner;
    }
    public void setcolor (String color) {
        this.color = color;
    }
    public String getowner () {
        return owner; 
    }
    public String getcolor () {
        return color; 
}
}
