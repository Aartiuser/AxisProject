package ExceptionHandling;
class InvalidAgeException extends Exception{
    public InvalidAgeException(String message){
        super(message);
    }
}
class InvalidCountryException extends Exception{
    public InvalidCountryException(String message){
        super(message);
    }

}

public class RegisterProfile {
    void userRegistration(String name,int age,String country) throws InvalidAgeException,InvalidCountryException{
        if(!"India".equals(country))
            throw new InvalidCountryException("User outside India is not eligible");
        if(age<18)
            throw new InvalidAgeException("User is a minor");
    }

    public static void main(String[] args) {
        RegisterProfile reg=new RegisterProfile();
        try{
            reg.userRegistration("Aarti",21,"USA");

        }catch(InvalidAgeException e){
            System.out.println(e.getMessage());
        }catch(InvalidCountryException c){
            System.out.println(c.getMessage());
        }

    }
}
