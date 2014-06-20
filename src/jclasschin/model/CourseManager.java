/*
 * The MIT License
 *
 * Copyright 2014 Ali.
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
import jclasschin.entity.Course;
import jclasschin.entity.Coursetype;
import jclasschin.entity.Field;
import jclasschin.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Ali
 */
public class CourseManager
{

    private Course course;
    private Session session;
    private CourseTypeManager courseTypeManager;
    private FieldManager fieldManager;

    public boolean insert(String courseName, String courseType)
    {
        courseTypeManager = new CourseTypeManager();
        fieldManager = new FieldManager();
        course = new Course();
        course.setName(courseName);
        course.setCoursetype(courseTypeManager.selectByName(courseType));
        course.setField(fieldManager.selectByName(Login.loggedUserField));

        try
        {
            session = (Session) HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
            return true;

        }
        catch (HibernateException e)
        {
            return false;
        }
//        finally
//        {
//            session.close();
//        }
    }

    public List selectAll()
    {
        try
        {
            session = (Session) HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List resultList = session.createQuery("from Course").list();
            session.getTransaction().commit();
            return resultList;
        }
        catch (HibernateException he)
        {
            return null;
        }
//        finally
//        {
//            session.close();
//        }

    }
    public List selectAllByFieldName(String filedName)
    {
        try
        {
            session = (Session) HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("from Course c where c.field.name=:cfn");
            q.setParameter("cfn", filedName);
            List resultList = q.list();
            session.getTransaction().commit();
            return resultList;
        }
        catch (HibernateException he)
        {
            return null;
        }
    }

    public boolean update(Integer id,String type, String name)
    {
        try
        {
            session = (Session) HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            course = (Course) session.load(Course.class, id);
            Field field = (Field) session.load(Field.class, Login.loggedUserID);
            courseTypeManager  = new CourseTypeManager();
            Coursetype coursetype = courseTypeManager.selectByName(type);
            course.setName(name);
            course.setField(field);
            course.setCoursetype(coursetype);
            session.update(course);
            session.getTransaction().commit();
            return true;
        }
        catch (HibernateException e)
        {
            return false;
        }
    }

    public boolean delete(Integer id)
    {
        try
        {
            session = (Session) HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            course = (Course) session.load(Course.class, id);
            session.delete(course);
            session.getTransaction().commit();
            return true;
        }
        catch (HibernateException e)
        {
            return false;
        }
    }

}
