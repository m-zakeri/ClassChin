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
import jclasschin.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author HP
 */
public class FieldManager
{

    private static Field field;
    private static Session session;

    public static boolean insert(String fieldName)
    {
        field = new Field();
        field.setName(fieldName);

        try
        {
            session = (Session) HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(field);
            session.getTransaction().commit();
           
            return true;
        }

        catch (HibernateException he)
        {
            return false;
        }

    }

    public static boolean delete(int fieldId)
    {
       try
        { 
            session = (Session) HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Field f = (Field) session.load(Field.class, fieldId);
            session.delete(f);
            session.getTransaction().commit(); 
            return true;
        }
        catch (HibernateException he)
        {
            return false;
        }
    }
    
    public static boolean update(int fieldId, String newFieldName)
    {
        try
        { 
            session = (Session) HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Field f = (Field) session.load(Field.class, fieldId);
            f.setName(newFieldName);
            session.update(f);
            session.getTransaction().commit(); 
            return true;
        }
        catch (HibernateException he)
        {
            he.printStackTrace();
            return false;
        }
        
    }

    public static List selectAll()
    {
        try
        {

            session = (Session) HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            //Query q = session.createQuery(hql);
            List resultList = session.createQuery("from Field").list();
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
    
    public static Field selectByName(String fieldName){
        
        try
        {

            session = (Session) HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            Query q = session.createQuery("from Field f where f.name=:fn");
            q.setParameter("fn", fieldName);
            
            List resultList = q.list();
                    //session.createQuery("from Field f where f.name=\""+fieldName+"\"").list();
            session.getTransaction().commit();
            
             field=(Field) resultList.get(0);
             return field;
           
        }
        catch (HibernateException he)
        {
            he.printStackTrace();
        }
        return null;
        
    }

}
