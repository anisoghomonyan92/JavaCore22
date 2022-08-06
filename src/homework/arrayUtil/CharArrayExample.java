package homework.arrayUtil;

public class CharArrayExample {
    public static void main(String[] args) {
// 1
        char[] chars = {'j', 'a', 'v', 'a', 'l', 'o', 'v', 'e'};
        char c = 'o';
        int count=0;
        for (int i = 0; i < chars.length; i++) {
            if(c==chars[i]){
                count++;
            }
        }
        System.out.println("Count = "+ count);

//2
        char[] chars2= {'j','a','v','a','l','o','v','e'};
        int middleIndex=chars2.length/2;
         System.out.print(chars2[middleIndex]);
        System.out.println();

//3
       char[] chars3={'j','a','v','a','l','o','l','y'};
        char x= chars3[chars.length-2];
        char y= chars3[chars.length-1];
        boolean result=false;
        if(x=='l' && y=='y'){
            result=true;
        }
        System.out.print(result);
        System.out.println();
//4
        char [] bobArray={'b','a','b','o','l','a'};
        boolean bobResult=false;
        for (int i = 0; i <bobArray.length-2; i++) {
            if(bobArray [i]=='b' && bobArray[i+2]=='b'){
                bobResult=true;
                break;
            }


        }
        System.out.print("bobresult = " + bobResult);
        System.out.println();

//5
        char[] text= {' ',' ','b','a','r','e','v',' ',' '};
        for (char c1 : text) {
            if(c1 !=' '){
                System.out.print(c1);
            }

        }









    }
}
