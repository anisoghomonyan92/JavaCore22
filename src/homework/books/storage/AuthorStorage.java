package homework.books.storage;

import homework.books.exception.AuthorNotFoundException;
import homework.books.model.Author;


public class AuthorStorage {
    private Author[] array = new Author[10];
    int size = 0;


    public void add(Author author) {
        if (size == array.length) {
            increaseArray();
        }
        array[size++] =author;


    }

    private void increaseArray() {
        Author[] temp = new Author[array.length + 10];
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

    public void delete(int index) {
        if (index >= 0 && index < size) {
            for (int i = 0; i < size; i++) {
                array[index] = array[index + 1];

            }
            size--;
            System.out.println("Author deleted");
        } else {
            System.out.println("Index out of baunds");
        }
    }


    public Author getAuthorByIndex(int index) throws AuthorNotFoundException {
        if (index >= 0 && index < size) {
            return array[index];
        }else{
            throw new AuthorNotFoundException("Author with " + index+"index does not exists");
        }

    }

}



