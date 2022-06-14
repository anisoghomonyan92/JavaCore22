package homework.BraceChacker;

public class BraceCheckerTest {
    public static void main(String[] args) {

        String text = ("(He[ll)o fr]om {Java}");
        BraceChecker braceChecker = new BraceChecker(text);
        braceChecker.check();

    }
}







