package homework.books;

import homework.books.commands.Commands;
import homework.books.model.Author;
import homework.books.model.Book;
import homework.books.storage.AuthorStorage;
import homework.books.storage.BookStorage;

import java.util.Scanner;

public class BookDemo implements Commands {

    private static Scanner scanner = new Scanner(System.in);
    private static BookStorage bookStorage = new BookStorage();
    private static AuthorStorage authorStorage = new AuthorStorage();


    public static void main(String[] args) {


        boolean run = true;
        while (run) {
            Commands.printCommands();
            int command = Integer.parseInt(scanner.nextLine());

            switch (command) {
                case EXIT:
                    run = false;
                    break;
                case ADD_AUTHOR:
                    addAuthor();
                    break;
                case PRINT_ALL_AUTHORS:
                    authorStorage.print();
                    break;
                case ADD_BOOK:
                    addBook();
                    break;
                case PRINT_ALL_BOOKS:
                    bookStorage.print();
                    break;
                case PRINT_BOOKS_BY_AUTHOR_NAME:
                    printBooksByAuthorName();
                    break;
                case PRINT_BOOKS_BY_GENRE:
                    printBooksByGanre();
                    break;
                case PRINT_BOOKS_BY_PRICE_RANGE:
                    printBooksByPriceRange();
                    break;


                default:
                    System.out.println("Invalid command,please try again");


            }
        }
    }

    private static void printBooksByPriceRange() {
        System.out.println("Please input price min range");
        String mn = scanner.nextLine();
        double min = Double.parseDouble(mn);

        System.out.println("Please input price max range");
        String mx = scanner.nextLine();
        Double max = Double.parseDouble(mx);

        bookStorage.printBooksByPriceOfRange(min, max);

    }


    private static void printBooksByGanre() {
        System.out.println("Please input book's ganre");
        String ganre = scanner.nextLine();
        bookStorage.printBooksByGanre(ganre);
    }

    private static void printBooksByAuthorName() {
        System.out.println("Please input auther name");
        String autherName = scanner.nextLine();
        bookStorage.printBooksByAutherName(autherName);
    }

    private static void addBook() {
        if (authorStorage.getSize() == 0) {
            System.out.println("Please add author");
            addAuthor();
        } else {
            bookStorage.print();
            System.out.println("Please choose author index");
            int authorIndex = Integer.parseInt(scanner.nextLine());
            Author author = authorStorage.getAuthorByIndex(authorIndex);
            if (author == null) {
                System.out.println("Please input correct index");
                addBook();
            } else {

                System.out.println("Please input book title");
                String title = scanner.nextLine();
                System.out.println("Please input book's  price ");
                String price = scanner.nextLine();
                System.out.println("Please input book's count");
                String count = scanner.nextLine();
                System.out.println("Please input book's genre");
                String genre = scanner.nextLine();

                int cn = Integer.parseInt(count);
                double pr = Double.parseDouble(price);
                Book book = new Book(title, author, pr, cn, genre);
                bookStorage.add(book);
                System.out.println("Thank you,book added.");

            }
        }
    }

    private static void addAuthor() {
        System.out.println("Please input author name");
        String name = scanner.nextLine();

        System.out.println("Please input author surname");
        String surname = scanner.nextLine();

        System.out.println("Please input email");
        String email = scanner.nextLine();

        System.out.println("Please input gender(MALE or FEMALE)");
        String gender = scanner.nextLine();

        Author author = new Author(name, surname, email, gender);
        authorStorage.add(author);
        System.out.println("Author created!");
    }
}