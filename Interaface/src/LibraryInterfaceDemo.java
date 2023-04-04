public class LibraryInterfaceDemo {
    public static void main(String[] args){

        LibraryUser lib =new KidUsers(10,"Kids");
        lib.registerAccount();
        lib.requestBook(); //correct issue

      lib= new KidUsers(18,"Fiction"); //wrong issue
        lib.registerAccount();
        lib.requestBook();

        lib=new AdultUser(5,"Kids"); //wrong issue
        lib.registerAccount();
        lib.requestBook();

        lib= new AdultUser(23,"Fiction"); //correct issue
        lib.registerAccount();
        lib.requestBook();

    }
}
