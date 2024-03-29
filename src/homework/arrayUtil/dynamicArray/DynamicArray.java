package homework.arrayUtil.dynamicArray;

public class DynamicArray {
    private int[] array = new int[10];
    private int size = 0;

    public void add(int value) {
        if (size == array.length) {
            extend();
        }
        array[size++] = value;
    }
    public void add(int index, int value){
        if(size==array.length){
            extend();
        }
        for (int i = size; i <=index; i++) {
            array[i]=array[i-1];
        }
        array[index]=value;
        size++;

    }

    private void extend() {
        int[] temp = new int[array.length + 10];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");

        }
        System.out.println();
    }




    public boolean isEmpty() {

        return size == 0;
    }

    public int getByIndex(int index) {

        if (index >= 0 && index < size) {
            return array[index];
        }
        return 0;

    }

    public int getFirstIndexByValue(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return i;
            }
        }

        return -1;
    }

    public void set(int index, int value) {
        if (index >= 0 && index < size) {
            array[index] = value;

        }
    }
    public void delete(int index){
        if(index>0 && index<size){
            for (int i = index; i <size; i++) {
                array [i]=array[i+1];
            }
            size--;
        }
    }


}
