package homework.books;

import java.util.Scanner;

public class BookDemo implements Commands {

    private static Scanner scanner = new Scanner(System.in);
    private static BookStorage bookStorage = new BookStorage();

    public static void main(String[] args) {

        boolean run = true;
        while (run) {
            System.out.println("Please input" + EXIT + "for exit");
            System.out.println("Please input" + ADD_BOOK + "for add book");
            System.out.println("Please input" + PRINT_ALL_BOOKS + "for print all books");
            System.out.println("Please input" + PRINT_BOOKS_BY_AUTHOR_NAME + "for print books by author name");
            System.out.println("Please input" + PRINT_BOOKS_BY_GENRE + "for print books by ganre");
            System.out.println("Please input" + PRINT_BOOKS_BY_PRICE_RANGE + "for print books by price range");
            int command = Integer.parseInt(scanner.nextLine());

            switch (command) {
                case EXIT:
                    run = false;
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
        String mn=scanner.nextLine();
        double min=Double.parseDouble(mn);

        System.out.println("Please input price max range");
        String mx=scanner.nextLine();
        Double max=Double.parseDouble(mx);

        bookStorage.printBooksByPriceOfRange( min,max);

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
        scanner.nextLine();
        System.out.println("Please input book title");
        String title = scanner.nextLine();
        System.out.println("Please input book's authorName");
        String autherName = scanner.nextLine();
        System.out.println("Please input book's  price ");
        String price = scanner.nextLine();
        System.out.println("Please input book's count");
        String count = scanner.nextLine();
        System.out.println("Please input book's genre");
        String genre = scanner.nextLine();

        int cn = Integer.parseInt(count);
        double pr = Double.parseDouble(price);
        Book book = new Book(title, autherName, pr, cn, genre);
        bookStorage.add(book);
        System.out.println("Thank you,student added.");

    }
}