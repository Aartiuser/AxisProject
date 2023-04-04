package Streams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BuffReader {
    public static void main(String[] args) {
        String line=null;
        try{
            FileReader file=new FileReader("C:\\Users\\traumaa\\Desktop\\data.txt");
            BufferedReader bf=new BufferedReader(file);
            while((line=bf.readLine())!=null){
                System.out.println(line);
            }
            file.close();
            bf.close();
        }catch(FileNotFoundException fo){
            fo.printStackTrace();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

    }
}
