class LibraryItem {
    protected String title;
    protected String id;

    public LibraryItem(String title, String id) {
        this.title = title;
        this.id = id;
    }

    public void display_info() {
        System.out.println("Library Item:");
        System.out.println("Title: " + title);
        System.out.println("ID: " + id);
    }
}

class Book extends LibraryItem {

    public Book(String title, String id) {
        super(title, id);
    }

    @Override
    public void display_info() {
        System.out.println("Book Information:");
        System.out.println("Book Title: " + title); 
        System.out.println("Book ID: " + id); 
    }
}

public class Lab6Ex5 {
    public static void main(String[] args) {
        Book b = new Book("Java Programming", "BK102");

        b.display_info();

    }
}
