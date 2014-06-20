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
import jclasschin.entity.Coursetype;
import jclasschin.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Ali
 */
public class CourseTypeManager
{

    private  Session session;

    public List selectAll()
    {
        try
        {

            session = (Session) HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List resultList = session.createQuery("from Coursetype").list();
            session.getTransaction().commit();
            //session.close();
            //HibernateUtil.getSessionFactory().close();
            return resultList;

        }
        catch (HibernateException he)
        {
            return null;
        }

    }

    public Coursetype selectByName(String type)
    {
        try
        { 
            session = (Session) HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("from Coursetype where type=:t");
            q.setParameter("t", type);
            List resultList = q.list();
            session.getTransaction().commit();
            //session.close();
            //HibernateUtil.getSessionFactory().close();
            return (Coursetype) resultList.get(0);

        }
        catch (HibernateException he)
        {
            return null;
        }

    }

}
