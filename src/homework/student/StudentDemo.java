package homework.student;


import homework.student.command.Commands;
import homework.student.command.UserCommands;
import homework.student.exception.LessonNotFaundException;
import homework.student.model.Lesson;
import homework.student.model.Role;
import homework.student.model.Student;
import homework.student.model.User;
import homework.student.storage.LessonStorage;
import homework.student.storage.StudentStorage;
import homework.student.storage.UserStorage;

import java.util.Date;
import java.util.Scanner;

import static homework.student.util.DateUtil.stringToDate;

public class StudentDemo implements Commands {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentStorage studentStorage = new StudentStorage();
    private static final LessonStorage lessonStorage = new LessonStorage();
    private static final UserStorage userstorage = new UserStorage();
    private  static User currentUser=null;

    public static void main(String[] args) {
        Lesson java = new Lesson("java", "teacher name", 33, 55,stringToDate("03/05/2022"));
        lessonStorage.add(java);
        Lesson php = new Lesson("php", "teacher name", 33, 55,stringToDate("10/06/2015"));
        lessonStorage.add(php);
        Lesson javaScript = new Lesson("javaScript", "teacher name", 33, 55,stringToDate("10/08/2020" +
                ""));
        lessonStorage.add(javaScript);

        User admin=new User ("admin", "admin", "admin@mail.com", "admin", Role.ADMIN);
        userstorage.add(admin);

        studentStorage.add(new Student("Poxos", "Poxosyan", 15, "123456", "Gyumri", java,admin,new Date()));
        studentStorage.add(new Student("Petros", "Petrosyan", 16, "123444", "Gyumri", php,admin,new Date()));
        studentStorage.add(new Student("Martiros", "Martirosyan", 16, "123444", "Gyumri", javaScript,admin,new Date()));


        boolean run = true;
        while (run) {
            Commands.printLoginCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case 0:
                    run = false;
                    break;
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                default:
                    System.out.println("Invalid command,please try again");

            }


        }
    }

    private static void login() {
        System.out.println("Please input email, passwword");
        String emailPasswordStr = scanner.nextLine();
        String[] emailPassword = emailPasswordStr.split(",");
        User user = userstorage.getUserByEmail(emailPassword[0]);
        if (user == null) {
            System.out.println("User does not exists!");
        } else {
            if (!user.getPassword().equals(emailPassword[1])) {
                System.out.println("Password is wrong!");
            } else {
                currentUser=user;
                if (user.getRole() == Role.ADMIN) {
                    adminLogin();
                } else if (user.getRole() == Role.USER) {
                    userLogin();

                }
            }
        }
    }


    private static void register() {
        System.out.println("Please input name, surname,email,password");
        String userDataStr = scanner.nextLine();
        String[] userData = userDataStr.split(",");
        if (userData.length < 4) {
            System.out.println("Please input correct user data");
        } else {
            if (userstorage.getUserByEmail(userData[2]) == null) {
                User user = new User();
                user.setName(userData[0]);
                user.setSurname(userData[1]);
                user.setEmail(userData[2]);
                user.setPassword(userData[3]);
                user.setRole(Role.USER);
                userstorage.add(user);
                System.out.println("User registred!");
            } else {

                System.out.println("User with" + " " + userData[2] + " " + "already exists");
            }
        }
    }

    private static void userLogin() {
        System.out.println("Welcome, "+ currentUser.getName());
        boolean run = true;
        while (run) {
            UserCommands.printUserCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case LOGOUT:
                    currentUser=null;
                    run = false;
                    break;

                case PRINT_ALL_LESSONS:
                    lessonStorage.print();
                    break;
                case ADD_STUDENT:
                    addStudent();
                    break;
                case PRINT_ALL_STUDENTS:
                    studentStorage.print();
                    break;
                case PRINT_STUDENTS_BY_STUDENTS_COUNT:
                    System.out.println(studentStorage.getSize());
                    break;

                case PRINT_STUDENTS_BY_LESSON:
                    searchStudentByLessonName();
                    break;


                default:
                    System.out.println("Invalid command,please try again");
            }
        }
    }

    private static void adminLogin() {
        boolean run = true;
        while (run) {
            Commands.printCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case LOGOUT:
                    currentUser=null;
                    run = false;
                    break;
                case ADD_LESSON:
                    addLesson();
                    break;
                case PRINT_ALL_LESSONS:
                    lessonStorage.print();
                    break;
                case ADD_STUDENT:
                    addStudent();
                    break;
                case PRINT_ALL_STUDENTS:
                    studentStorage.print();
                    break;
                case PRINT_STUDENTS_BY_STUDENTS_COUNT:
                    System.out.println(studentStorage.getSize());
                    break;
                case DELETE_STUDENTS_BY_INDEX:
                    deleteStudentByIndex();
                    break;
                case PRINT_STUDENTS_BY_LESSON:
                    searchStudentByLessonName();
                    break;
                case CHANGE_STUDENT_LESSON:
                    changeLesson();
                    break;


                default:
                    System.out.println("Invalid command,please try again");
            }
        }
    }

    private static void addLesson() {
        System.out.println("Please input lesson name");
        String name = scanner.nextLine();

        System.out.println("Please input lesson price");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.println("Please input teacher name");
        String teacherName = scanner.nextLine();

        System.out.println("Please input lesson duration by month");
        int duration = Integer.parseInt(scanner.nextLine());

        System.out.println("Please input lesson start date(14/04/2022)");
        String dateStr=scanner.nextLine();

        Lesson lesson = new Lesson(name, teacherName, duration, price,stringToDate(dateStr));
        lessonStorage.add(lesson);
        System.out.println("Lesson created!");
    }

    private static void searchStudentByLessonName() {
        System.out.println("Please input lesson name");
        String lessonName = scanner.nextLine();
        studentStorage.printStudentsByLesson(lessonName);
    }

    private static void deleteStudentByIndex() {
        studentStorage.print();
        System.out.println("Please choose student index");
        int index = Integer.parseInt(scanner.nextLine());
        studentStorage.delete(index);
    }

    public static void changeLesson() {
        studentStorage.print();
        System.out.println("Please choose student index for change student's lesson");
        int index = Integer.parseInt(scanner.nextLine());
        Student student = studentStorage.getStudentByIndex(index);
        if (student != null) {
            System.out.println("Please input  new lesson index");
            lessonStorage.print();
            System.out.println("Please choose lesson index");
            int lessonIndex = Integer.parseInt(scanner.nextLine());
            try {
                Lesson lesson = lessonStorage.getLessonByIndex(lessonIndex);
                student.setLesson(lesson);
                System.out.println("Lesson changed!");
            } catch (LessonNotFaundException e) {
                System.out.println(e.getMessage());
                changeLesson();
            }
        } else {
            System.out.println("Invalid index, please try again");
            changeLesson();
        }
    }

    private static void addStudent() {
        if (lessonStorage.getSize() == 0) {
            System.out.println("Please add lesson");
            addLesson();
        } else {
            lessonStorage.print();
            System.out.println("Please choose lesson index");
            int lessonIndex = Integer.parseInt(scanner.nextLine());
            try {
                Lesson lesson = lessonStorage.getLessonByIndex(lessonIndex);
                System.out.println("Please input student name");
                String name = scanner.nextLine();
                System.out.println("Please input student surname");
                String surname = scanner.nextLine();
                System.out.println("Please input student age");
                String ageStr = scanner.nextLine();
                System.out.println("Please input student phoneNumber");
                String phoneNumber = scanner.nextLine();
                System.out.println("Please input student city");
                String city = scanner.nextLine();


                int age = Integer.parseInt(ageStr);
                Student student = new Student(name, surname, age, phoneNumber, city, lesson,currentUser,new Date());
                studentStorage.add(student);
                System.out.println("Thank you,student added.");

            } catch (LessonNotFaundException e) {
                System.out.println(e.getMessage());
                addStudent();
            }


        }
    }
}

