package homework.books;

public class BookStorage {
    private Book[] array = new Book[10];
    int size = 0;


    public void add(Book book) {
        if (size == array.length) {
            increaseArray();
        }
        array[size++] = book;


    }

    private void increaseArray() {
        Book[] temp = new Book[array.length + 10];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];

        }
        array = temp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + ". " + array[i] + " ");

        }


    }

    public int getSize() {
        return size;
    }


    public void printBooksByAutherName(String autherName) {
        for (int i = 0; i < size; i++) {
            if (array[i].getOuterName().equals(autherName)) {
                System.out.println(array[i]);
            }

        }


    }

    public void printBooksByGanre(String ganre) {
        for (int i = 0; i < size; i++) {
            if (array[i].getGenre().equals(ganre)) {
                System.out.println(array[i]);
            }

        }

    }

    public void printBooksByPriceOfRange(double min, double max) {
        for (int i = 0; i < array.length; i++) {
            Book book = array[i];
            if (book!=null && book.getPrice() >= min && book.getPrice() <= max) {
                System.out.println(book);


            }
        }


    }


}

