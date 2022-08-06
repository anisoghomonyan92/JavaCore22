package homework.arrayUtil.arrayUtil;

import homework.arrayUtil.ArrayUtil;

public class ArrayUtilDemo {
    public static void main(String[] args) {
        int [] numbers={2,4,6,1,9,6};
        ArrayUtilMethod aum=new ArrayUtilMethod();
        System.out.println("max = "+aum.max(numbers));
        System.out.println("min = " +aum.min(numbers));
        System.out.println("zuyger = "+aum.zuyger(numbers));
        System.out.println("kenter = "+aum.kenter(numbers));
        System.out.println("Zuygeri qanaky = "+ aum.zuygeriQanak(numbers));
        System.out.println("Kenteri qanaky = "+ aum.kenteriQanaky(numbers));
        System.out.println("Array Sum = "+ aum.arraySum(numbers));
        System.out.println("Array Avg = "+ aum.avg(numbers));
    }
}
