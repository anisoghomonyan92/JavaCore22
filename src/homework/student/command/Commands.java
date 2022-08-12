package homework.student.command;

public interface Commands {
    int LOGOUT = 0;
    int ADD_LESSON = 1;
    int PRINT_ALL_LESSONS = 2;
    int ADD_STUDENT = 3;
    int PRINT_ALL_STUDENTS = 4;
    int PRINT_STUDENTS_BY_STUDENTS_COUNT = 5;
    int DELETE_STUDENTS_BY_INDEX = 6;
    int PRINT_STUDENTS_BY_LESSON = 7;
    int CHANGE_STUDENT_LESSON = 8;

    int EXIT = 0;
    int LOGIN = 1;
    int REGISTER = 2;


    static void printCommands() {
        System.out.println("Please input " + LOGOUT + " for logout");
        System.out.println("Please input " + ADD_LESSON + " for Add lesson");
        System.out.println("Please input " + PRINT_ALL_LESSONS + " for print all lessons");
        System.out.println("Please input " + ADD_STUDENT + " for add student");
        System.out.println("Please input " + PRINT_ALL_STUDENTS + " for print all student");
        System.out.println("Please input " + PRINT_STUDENTS_BY_STUDENTS_COUNT + " for students count");
        System.out.println("Please input " + DELETE_STUDENTS_BY_INDEX + " for delete students by index");
        System.out.println("Please input " + PRINT_STUDENTS_BY_LESSON + " for print studens by lesson");
        System.out.println("Please input " + CHANGE_STUDENT_LESSON + " for change student's lesson");


    }

    static void printLoginCommands() {
        System.out.println("Please input " + EXIT + " for EXIT");
        System.out.println("Please input " + LOGIN + " for LOGIN");
        System.out.println("Please input " + REGISTER + " for register");

    }




}

