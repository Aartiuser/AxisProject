package Streams;

import java.io.*;
import java.util.Scanner;

public class BuffOutStream {

        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter String to write in file: ");
            String str="\n"+sc.nextLine();
            int ch;
            try {
                FileOutputStream fo = new FileOutputStream("C:\\Users\\traumaa\\Desktop\\data.txt",true);
                BufferedOutputStream bf=new BufferedOutputStream(fo);
                bf.write(str.getBytes());
                bf.flush();
                System.out.println("Details entered Successfully!");

            }catch(FileNotFoundException fileNotFound){
                fileNotFound.printStackTrace();
            }catch(IOException ioexp){
                ioexp.printStackTrace();
            }

        }
    }
