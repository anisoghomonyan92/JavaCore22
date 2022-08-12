package homework.student.storage;

import homework.student.exception.LessonNotFaundException;
import homework.student.model.Lesson;


public class LessonStorage {
    private Lesson[] array = new Lesson[10];
    int size = 0;


    public void add(Lesson lesson) {
        if (size == array.length) {
            increaseArray();
        }
        array[size++] =lesson;


    }

    private void increaseArray() {
        Lesson[] temp = new Lesson[array.length + 10];
        System.arraycopy(array, 0, temp, 0, size);
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
            System.out.println("Lesson deleted");
        } else {
            System.out.println("Index out of baunds");
        }
    }


    public Lesson getLessonByIndex(int index) throws LessonNotFaundException {
        if (index >= 0 && index < size) {
            return array[index];
        }else {
            throw new LessonNotFaundException("Lesson with " + index+"index does not exists");
        }


    }



}



