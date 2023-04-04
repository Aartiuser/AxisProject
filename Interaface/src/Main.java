 interface IVehicle{
   public abstract void drive();
    public abstract void turnleft();
    public abstract void brake();

}
interface IpublicTransport{
    public abstract void getNumberOfPeople();
}
class MotorisedVehicle {
public void checkMotor(){
    System.out.println("The motor of the vehicle is in good condition");
}

}
class Car extends MotorisedVehicle implements IVehicle{
    public void drive(){
        System.out.println("It drives in 4 Wheels");
    }
    public void turnleft(){
    System.out.println("The car is turning left");
    }
    public void brake(){
        System.out.println("The car is in brake mode");
    }

}
class Train implements IVehicle,IpublicTransport{
    public void drive(){
        System.out.println("It drives in many Wheels");
    }
    public void turnleft(){
        System.out.println("The train is turning left");
    }
    public void brake(){
        System.out.println("The train is in brake mode");
    }
    public void getNumberOfPeople(){
        System.out.println("Number of People are: ");
    }
}
public class Main {
    public static void main(String[] args) {
        IVehicle v=new Car();
        v.drive();
        v.brake();
        v.turnleft();

        v=new Train();
        v.drive();
        v.brake();
        v.turnleft();
        IpublicTransport p=new Train();
        p.getNumberOfPeople();

        MotorisedVehicle c=new Car();
        c.checkMotor();
    }
}