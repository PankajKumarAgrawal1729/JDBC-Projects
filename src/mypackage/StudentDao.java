package mypackage;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDao {

    static Connection con = DbConnection.getConnection();

    public void createDatabase() {
        String query = "create database jdbcDB";
        try {
            Statement st = con.createStatement();
            boolean created = st.execute(query);
            if (!created) {
                System.out.println("Database created Successfully");
            } else {
                System.out.println("DB not created");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        String query = "create table student (rollno int PRIMARY KEY, sname VARCHAR(25), email VARCHAR(200))";
        try {
            Statement st = con.createStatement();
            boolean created = st.execute(query);
            if (!created) {
                System.out.println("Table created Successfully");
            } else {
                System.out.println("Table not created");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertData(Student student) {
        String query = Query.INSERT.getQuery();
        try {

            PreparedStatement st = con.prepareStatement(query);

            st.setInt(1, student.getStudentRollNo());
            st.setString(2, student.getStudentName());
            st.setString(3, student.getStudentMail());
            int added = st.executeUpdate();
            System.out.println(added + " Row/s affected successfully!!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isStudentPresent(int rollno) {
        String query = Query.READONESTUDENT.getQuery() + rollno;
        boolean result = true;
        try {
            Statement st = con.createStatement();
            result = st.executeQuery(query).next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void readOneStudentData(int rollno) {
        String query = Query.READONESTUDENT.getQuery() + rollno;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            String userData = "Student Roll no.: " + rs.getInt(1) + "\nStudent Name: " + rs.getString(2)
                    + "\nStudent e-mail id: " + rs.getString(3);
            System.out.println(userData + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void readTable() {
        String query = Query.READ.getQuery();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            int num = 0;
            while (rs.next()) {
                System.out.println("Student no. " + (++num) + " Data.");
                String userData = "Student Roll no.: " + rs.getInt(1) + "\nStudent Name: " + rs.getString(2)
                        + "\nStudent e-mail id: " + rs.getString(3);
                System.out.println(userData + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateNameOrEmail(int rollno, String change, boolean isNameUpdate) {
        String query = isNameUpdate ? Query.UPDATENAME.getQuery() + rollno : Query.UPDATEEMAIL.getQuery() + rollno;
        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, change);
            int count = st.executeUpdate();
            System.out.println(count + " row/s affected");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteData(int rollno) {
        String query = Query.DELETE.getQuery() + rollno;
        try {
            PreparedStatement st = con.prepareStatement(query);
            int count = st.executeUpdate();
            System.out.println(count + " row/s affected");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
