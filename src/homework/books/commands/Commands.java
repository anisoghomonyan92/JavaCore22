package homework.books.commands;

public interface Commands {
    int EXIT = 0;
    int ADD_AUTHOR = 1;
    int PRINT_ALL_AUTHORS = 2;
    int ADD_BOOK = 3;
    int PRINT_ALL_BOOKS = 4;
    int PRINT_BOOKS_BY_AUTHOR_NAME = 5;
    int PRINT_BOOKS_BY_GENRE = 6;
    int PRINT_BOOKS_BY_PRICE_RANGE = 7;


    static void printCommands() {
        System.out.println("Please input" + EXIT + "for exit");
        System.out.println("Please input"+ ADD_AUTHOR+ "for add author");
        System.out.println("Please input"+ PRINT_ALL_AUTHORS+ "for print all authors");
        System.out.println("Please input" + ADD_BOOK + "for add book");
        System.out.println("Please input" + PRINT_ALL_BOOKS + "for print all books");
        System.out.println("Please input" + PRINT_BOOKS_BY_AUTHOR_NAME + "for print books by author name");
        System.out.println("Please input" + PRINT_BOOKS_BY_GENRE + "for print books by ganre");
        System.out.println("Please input" + PRINT_BOOKS_BY_PRICE_RANGE + "for print books by price range");


    }
}
