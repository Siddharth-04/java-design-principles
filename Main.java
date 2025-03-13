import java.util.ArrayList;

// Book class
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book [Title: " + title + ", Author: " + author + "]";
    }
}

// Library class
class Library {
    private String name;
    private ArrayList<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("Books in " + name + " Library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

// Main class to demonstrate aggregation
public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("1984", "George Orwell");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee");

        // Reference variables
        Library library1 = new Library("City Library");
        Library library2 = new Library("Community Library");

        // Adding books to libraries
        library1.addBook(book1);
        library1.addBook(book2);
        library2.addBook(book3);

        // Displaying books in libraries
        library1.displayBooks();
        library2.displayBooks();
    }
}

//        Books in City Library Library:
//        Book [Title: The Great Gatsby, Author: F. Scott Fitzgerald]
//        Book [Title: 1984, Author: George Orwell]
//        Books in Community Library Library:
//        Book [Title: To Kill a Mockingbird, Author: Harper Lee]
