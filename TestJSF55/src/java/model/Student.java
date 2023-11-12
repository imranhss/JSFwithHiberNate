package model;
// Generated Nov 11, 2023 10:16:03 AM by Hibernate Tools 4.3.1

import dao.StudentDao;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;

/**
 * Student generated by hbm2java
 */

public class Student implements java.io.Serializable {

    private Integer id;
    private String givenName;
    private String lastName;
    private String subject;
    private String gender;

    public Student() {
    }

    public Student(String givenName, String lastName, String subject, String gender) {
        this.givenName = givenName;
        this.lastName = lastName;
        this.subject = subject;
        this.gender = gender;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGivenName() {
        return this.givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    StudentDao dao = new StudentDao();

//    public void save() throws ClassNotFoundException, SQLException {
//            Student s=new Student();
//        dao.addStudent(s);
//        System.out.println("-----------------");
//    }

}
