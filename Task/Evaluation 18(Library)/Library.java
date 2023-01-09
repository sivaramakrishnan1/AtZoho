import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Library implements Serializable {
    private int freeRacks;
    private Book[] racks;
    HashMap<String, Book> bookCopyDB = new HashMap<>();
	
    Library(int size) {
        racks = new Book[size];
        freeRacks = size;
        System.out.println("Library created with " + size + " racks");
    }

    public boolean addBook(int id, String title, String a, String p, String c) {
        String[] authors = a.split(",");
        String[] publishers = p.split(",");
        String[] copyId = c.split(",");

        // incase of trying to insert books more than aailable space
        if (copyId.length > freeRacks) {
            System.out.println("Rack not available");
            return false;
        }

        System.out.print("Added books to rack : ");
        for (int i = 0; i < copyId.length; i++) {
            if (bookCopyDB.containsKey(copyId[i])) {
                System.out.println("A book with " + copyId[i] + " already exist in DB");
                continue;
            } else if (bookCopyDB.size() == racks.length) {
                System.out.println("Available free racks are alloted to borrowed books");
                continue;
            }
            int freeRack = findFreeRack();
            racks[freeRack] = new Book(id, freeRack, title, copyId[i], authors, publishers);
            bookCopyDB.put(copyId[i], racks[freeRack]);
            System.out.print((freeRack + 1) + " ");
        }
        System.out.println();
        updateLibrary();
        return true;
    }

    public int findFreeRack() {
        for (int i = 0; i < racks.length; i++) {
            if (racks[i] == null)
                return i;
        }
        return -1;
    }

    public boolean removeBook(String bookCopyId) {
        if (!bookCopyDB.containsKey(bookCopyId)) {
            System.out.println("No such book in Library");
            return false;
        }

        int rackNo = -1;
        for (int i = 0; i < racks.length; i++) {
            if(racks[i] != null && racks[i].getCopyId().equals(bookCopyId))
            {
                rackNo = i;
                break;
            }
        }
        if(rackNo == -1) 
        {
            System.out.println("Book is borrowed and not yet returned");
            return false;
        }

        racks[rackNo] = null;
        bookCopyDB.remove(bookCopyId);
        updateLibrary();
        return true;
    }

    public boolean borrowBook(int bookId, User borrowedBy, String dueDate) {
        int rackPos = -1;

        for (int i = 0; i < racks.length; i++) {
            if (bookId == racks[i].getBookId())
                rackPos = i;
        }

        if (rackPos == -1) {
            System.out.println("Book not available (or) Invalid book ID");
            return false;
        }

        //checking if the user borrowed 5 books
        if(borrowedBy.isFull())
        {
            System.out.println("User cannot ");
            return false;
        }

        if(bookCopyDB.containsKey(racks[rackPos].getCopyId()))
        	bookCopyDB.put(racks[rackPos].getCopyId(), racks[rackPos]);
        else
        	System.out.println("Book not in DB");
        
        racks[rackPos].borrowingBook(borrowedBy, dueDate);
        borrowedBy.addBook(racks[rackPos]);
        racks[rackPos] = null;
        updateLibrary();
        return true;
    }

    public boolean borrowBookCopy(String copyId, User borrowedBy, String dueDate) {
        int rackPos = -1;

        for (int i = 0; i < racks.length; i++) {
            if (racks[i] != null && copyId.equals(racks[i].getCopyId()))
                rackPos = i;
        }

        if (rackPos == -1) {
            System.out.println("Book not available (or) Invalid book ID");
            return false;
        }
        
        //checking if the user borrowed 5 books
        if(borrowedBy.isFull())
        {
            System.out.println("User cannot ");
            return false;
        }
        
        if(bookCopyDB.containsKey(copyId))
        	bookCopyDB.put(copyId, racks[rackPos]);
        else
        	System.out.println("Book not in DB");
        
        racks[rackPos].borrowingBook(borrowedBy, dueDate);
        borrowedBy.addBook(racks[rackPos]);
        racks[rackPos] = null;
        updateLibrary();
        return true;
    }

    public boolean returnBook(Book b, String copyId, User u) {
        // checking if the book to be returned is part of the library
        if (!bookCopyDB.containsKey(copyId)) {
            System.out.println("Cannot add book that is not a part of Library");
            return false;
        }

        int freeRack = findFreeRack();

        // checking if rack is full
        if (freeRack == -1) {
            System.out.println("Rack full");
            return false;
        }

        b.returnBook(freeRack);
        racks[freeRack] = b;
        updateLibrary();
        return true;
    }

    public void printBorrwed() {
        for (Book b : bookCopyDB.values()) {
            if (b.isBorrowed())
                System.out.println(b.toString());
        }
    }

    public void adminSearch(int type, String find) {
        for (int i = 0; i < racks.length; i++) {
            if(type == 0) // search by book id
            {
                if(racks[i] != null && racks[i].getBookId() + "" == find)
                {
                    System.out.println(racks[i].toString());
                }
            }
            else if(type == 1) // search by book title
            {
                if(racks[i] != null && racks[i].getTitle().equals(find))
                {
                    System.out.println(racks[i].toString());
                }
            }
            else if(type == 2) // search by author
            {
                if(racks[i] != null && racks[i].getAuthorsString().contains(find))
                {
                    System.out.println(racks[i].toString());
                }
            }
            else if(type == 3) // search by publisher
            {
                if(racks[i] != null && racks[i].getPublishersString().contains(find))
                {
                    System.out.println(racks[i].toString());
                }
            }
            else if(type == 4) // search by book copy id
            {
                if(racks[i] != null && racks[i].getCopyId().equals(find))
                {
                    System.out.println(racks[i].toString());
                }
            }
        }
    }

    public void userSearch(int type, String find) {
        for (int i = 0; i < racks.length; i++) {
            if(type == 0) // search by book id
            {
                if(racks[i] != null && "" + racks[i].getBookId() == find)
                {
                    System.out.println(racks[i].toStringUser());
                }
            }
            else if(type == 1) // search by book title
            {
                if(racks[i] != null && racks[i].getTitle().equals(find))
                {
                    System.out.println(racks[i].toStringUser());
                }
            }
            else if(type == 2) // search by author
            {
                if(racks[i] != null && racks[i].getAuthorsString().contains(find))
                {
                    System.out.println(racks[i].toStringUser());
                }
            }
            else if(type == 3) // search by publisher
            {
                if(racks[i] != null && racks[i].getPublishersString().contains(find))
                {
                    System.out.println(racks[i].toStringUser());
                }
            }
            else if(type == 4) // search by book copy id
            {
                if(racks[i] != null && racks[i].getCopyId().equals(find))
                {
                    System.out.println(racks[i].toStringUser());
                }
            }
        }
    }

    public void updateLibrary() {
        try (FileWriter writer = new FileWriter("Files\\DB.txt")) {
            for (Book b : bookCopyDB.values()) {
                writer.write(b.toString());
            }
            
            writer.close();
        } catch (IOException e) {
            System.out.println("Error with updating file : " + e);
        }
    }

    public void viewDataBase()
    {
        try (Scanner s = new Scanner(new File("Files\\DB.txt"))) {
            while(s.hasNextLine())
            {
                System.out.println(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}