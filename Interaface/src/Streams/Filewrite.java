package Streams;

import javax.imageio.IIOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Filewrite {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String to add in file: ");
        String str=sc.nextLine();
        try{
            FileWriter file=new FileWriter("C:\\Users\\traumaa\\Desktop\\data.txt",true);
            file.write(str);
            file.close();
            System.out.println("String written Successfully!");
        }catch(FileNotFoundException fof){
            fof.printStackTrace();
        }catch (IOException io){
            io.printStackTrace();
        }

    }
}
