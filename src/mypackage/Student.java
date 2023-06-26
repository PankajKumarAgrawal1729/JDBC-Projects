package mypackage;

public class Student {
    private int rollno;
    private String name;
    private String email;

    public Student(int rollno, String name, String email) {
        this.rollno = rollno;
        this.name = name;
        this.email = email;
    }

    public int getStudentRollNo() {
        return this.rollno;
    }

    public String getStudentName() {
        return this.name;
    }

    public String getStudentMail() {
        return this.email;
    }

}
