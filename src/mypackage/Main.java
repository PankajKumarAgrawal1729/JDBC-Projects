package mypackage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        Scanner sc = new Scanner(System.in);
        boolean runProgram = true;
        while(runProgram){
            System.out.println(
                "1. Insert New Student\n2. Update Student Data\n3. Delete Student Data\n4. Read One Student Data\n5.Read Whole Student Data\n6. Exit");
        System.out.println("Enter Your Choice:");
        int choice = sc.nextInt();
        switch (choice) {
            case 1: // insert student data
                System.out.println("Enter number of student wants to add: ");
                int studentCount = sc.nextInt();
                for (int i = 0; i < studentCount; i++) {
                    System.out.println("Enter data of Student " + (i + 1));
                    System.out.println("Enter Student Roll no.");
                    int rollno = sc.nextInt();
                    System.out.println("Enter Student name:");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.println("Enter Student e-mail id");
                    String email = sc.nextLine();
                    Student student = new Student(rollno, name, email);
                    studentDao.insertData(student);
                }
                break;
            case 2:
                System.out.println("Enter Student Roll No.:");
                int rollno = sc.nextInt();
                if (studentDao.isStudentPresent(rollno)) {
                    System.out.println("1. Want to change Name.\n2. Want to change Email Id");
                    int change = sc.nextInt();
                    sc.nextLine();
                    if (change == 1) {
                        System.out.println("Enter Updated Name:");
                        String name = sc.nextLine();
                        studentDao.updateNameOrEmail(rollno, name, true);
                    } else if (change == 2) {
                        System.out.println("Enter Updated Email Id:");
                        String email = sc.nextLine();
                        studentDao.updateNameOrEmail(rollno, email, false);
                    } else {
                        System.out.println("Enter correct Choice.");
                    }
                } else {
                    System.out.println("Student is not Present.\nTry Again!!");
                }
                break;

            case 3:
                System.out.println("Enter Student Roll No.:");
                int deletedRollno = sc.nextInt();
                if (studentDao.isStudentPresent(deletedRollno)) {
                    studentDao.deleteData(deletedRollno);
                } else {
                    System.out.println("Student is not Present.\nTry Again!!");
                }
                break;

            case 4:
                System.out.println("Enter Student Roll No.:");
                int studentRollno = sc.nextInt();
                if (studentDao.isStudentPresent(studentRollno)) {
                    studentDao.readOneStudentData(studentRollno);
                } else {
                    System.out.println("Student is not Present.\nTry Again!!");
                }
                break;

            case 5:
                studentDao.readTable();
                break;
            
            case 6:
            runProgram = false;
            break;

            default:
                System.out.println("Enter correct Choice.");
                break;
        }
        }
       
    }
}
