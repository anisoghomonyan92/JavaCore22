package homework.arrayUtil;

public class ArraySpaceExample {
    public static void main(String[] args) {
        char[] spaseArray = {' ', ' ', 'c', 'a', 't', ' ', 'b', 'i', ' ', 'b', ' ', ' '};
        int startIndex = 0;
        int endIndex = spaseArray.length - 1;
        for (int i = 0; i < spaseArray.length; i++) {
            if (spaseArray[startIndex] == ' ') {
                startIndex++;
            } else {
                break;
            }

        }
        for (int i = endIndex; i>0; i--) {
            if (spaseArray[endIndex] == ' ') {
                endIndex--;
            }else {
                break;
            }

        }
        int newLenght=(endIndex-startIndex)+1;
        char[] result= new char[newLenght];
        int j=0;
        for (int i = startIndex; i <= endIndex; i++) {
            result[j++]= spaseArray[i];

        }
        for (char c : result) {
            System.out.print(c);

        }


    }
}
