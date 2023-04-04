public interface LibraryUser {
    abstract void registerAccount();
    abstract void requestBook();
}
class KidUsers implements LibraryUser{

    int age;
    String bookType;
   KidUsers(int age, String booktype){
       this.age=age;
       this.bookType=booktype;
   }
    public void registerAccount(){
        if(this.age<12)
            System.out.println("You have successfully registered as a Kid");
        else
            System.out.println("Sorry, Age must be less than 12 to register as a kid");
    }
    public void requestBook(){
        if(bookType.equals("Kids"))
            System.out.println("Book Issued successfully, please return the book within 10 days");
        else
            System.out.println("Oops, you are allowed to take only kids books");
    }
}
class AdultUser implements LibraryUser{

    int age;
    String bookType;
    AdultUser(int age, String booktype){
        this.age=age;
        this.bookType=booktype;
    }
    public void registerAccount(){
        if(this.age>12)
            System.out.println("You have successfully registered under an Adult Account");
        else
            System.out.println("Sorry, Age must be greater than 12 to register as an adult");
    }
    public void requestBook(){
        if(bookType.equals("Fiction"))
            System.out.println("Book Issued successfully, please return the book within 7 days");
        else
            System.out.println("Oops, you are allowed to take only adult Fiction books");
    }
}
