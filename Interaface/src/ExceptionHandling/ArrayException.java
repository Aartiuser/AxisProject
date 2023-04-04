package ExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayException {
    public void getPriceDetails() throws ArrayIndexOutOfBoundsException, InputMismatchException {
        int size,idx;
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the size of an array: ");
        size=sc.nextInt();
        int arr[]=new int[size];
        System.out.println("Enter price details: ");
        try {
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
        }catch(InputMismatchException i){
            System.out.println("\nInput was not in the correct format");
        }
        try{
            System.out.println("\nEnter the index to access: ");
            idx=sc.nextInt();
            System.out.println("\nThe array element is: "+arr[idx]);
        }
        catch(ArrayIndexOutOfBoundsException a){
            System.out.println("\nArray index is out of range");
        }
        catch(InputMismatchException i){
            System.out.println("\nInput was not in the correct format");
        }
    }

    public static void main(String[] args) {
        ArrayException ar=new ArrayException();
        ar.getPriceDetails();
    }
}
