package CollectionFramework;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> bookList=new ArrayList<Book>();
    void addBook(Book bobj){
        bookList.add(bobj);
    }
    boolean isEmpty(){
        if(bookList.isEmpty())
            return true;
        return false;
    }
    ArrayList<Book> viewAllBooks(){
        return bookList;
    }
    public ArrayList<Book> viewBooksByAuthor(String author){
        ArrayList<Book> blist=new ArrayList<Book>();
        if(bookList.isEmpty())
            System.out.println("The list is empty");
        else{
            for(Book b :bookList)
            {
                if(b.getAuthor().equals(author))
                    blist.add(b);
            }
        }
        return blist;
    }
   public  int countnoofbook(String bname){
        int count=0;
        for(Book b :bookList)
        {
            if(b.getBookName().equals(bname))
                count++;
        }
        return  count;
    }
    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }
}
