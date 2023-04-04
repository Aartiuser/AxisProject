public class InterfaceDemo {
    public static void main(String[] args){
        double rad=4.5,side=4.0,len=5,bred=6.2;

        Shape s=new Square(side);
        System.out.println("Area of Square with side "+side+ " is: "+s.calculateArea());
        System.out.println("Perimeter of Square with side "+side+ " is: "+s.calculatePerimeter());

        s=new Circle(rad);
        System.out.println("Area of Circle with radius "+rad +" is: "+s.calculateArea());
        System.out.println("Perimeter of Circle with radius "+rad+ " is: "+s.calculatePerimeter());

        s=new Rectangle(len,bred);
        System.out.println("Area of Rectangle with sides "+len+","+bred+ " is: "+s.calculateArea());
        System.out.println("Perimeter of Rectangle with sides "+len+","+bred+ " is: "+s.calculatePerimeter());
    }
}
