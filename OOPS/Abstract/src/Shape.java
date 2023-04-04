public abstract class Shape {
String color;
abstract double calculateArea();
void setColor(String clr){
    this.color=clr;
    System.out.println("Colour of the Shape is: "+this.color);
}
}
