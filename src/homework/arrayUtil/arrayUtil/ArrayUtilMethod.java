package homework.arrayUtil.arrayUtil;

public class ArrayUtilMethod {

    int max(int[] array){
        int max=array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i]>array[0]){
                max= array[i];
            }


        }

        return max;
    }
     int min(int[] array){
        int min=array [0];
         for (int i = 1; i < array.length; i++) {
             if(array[i]<min){
                 min=array[i];
             }

         }

         return min;
     }

     int zuyger(int [] array){

         for (int i = 0; i < array.length; i++) {
             if(array[i]%2==0){
                 System.out.print(array[i]);

             }

         }

         return 0;
     }

     int kenter(int [] array){
         for (int i = 0; i < array.length; i++) {
             if(array[i]%2!=0){
                 System.out.print(array [i]);
             }

         }return 0;
     }

     int zuygeriQanak(int [] array){
        int count=0;
         for (int i = 0; i < array.length; i++) {
             if(array[i]%2==0){
                 count++;
             }

         }return count;
     }

     int kenteriQanaky(int [] array){
        int oddCount=0;
         for (int i = 0; i < array.length; i++) {
             if(array[i]%2!=0){
                 oddCount++;
             }

         }return oddCount;
     }
    int sum=0;
     int arraySum(int[] array){
         for (int i = 0; i < array.length; i++) {
             sum=sum+array[i];

         }return sum;

     }
     int avg(int[] array){
        int avg1=0;
         for (int i = 0; i < array.length; i++) {
             avg1=sum/ array.length;


         }return avg1;
     }


}
