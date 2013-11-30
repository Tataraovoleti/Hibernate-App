/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import org.hibernate.*;
import org.hibernate.cfg.*;

/**
 *
 * @author TATARAO
 */
public class Client {
    
    public static void main(String[] args) {
        SessionFactory factory =new Configuration().configure().buildSessionFactory();
        
        Session session=factory.openSession();
     
        /*
         * Setting values to bean properties inorder to inserts the records
         
        Employee emp=new Employee();
        emp.setEid(102);
        emp.setEname("raja");
        emp.setSalary("20000");
        
        Transaction tx=session.beginTransaction();
        session.save(emp);
        tx.commit();
         */
        
        // Getting values from the database either by get() or by load()
        
        Employee emp=(Employee)session.get(Employee.class,new Integer(102));
        
        System.out.println("Employee name" + emp.getEname());
                System.out.println("Employee salary" + emp.getSalary());
        
        // updating record
        Transaction tx=session.beginTransaction();
        
        emp.setEname("rani");
        emp.setSalary("15000");
        
        tx.commit();
        
        session.close();
        factory.close();
    }
    
}
