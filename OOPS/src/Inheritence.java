abstract class TwoDObjects{
    TwoDObjects(){
    }
    abstract float getArea();
    abstract float getArea(int s1,int s2,int s3);
    abstract float getArea(int s1,int s2);
    abstract float getPerimeter();
}
class Rectangle extends TwoDObjects{
    float length;
    float breadth;
    Rectangle(){
    }
    Rectangle(float L, float B){
        this.length=L;
        this.breadth=B;
    }

    public float getLength() {
        return length;
    }
    public void setLength(float length) {
        this.length = length;
    }
    public float getBreadth() {
        return breadth;
    }
    public void setBreadth(float breadth) {
        this.breadth = breadth;
    }
    public float getArea() {
        return length*breadth;
    }
    public float getArea(int s1,int s2,int s3){
        return 0;
    }
    public float getArea(int s1,int s2){
        return 0;
    }
    public float getPerimeter() {
        return   2*(length+breadth);
    }
}
class Triangle extends TwoDObjects{
    int side1,side2,side3;
    Triangle(){

    }
    Triangle(int s1,int s2,int s3){
        this.side1=s1;
        this.side2=s2;
        this.side3=s3;
    }
    public float getArea(){
        return 0;
    }
    public float getArea(int s1,int s2,int s3) {
        this.side1=s1;
        this.side2=s2;
        this.side3=s3;
        float s=(float)(this.side1+this.side2+this.side3)/2.0f;
        float area=(float)(Math.sqrt(s*(s-side1)*(s-side2)*(s-side3)));
        return area;
    }
    public float getArea(int s1,int s2){
        this.side1=s1;
        this.side2=s2;
        float area=(0.5f)*this.side1*this.side2;
        return area;
    }

    public float getPerimeter() {
        return (this.side1+this.side2+this.side3);
    }
}
class Square extends TwoDObjects {
    int side;

    Square() {
    }

    Square(int s) {
        this.side = s;
    }

    public float getArea() {
        return (this.side * this.side);
    }

    public float getPerimeter() {
        return (4 * this.side);
    }
    public float getArea(int s1,int s2,int s3){
        return 0;
    }
    public float getArea(int s1,int s2){
        return 0;
    }
    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }
}

    public class Inheritence {
    public static void main(String[] args){
    TwoDObjects r=new Rectangle(4,5);
    TwoDObjects s=new Square(5);
    TwoDObjects t=new Triangle();
    System.out.println("Area and perimeter of Rectangle: "+r.getArea()+" and " +r.getPerimeter());
        System.out.println("Area and perimeter of Square: "+s.getArea()+" and " +s.getPerimeter());
        System.out.println("Area and perimeter of Triangle: "+t.getArea(3,4,5)+" and " +t.getPerimeter());
    }
}
