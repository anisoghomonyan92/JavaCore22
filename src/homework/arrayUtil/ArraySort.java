package homework.arrayUtil;

public class ArraySort {
    public static void main(String[] args) {
        int numbers[] = {1, 6, 55, 25, 32, 67, 0, 77};

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < numbers.length-i; j++) {
                if (numbers[j] < numbers[j - 1]) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = tmp;
                }
            }
        }
        for (int number : numbers) {
            System.out.print(number+ " ");

        }


    }
}
