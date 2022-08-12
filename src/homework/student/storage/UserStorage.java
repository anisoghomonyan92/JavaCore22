package homework.student.storage;


import homework.student.model.Student;
import homework.student.model.User;

public class UserStorage {
    private User[] array = new User[10];
    int size = 0;


    public void add(User user) {
        if (size == array.length) {
            increaseArray();
        }
        array[size++] = user;


    }

    private void increaseArray() {
        User[] temp = new User[array.length + 10];
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
            System.out.println("User deleted");
        } else {
            System.out.println("Index out of baunds");
        }
    }

    public User getUserByEmail(String email) {
        for (int i = 0; i < size; i++) {
            if(array[i].getEmail().equals(email)){
                return array[i];
            }

        }return null;

    }







}



