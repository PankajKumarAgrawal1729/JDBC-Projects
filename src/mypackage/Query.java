package mypackage;

public enum Query {
    INSERT("Insert into student values (?, ?, ?)"),
    READ("select * from student"),
    READONESTUDENT("select * from student where rollno="),
    UPDATENAME("update student set sname = ? where rollno="),
    UPDATEEMAIL("update student set email = ? where rollno="),
    DELETE("delete from student where rollno=");

    private String value;

    private Query(String value) {
        this.value = value;
    }

    public String getQuery() {
        return this.value;
    }
}
