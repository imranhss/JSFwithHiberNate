package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import model.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.DbCon;
import util.HibernateUtil;



public class StudentDao {
    
    
    public boolean addStudent(Student s) {
        
        Transaction t = null;

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            t = session.beginTransaction();
            session.save(s);            
            t.commit();
           
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            t.rollback();
        }
        finally{
        
            session.close();
        }
        
        return false;
    }

    public void deleteStudent(int id) {
        Transaction t = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            t = session.beginTransaction();
            Student stud = (Student) session.load(Student.class, new Integer(id));
            session.delete(stud);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Student> getbyID(int id) {

        Student student = new Student();
        List<Student> sList = new ArrayList<Student>();

        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            trans = session.beginTransaction();

            Query query = session.createQuery("from Student where id= :id");
            query.setInteger("id", id);
            student = (Student) query.uniqueResult();
            sList = query.list();

            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sList;
    }
    
    public List<Student> viewAllStudent()
    {
       
        List allList=new ArrayList();        
        Student stud=new Student();
        
        Transaction trans=null;
        
        Session session=HibernateUtil.getSessionFactory().openSession();
        try
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Student");
            
            allList=query.list();
            
            allList.add(stud.getGivenName());
            allList.add(stud.getLastName());
            allList.add(stud.getSubject());
            allList.add(stud.getGender());           
         
            trans.commit();
            
        }
        catch(Exception e)
        {
            
        }
        return allList;
    }
    
    
    public void updateStudent(Student student)
    {
        Transaction trans=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            session.update(student);
            trans.commit();
        }
        catch(Exception e)
        {
            e.printStackTrace();  
        }
        
    }

}
