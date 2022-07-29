package homework.collection;

import java.util.*;

public class CollectionExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("poxos");
        list.add("petros");
        list.add("martiros");
        list.add("seroj");
        list.add("aram");
        list.add("petros");
        list.add("babken");
        list.add("zaven");
        list.add("gogor");

        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(4);
        numberList.add(5);
        numberList.add(6);

        System.out.println(arrayToList(list.toArray(new String[0])));
        removeById(list, 0);
        listToSet(list);
        reverseNumbers(numberList);
        listToLinkedList(numberList);
        printFirstFive(list);
        sizeOfList(list);

    }

    static List<String> arrayToList(String[] values) {
        for (String s : values) {
            System.out.println(s);
        }
        return null;
    }

    static List<String> removeById(List<String> list, int index) {
        for (String s : list) {
            System.out.println(s);
        }
        list.remove(0);
        System.out.println(list);

        return null;
    }

    static Set<String> listToSet(List<String> list) {

        System.out.println(list.size());
        Set<String> setList = new HashSet<>();
        setList.addAll(list);
        System.out.println(setList);
        System.out.println(setList.size());

        return null;
    }

    static LinkedList<Integer> listToLinkedList(List<Integer> list) {
        List<Integer> linkedList = new LinkedList<>();
        linkedList.addAll(list);
        System.out.println(linkedList);
        return null;
    }

    static List<Integer> reverseNumbers(List<Integer> list) {
        Collections.reverse(list);
        System.out.println(list);
        return null;
    }

    static void printFirstFive(List<String> list) {
        List<String> subList = list.subList(0, 5);
        System.out.println(subList);


    }

    static int sizeOfList(List<String> list) {
        int size = list.size();
        System.out.println("The size of ArrayList is: " + size);

        return 0;
    }
}
