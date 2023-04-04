public class AbstractDemo {
    public static void main(String[] args){
        int rad=5,side=4;
        Shape s=new Circle(rad);
        Shape s1=new Square(side);
        System.out.println("Area of Circle is: "+s.calculateArea());
        System.out.println("Area of Square is: "+s1.calculateArea());
        s.setColor("Blue");
        s1.setColor("Green");
    }
}
