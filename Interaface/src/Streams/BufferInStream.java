package Streams;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferInStream {
    public static void main(String[] args) {
        FileInputStream file=null;
        BufferedInputStream bfin=null;
        try{
            file=new FileInputStream("C:\\Users\\traumaa\\Desktop\\data.txt");
            bfin=new BufferedInputStream(file);
            byte[] contents=new byte[1024];
            int bytesRead=0;
            String strcontent;
            while((bytesRead=bfin.read(contents))!=-1){
                strcontent=new String(contents,0,bytesRead);
                System.out.println("The Content of file read using BufferedInputStream is: "+strcontent);
            }
        }catch (IOException ioexp){
            ioexp.printStackTrace();
        }finally {
            try{
                bfin.close();
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        }
    }
}
