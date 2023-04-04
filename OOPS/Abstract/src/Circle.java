public class Circle extends Shape {
    int radius;
    Circle(int r){
        this.radius=r;
    }
    double calculateArea(){
        return 3.14*this.radius*this.radius;
    }
}
