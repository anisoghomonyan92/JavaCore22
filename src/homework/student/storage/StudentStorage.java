package homework.student.storage;


import homework.student.model.Student;

public class StudentStorage {
    private Student[] array = new Student[10];
    int size = 0;


    public void add(Student student) {
        if (size == array.length) {
            increaseArray();
        }
        array[size++] = student;


    }

    private void increaseArray() {
        Student[] temp = new Student[array.length + 10];
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
            System.out.println("Student deleted");
        } else {
            System.out.println("Index out of baunds");
        }
    }

    public Object printStudentsByLesson(String lessonName) {
        for (int i = 0; i < size; i++) {
            if (array[i].getLesson().equals(lessonName)) {
                System.out.println(array[i]);
            }

        }
        return null;
    }

    public Student getStudentByIndex(int index) {
        if (index >= 0 && index < size) {
            return array[index];
        }
        return null;

    }



}



