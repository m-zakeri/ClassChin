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
import jclasschin.entity.Classroom;
import jclasschin.entity.Field;
import jclasschin.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author HP
 */
public class ClassManager
{

    Session session;
    Classroom classroom;

    public boolean insert(String className, String floor, Integer capacity,
            boolean whiteBoard, boolean blackBoard, boolean videoProject)
    {
        classroom = new Classroom(className, floor, capacity, videoProject, blackBoard, whiteBoard, "", null);
        classroom.setName(className);

        try
        {
            session = (Session) HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(classroom);
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
            List resultList = session.createQuery("from Classroom").list();
            session.getTransaction().commit();
            return resultList;
        }
        catch (HibernateException he)
        {
            return null;
        }

    }

    public boolean update(int classId, String className, String floor, Integer capacity, Boolean vp, Boolean wb, Boolean bb)
    {
        try
        {
            session = (Session) HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            classroom = (Classroom) session.load(Classroom.class, classId);
            classroom.setName(className);
            classroom.setFloor(floor);
            classroom.setCapacity(capacity);
            classroom.setDataProjector(vp);
            classroom.setWhiteboard(wb);
            classroom.setBlackboard(bb);

            session.update(classroom);
            session.getTransaction().commit();
            return true;
        }
        catch (HibernateException he)
        {
            return false;
        }

    }

    public boolean delete(Integer classId)
    {
        try
        {
            session = (Session) HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            classroom = (Classroom) session.load(Classroom.class, classId);

            session.delete(classroom);
            session.getTransaction().commit();
            return true;
        }
        catch (HibernateException he)
        {
            return false;
        }
    }

}
