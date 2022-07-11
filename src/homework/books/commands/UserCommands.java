package homework.books.commands;

public interface UserCommands {
    int LOGOUT=0;
    int ADD_AUTHOR = 1;
    int PRINT_ALL_AUTHORS = 2;
    int ADD_BOOK = 3;
    int PRINT_ALL_BOOKS = 4;



    static void printUserCommands(){
        System.out.println("Please input " + LOGOUT + " for LOGOUT");
        System.out.println("Please input "+ ADD_AUTHOR+ " for add author");
        System.out.println("Please input "+ PRINT_ALL_AUTHORS+ " for print all authors");
        System.out.println("Please input "+ ADD_BOOK+ " for add book");
        System.out.println("Please input " + PRINT_ALL_BOOKS + " for print all books");


    }

}
