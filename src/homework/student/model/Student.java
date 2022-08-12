package homework.student.model;

import homework.student.util.DateUtil;

import java.util.Date;

import static homework.student.util.DateUtil.dateToString;

public class Student {
    private String name;
    private String surname;
    private int age;
    private String phoneNumber;
    private String city;
    private  Lesson lesson;
    private User registeredUser;
    private Date registerDate;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public User getRegisteredUser() {
        return registeredUser;
    }

    public void setRegisteredUser(User registeredUser) {
        this.registeredUser = registeredUser;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", lesson='" + lesson + '\'' +
                ", registeredUser='" + registeredUser + '\'' +
                ", registeredDate='" + dateToString(registerDate)+ '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public Student(String name, String surname, int age, String phoneNumber, String city,Lesson lesson,User registeredUser, Date registredDate) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.lesson=lesson;
        this.registeredUser=registeredUser;
        this.registerDate = registerDate;

    }

    public Student() {
    }
}
