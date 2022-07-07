package homework.books.storage;

import homework.books.model.Authenticator;
import homework.student.exception.LessonNotFaundException;
import homework.student.model.Lesson;


public class AuthenticatorStorage {
    private Authenticator[] array = new Authenticator[10];
    int size = 0;


    public void add(Authenticator authenticator) {
        if (size == array.length) {
            increaseArray();
        }
        array[size++] = authenticator;


    }

    private void increaseArray() {
        Authenticator[] temp = new Authenticator[array.length + 10];
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
            System.out.println("Authenticator deleted");
        } else {
            System.out.println("Index out of baunds");
        }
    }

}



