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
public class Rectangle {
    private String owner;
    private  String color; 
    private double width;
    private double lenght;
    private double area;
    private double primeter;
    
            
   // làm cá phễu để đổ thông tin con dog cụ thể nào đó vào khuôn- hàm khởi tạo
    public Rectangle (String owner, String color, double width, double lenght) {
        this.owner = owner;// phễu quy tắc k có void
        this.color = color;// this nói về chính mình
        this.width = width;
        this.lenght = lenght;
    }
    
    public void showRetangle() {
        System.out.println("Owner is " + owner);
        System.out.println("Color is " + color);
        System.out.println("Width is " + width);
        System.out.println("Length is " + lenght);

        
             
        
    }
     @Override //dính dáng đến kế thừa( Inheritance )
    public String toString() {
        return "Rectangle{" + "owner=" + owner+ ", color=" + color + ", width=" + width + ", lenght=" + lenght + '}';
    }
    
    public void computerArea(){
        
        area = lenght * width;
        System.out.println("Area is: "+area);
    }
    public void computerPrimeter(){
        primeter = (lenght + width)* 2;
        System.out.println("Primeter is :" +primeter);
    
    
}
    public String getOwner () {
        return owner; 
    }
    
    public String getColor () {
        return color; 
    }
    public void setColor(String color) {
        this.color = color;
    }
    
    public void setOwner(String owner) {
        this.owner = owner;
    }
}
