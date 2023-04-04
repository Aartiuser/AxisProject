package Streams;
import java.io.*;
import java.util.Scanner;

public class FileOutStream {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String to write in file: ");
        String str=sc.nextLine();

        int ch;
        try {
            FileOutputStream fo = new FileOutputStream("C:\\Users\\traumaa\\Desktop\\data.txt",true);
            byte content[]=new byte[100];
            content=str.getBytes();
            fo.write(content);
            System.out.println("Details entered Successfully!");
            fo.close();
            }catch(FileNotFoundException fileNotFound){
                fileNotFound.printStackTrace();
            }catch(IOException ioexp){
                ioexp.printStackTrace();
            }

    }
}
