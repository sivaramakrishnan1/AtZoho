import java.io.Serializable;

public class Book implements Serializable {
    private int bookId, rackNo;
    private String title, dueDate, copyId;
    private String[] authors, publishers;
    private User borrowedBy = null;

    Book(int bookId, int rackNo, String title, String copyId, String[] authors, String[] publishers) {
        this.bookId = bookId;
        this.rackNo = rackNo;
        this.title = title;
        this.copyId = copyId;
        this.authors = authors;
        this.publishers = publishers;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getAuthorsString() {
        String str = "";

        for (int i = 0; i < authors.length; i++) {
            str += authors[i];
            if (i == authors.length - 1)
                return str;
            else
                str += ",";
        }
        return str;
    }

    public String getPublishersString() {
        String str = "";

        for (int i = 0; i < publishers.length; i++) {
            str += publishers[i];
            if (i == publishers.length - 1)
                return str;
            else
                str += ",";
        }
        return str;
    }

    public String getCopyId() {
        return copyId;
    }

    public String getBorrowedByName() {
        if(borrowedBy == null) return "";
        return borrowedBy.getId() + "";
    }

    public boolean borrowingBook(User borrowedBy, String dueDate) {
        if (this.borrowedBy != null)
            return false;
        rackNo = -1;
        this.borrowedBy = borrowedBy;
        this.dueDate = dueDate;
        return true;
    }

    public boolean returnBook(int rackNo) {
        if (this.borrowedBy == null)
            return false;

        this.rackNo = rackNo;
        this.borrowedBy = null;
        this.dueDate = null;
        return true;
    }

    public boolean isBorrowed()
    {
        if(borrowedBy == null) return false;
        else return true;
    }

    public String toString() {
        return String.format("%-10s%-3d%-20s%-15s%-15s%-3d%-5s%-10s\n", copyId, bookId, title, getAuthorsString(), getPublishersString(),  (rackNo + 1), getBorrowedByName(), ((dueDate == null) ? "" : dueDate));
    }

    public String toStringUser() {
        return String.format("%-10s%-3d%-20s%-15s%-15s%-3d%-10s\n",copyId, bookId, title, getAuthorsString(), getPublishersString(), (rackNo + 1), ((dueDate == null) ? "" : dueDate));
    }
}
