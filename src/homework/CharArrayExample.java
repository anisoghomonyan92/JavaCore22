package homework;

public class CharArrayExample {
    public static void main(String[] args) {

//*/char1
        char[] chars = {'j', 'a', 'v', 'a', 'l', 'o', 'v', 'e'};
        char c = 'o';
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                count++;
            }

        }
        System.out.println("count =" + count);

//        char2

        char[] chars2 = {'j', 'a', 'v', 'a', 'l', 'o', 'v', 'e'};
        int middleIndex = chars.length / 2;
        System.out.println(chars[middleIndex - 1]);
        System.out.println(chars[middleIndex]);

//        char3

        char[] chars3 = {'j', 'a', 'v', 'a', 'l', 'o', 'l', 'y'};
        char x = chars3[chars.length - 2];
        char y = chars3[chars.length - 1];
        if (x == 'l' && y == 'y') {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

//        char4

        char[] bobArray = {'b', 'a', 'b', 'o', 'l', 'a'};
        boolean bobResult = false;
        for (int i = 0; i < bobArray.length; i++) {
            if (bobArray[i] == 'b' && bobArray[i + 2] == 'b') {
                bobResult = true;
                break;
            }

        }
        System.out.println("bobResult=" + bobResult);

//        char5

        char[] spaceArray = {' ', 'b', 'a', 'b', ' ', 'o', 'l', 'a', ' '};
        for (char c1 : spaceArray) {
            if (c1 != ' ') {
                System.out.print(c1);

            }
        }


    }
}
