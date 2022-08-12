package homework.student.command;

public interface UserCommands {

    int LOGOUT=0;
    int PRINT_ALL_LESSONS=1;
    int ADD_STUDENT=2;
    int PRINT_ALL_STUDENTS=3;
    int PRINT_STUDENTS_BY_STUDENTS_COUNT=4;
    int PRINT_STUDENTS_BY_LESSON=5;

    static void printUserCommands() {
        System.out.println("Please input " + LOGOUT + " for logout");
        System.out.println("Please input " + PRINT_ALL_LESSONS + " for print all lessons");
        System.out.println("Please input " + ADD_STUDENT + " for add student");
        System.out.println("Please input " + PRINT_ALL_STUDENTS + " for print all student");
        System.out.println("Please input " + PRINT_STUDENTS_BY_STUDENTS_COUNT + " for students count");
        System.out.println("Please input " + PRINT_STUDENTS_BY_LESSON + " for print studens by lesson");

    }
}
