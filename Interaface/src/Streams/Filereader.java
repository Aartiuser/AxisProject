package Streams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Filereader {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();
        try {
            FileReader file = new FileReader("C:\\Users\\traumaa\\Desktop\\data.txt");
            int chars;
            while ((chars = file.read()) != -1) {
                str.append((char) chars);
                //System.out.println((char)chars);
            }
            file.close();
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException ioexp) {
            ioexp.printStackTrace();
        } finally {
            String reversedStr = "";
            for (int i = str.length()-1; i >0 ; i--)
                reversedStr += str.charAt(i) ;
            System.out.println(reversedStr);
        }
    }
}

