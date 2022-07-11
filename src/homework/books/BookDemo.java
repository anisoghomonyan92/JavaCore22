package homework.books;

import homework.books.commands.Commands;
import homework.books.commands.UserCommands;
import homework.books.exception.AuthorNotFoundException;

import homework.books.model.*;
import homework.books.storage.AuthorStorage;
import homework.books.storage.BookStorage;
import homework.books.storage.UserStorage;


import java.util.Scanner;

public class BookDemo implements Commands {


    private static Scanner scanner = new Scanner(System.in);
    private static BookStorage bookStorage = new BookStorage();
    private static AuthorStorage authorStorage = new AuthorStorage();

    private static UserStorage userStorage = new UserStorage();
    private static User currentUser = null;


    public static void main(String[] args) {
        User admin =new User("admin","admin","admin@mail.ru","admin",Role.ADMIN);
        userStorage.add(admin);
        boolean run = true;
        while (run) {
            Commands.printLoginCommands();
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
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                default:
                    System.out.println("Invalid command,please try again");

            }


        }
    }

    private static void register() {
        System.out.println("Please input name,surname,email,password");
        String userDataStr = scanner.nextLine();
        String[] userData = userDataStr.split(",");
        if (userData.length < 4) {
            System.out.println("Please input correct user data");
        } else {
            if (userStorage.getUserByEmail(userData[2]) == null) {
                User user = new User();
                user.setName(userData[0]);
                user.setSurname(userData[1]);
                user.setEmail(userData[2]);
                user.setPassword(userData[3]);
                user.setROLE(Role.USER);
                userStorage.add(user);
                System.out.println("User  registred!");

            } else {
                System.out.println("User with " + userData[2] + " already  exists!");
            }
        }

    }

    private static void login() {
        System.out.println("Please  input email,password");
        String emailPasswordStr = scanner.nextLine();
        String[] emailPassword = emailPasswordStr.split(",");
        User user = userStorage.getUserByEmail(emailPassword[0]);
        if (user == null) {
            System.out.println("User does not exist");
        } else {
            if (!user.getPassword().equals(emailPassword[1])) {
                System.out.println("Password is wrong!");
            } else {
                currentUser = user;
                if (user.getROLE() == Role.ADMIN) {
                    adminLogin();
                } else if (user.getROLE() == Role.USER) {
                    userLogin();

                }
            }
        }

    }

    private static void userLogin() {
        System.out.println("Welcome, " + currentUser.getName());
        boolean run = true;
        while (run) {
            UserCommands.printUserCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }

            switch (command) {
                case UserCommands.LOGOUT:
                    run = false;
                    break;
                case UserCommands.ADD_AUTHOR:
                    addAuthor();
                    break;
                case UserCommands.PRINT_ALL_AUTHORS:
                    authorStorage.print();
                    break;
                case UserCommands.ADD_BOOK:
                    addBook();
                    break;

                case UserCommands.PRINT_ALL_BOOKS:
                    bookStorage.print();
                    break;

                default:
                    System.out.println("Invalid command,please try again");


            }

        }
    }

    private static void adminLogin() {
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
                case LOGOUT:
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
        bookStorage.printBooksByAuthorName(autherName);
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
                String countStr = scanner.nextLine();
                System.out.println("Please input book's genre");
                String genre = scanner.nextLine();

                int count = Integer.parseInt(countStr);
                double pr = Double.parseDouble(price);
                Book book = new Book(title, author, pr, count, genre, currentUser);
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