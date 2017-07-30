package com.codegirl;

import com.codegirl.model.Address;
import com.codegirl.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Şeyma Yılmaz on 30.7.2017.
 */
public class HibernateTest {

    public static final SimpleDateFormat dateFormat=new SimpleDateFormat
            ("dd/MM/yyyy");

    public static void main(String[] args) {
        Configuration configuration=new Configuration();
        configuration.configure();

        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Person person1=new Person();
        person1.setName("ŞEYMA");
        person1.setAge(23);
        Date person1Date = null;
        try {
            person1Date = dateFormat.parse("18/03/1994");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        person1.setBirthday(person1Date);

        Address homeAddress = new Address();
        homeAddress.setCity("Sivas");
        homeAddress.setCountry("Türkiye");
        homeAddress.setPostCode("58000");
        homeAddress.setStreet("Merkez");

        Address jobAddress = new Address();
        jobAddress.setCity("Kocaeli");
        jobAddress.setCountry("Türkiye");
        jobAddress.setPostCode("41000");
        jobAddress.setStreet("Merkez");

        person1.getAddressList().add(homeAddress);
        person1.getAddressList().add(jobAddress);

        session.save(person1);


        Person person2=new Person();
        person2.setName("burak");
        person2.setAge(22);
        Date person2Date=null;
        try {
            person2Date=dateFormat.parse("29/06/1995");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        person2.setBirthday(person2Date);
        person2.getAddressList().add(homeAddress);
        person2.getAddressList().add(jobAddress);

        session.save(person2);

        session.getTransaction().commit();
        session.close();
    }

}
