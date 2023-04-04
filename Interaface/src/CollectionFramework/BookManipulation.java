package CollectionFramework;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class BookManipulation {
    public static void main(String[] args) throws IOException {
        int choice;  Library lib=new Library();
        do{
            Scanner sc=new Scanner(System.in);
            BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
            Book bob=new Book();
            System.out.println("1.Add Book\n2.Display all book details\n3.Search Book by author\n4.Count number of books - by book name\n5.Exit");
            System.out.println("Enter your choice:");
            choice=sc.nextInt();
            switch(choice){
                case 1: {
                    System.out.println("Enter isbn no.: ");
                    bob.setIsbnno(sc.nextInt());
                    System.out.println("Enter Book Name: ");
                    bob.setBookName(bf.readLine());
                    System.out.println("Enter author name: ");
                    bob.setAuthor(bf.readLine());
                    lib.addBook(bob);
                    } break;
                case 2:{
                    ArrayList<Book> res=lib.viewAllBooks();
                    if(res.isEmpty())
                        System.out.println("lIST IS EMPTY");
                    else {
                        for(Book b:res){
                            System.out.println("isbn no: "+b.getIsbnno());
                            System.out.println("Book name: "+b.getBookName());
                            System.out.println("Author name: "+b.getAuthor());
                        }
                    }
                } break;
                case 3:{
                    ArrayList<Book> res;
                    System.out.println("Enter author name: ");
                    res=lib.viewBooksByAuthor(bf.readLine());
                    if(res.isEmpty())
                        System.out.println("None of the Books are written by the author");
                    else
                        System.out.println(res);
                } break;
                case 4:{
                    System.out.println("Enter Book Name: ");
                    System.out.println(lib.countnoofbook(bf.readLine()));
                } break;
            }
        }while(choice!=5);

    }
}
