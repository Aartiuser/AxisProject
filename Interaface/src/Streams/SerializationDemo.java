package Streams;

import javax.imageio.IIOException;
import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) {
        System.out.println();
        try {
            Employee emp = new Employee(135234, "Ram",125000);
            System.out.println("Employee before serialization "+ emp);
            FileOutputStream fout = new FileOutputStream("C:\\Users\\traumaa\\Desktop\\Data\\Data.txt");
            //Serialization
            ObjectOutputStream outstream = new ObjectOutputStream(fout);
            outstream.writeObject(emp);
            outstream.flush();
            //fout.close();
            outstream.close();
        }
        catch (IIOException io )
        {
            io.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Employee emp;
            FileInputStream fin = new FileInputStream("C:\\Users\\traumaa\\Desktop\\Data\\Data.txt");
            ObjectInputStream instream = new ObjectInputStream(fin);
            emp = (Employee) instream.readObject();
            instream.close();
            System.out.println();
            System.out.println("Employee after deserialization "+emp);
        }
        catch (IIOException io )
        {
            io.printStackTrace();
        }
        catch (ClassNotFoundException cn)
        {
            cn.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}