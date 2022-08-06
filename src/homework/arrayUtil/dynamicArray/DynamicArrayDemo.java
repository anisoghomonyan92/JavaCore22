package homework.arrayUtil.dynamicArray;

import homework.arrayUtil.dynamicArray.DynamicArray;

public class DynamicArrayDemo {
    public static void main(String[] args) {
        DynamicArray array=new DynamicArray();
        array.add(5);
        array.add(7);
        array.add(6);
        array.add(63);
        array.add(62);
        array.add(99);
        array.add(33);
        array.add(65);
        array.printArray();
//        array.set(2,44);
//        array.add(3,55);
//        array.delete(3);
        array.printArray();
        array.isEmpty();



    }
}
