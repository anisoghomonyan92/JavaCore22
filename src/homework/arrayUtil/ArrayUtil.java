package homework.arrayUtil;

public class ArrayUtil {
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 6, 8, 10, 0, 7, 11, 15};
        /*Tpel bolor elementnery*/
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");


        }
        System.out.println();

        /*Tpel amenamec tivy*/
        int max = array[0];
        for (int i = 1; i < array.length; i++) {

            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("max=" + max);

        /*Tpel minimumy*/

        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }

        }
        System.out.println("min=" + min);
        System.out.println();
        System.out.println("Zuyger:");

        /*tpel bolor zuyg elementnery*/

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                System.out.print(array[i]);
            }
        }
        System.out.println();
        System.out.println("Kenter:");


        /*tpel bolor kent tvery*/
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                System.out.print(array[i]);

            }
        }
        System.out.println();

        /*tpel zuygeri qanaky*/
        int  countofEvens=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] %2==0) {
                countofEvens++;
            }

            }
        System.out.println("Zuygeri qanaky="+countofEvens);
        System.out.println();

        /*tpel kenteri qanaky*/
        int countofOdds=0;
        for (int i = 0; i < array.length; i++) {
            if( array [i] %2!=0){
                countofOdds++;
            }

        }
        System.out.println("Kenteri qanaky="+ countofOdds);

        double sum=0;
        for (int i = 0; i < array.length; i++) {
            sum=sum+array [i];

        }
        System.out.println("Sum="+sum);
        double  avg= sum/ array.length;
        System.out.println("Avg="+ avg);


        }


    }

