package homework.books;

import homework.books.commands.Commands;
import homework.books.exception.AuthorNotFoundException;
import homework.books.model.Author;
import homework.books.model.Book;
import homework.books.model.Gender;
import homework.books.storage.AuthenticatorStorage;
import homework.books.storage.AuthorStorage;
import homework.books.storage.BookStorage;

import java.util.Scanner;

public class BookDemo implements Commands {


    private static Scanner scanner = new Scanner(System.in);
    private static BookStorage bookStorage = new BookStorage();
    private static AuthorStorage authorStorage = new AuthorStorage();
    private static AuthenticatorStorage authenticatorStorage = new AuthenticatorStorage();


    public static void main(String[] args) {
        addAuthenticator();

        boolean run = true;
        while (run) {
            Commands.printCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
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

    private static void addAuthenticator() {
        System.out.println("login");
        String login = scanner.nextLine();
        System.out.println("password");
        String password = scanner.nextLine();

        if (login.equals("admin") && password.equals("123456")) {
            System.out.println("Authentication  completed");
        } else {
            System.out.println("Invalid login or password");
            addAuthenticator();
        }
    }

    private static void printBooksByPriceRange() {
        try {
            System.out.println("Please input price min range");
            String mn = scanner.nextLine();
            double min = Double.parseDouble(mn);

            System.out.println("Please input price max range");
            String mx = scanner.nextLine();
            Double max = Double.parseDouble(mx);
            bookStorage.printBooksByPriceOfRange(min, max);
        } catch (NumberFormatException e) {
            System.out.println("Number format does not exists");
            printBooksByPriceRange();
        }


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
            try {
                Author author = authorStorage.getAuthorByIndex(authorIndex);
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


            } catch (AuthorNotFoundException e) {
                System.out.println(e.getMessage());
                addBook();
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


        Gender gender = gender();
        Author author = new Author(name, surname, email, gender);
        authorStorage.add(author);

        System.out.println("Author created!");
    }

    private static Gender gender() {

        System.out.println("Select gender");


        Gender[] values = Gender.values();
        for (Gender value : values) {
            System.out.println(value + ",");
        }
        System.out.println();
        String gender = scanner.nextLine();

        try {
            return Gender.valueOf(gender.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Please input correct gender (MALE or FEMALE)");
            gender();

        }

        return Gender.valueOf(gender);
    }

}