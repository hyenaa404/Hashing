
package controller;

import java.util.Scanner;
import model.Book;
import model.BookList;
import model.MyHashTable;

/**
 *
 * @author nhs
 */
public class Controller {
    public static void main(String[] args) {
        BookList bl = new BookList();
        bl.readFile("books.csv");
        Book [] bookArray = bl.getBookList();
        MyHashTable<Book> hashTable = new MyHashTable(500000);
        for(Book b : bookArray){
            hashTable.put(b.getIsbn(), b);
        }
        searchBook(hashTable);
        

        
        
    }
    
    public static void searchBook(MyHashTable<Book> hashTable){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter isbn to search: ");
        String key = sc.nextLine();
        Book b = hashTable.get(key);
        if(b != null){
            b.toString();
        }else{
            System.out.println("Not found.");
        }
        System.out.println("Max Collisions: "+ hashTable.countCollision());
    }
}
