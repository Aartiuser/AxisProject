package Streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInStream {
    public static void main(String[] args) {
        int vow=0,space=0,n=0;
        StringBuffer content=null;
        FileInputStream fileStream=null;
        int ch;
        try{
            fileStream=new FileInputStream("C:\\Users\\traumaa\\Desktop\\data.txt");
            content=new StringBuffer();
            while((ch=fileStream.read())!=-1){
                content.append((char)ch);
                if(ch=='a' || ch=='A'|| ch=='e'|| ch=='E'||ch=='i'|| ch=='I'||ch=='o'||ch=='u'||ch=='U')
                    vow++;
                if(ch==' ')
                    space++;
                if(ch=='\n')
                    n++;
            }
        }catch(FileNotFoundException fileNotFound){
            fileNotFound.printStackTrace();
        }catch (IOException ioexp){
            ioexp.printStackTrace();
        }finally{
            try{
                System.out.println(content);
                System.out.println("Number of vowels: "+vow);
                System.out.println("Number of spaces: "+space);
                System.out.println("Number of words: "+(space+n+1));
                fileStream.close();
            }catch(IOException ioexp){
                ioexp.printStackTrace();;
            }
        }
    }
}
