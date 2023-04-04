public class Square extends Shape{
    int side;
    Square(int s){
        this.side=s;
    }
    double calculateArea(){
        return (this.side*this.side);
    }
}
