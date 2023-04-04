public interface Shape {
    static final double pi=3.14;
    abstract double calculateArea();
    abstract double calculatePerimeter();
abstract String color();

}
class Square implements Shape{
    double side;
    Square(double s){
        this.side=s;
    }

    @Override
    public double calculateArea() {
        return (this.side*this.side);
    }

    @Override
    public double calculatePerimeter() {
        return(4*this.side);
    }

    @Override
    public String color() {
        return null;
    }
}
class Circle implements Shape{
    double rad;

    Circle(double r){
        this.rad=r;
    }
    @Override
    public double calculateArea() {
        return pi*this.rad*this.rad;
    }

    @Override
    public double calculatePerimeter() {
        return 2*pi*this.rad;
    }

    @Override
    public String color() {
        return null;
    }
}
class Rectangle implements Shape{
    double length,breadth;
    Rectangle(double l,double b){
        this.length=l;
        this.breadth=b;
    }

    @Override
    public double calculateArea() {
        return(this.length*this.breadth);
    }

    @Override
    public double calculatePerimeter() {
        return(2*(this.length+this.breadth));
    }

    @Override
    public String color() {
        return null;
    }
}