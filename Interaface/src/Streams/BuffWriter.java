package Streams;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BuffWriter {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String to write in file: ");
        String str=sc.nextLine();
        try{
            FileWriter fw=new FileWriter("C:\\Users\\traumaa\\Desktop\\data.txt");
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write(str);
            bw.flush();
            bw.close();
            fw.close();
        }catch(FileNotFoundException fof){
            fof.printStackTrace();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }finally {
            System.out.println("String written Successfully!");
        }
    }
}
