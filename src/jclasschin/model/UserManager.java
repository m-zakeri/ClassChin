/*
 * The MIT License
 *
 * Copyright 2014 HP.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package jclasschin.model;

import java.util.List;
import jclasschin.entity.Field;
import jclasschin.entity.Job;
import jclasschin.entity.Person;
import jclasschin.entity.User;
import jclasschin.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author HP
 */
public class UserManager
{

    private User user;
    private Person person;

    private Field field;
    private FieldManager fieldManager;

    private Job job;
    private JobManager jobManager;

    private Session session;

    public boolean insert(String title, String firstName, String lastName, boolean sex, String phone,
            String username, String password, boolean state, String jobTitle, String fieldTitle)
    {
        fieldManager = new FieldManager();
        field = fieldManager.selectByName(fieldTitle);

        jobManager = new JobManager();
        job = jobManager.selectByName(jobTitle);

        person = new Person(firstName, lastName, sex);
        person.setTitle(title);
        person.setPhone(phone);
        person.setField(field);
        person.setJob(job);

        user = new User(person, username, password, state);

        try
        {
            session = (Session) HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(person);
            session.save(user);
            session.getTransaction().commit();
            return true;
        }
        catch (HibernateException he)
        {
            return false;
        }
    }
    
    
        public List selectAll()
    {
        try
        {

            session = (Session) HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            //Query q = session.createQuery(hql);
            List resultList = session.createQuery("from Person,").list();
            //displayResult(resultList);

            session.getTransaction().commit();
            return resultList;
        }
        catch (HibernateException he)
        {
            he.printStackTrace();
        }
        return null;
    }

}
