package model.BL;

import model.BL.hibernate.HibernateClassicUtil;
import model.BL.to.AddressesTO;
import model.BL.to.PersonTO;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.Array;
import org.jgroups.Address;
import org.jgroups.tests.ProxyTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TblPerson {
    Session session;
    Transaction transaction;

    public void insert(String name, String family,String address) {
        session = HibernateClassicUtil.getSession();
        transaction = session.beginTransaction();

        PersonTO pTO = new PersonTO();
        pTO.setName(name);
        pTO.setFamily(family);

        AddressesTO aTO1 = new AddressesTO();
        AddressesTO aTO2 = new AddressesTO();

        aTO1.setAddress("tehran : "+ address);
        aTO2.setAddress("karaj : "+ address);

        ArrayList<AddressesTO> list = new ArrayList<AddressesTO>();
        list.add(aTO1);
        list.add(aTO2);

        pTO.setAddress_list(list);

        session.saveOrUpdate(pTO);

        transaction.commit();
        session.close();
    }

    public void addAddress() {
        session = HibernateClassicUtil.getSession();
        transaction = session.beginTransaction();


        Iterator<PersonTO> iterator = session.createQuery("from PersonTO a where a.id=7").iterate();
        PersonTO pTO = iterator.next();

        AddressesTO aTO = new AddressesTO();
        aTO.setAddress("tabriz");

        pTO.getAddress_list().add(aTO);

        session.saveOrUpdate(pTO);

        transaction.commit();
        session.close();
    }

    public void select() {

        session = HibernateClassicUtil.getSession();

        Iterator<PersonTO> iterator = session.createQuery("from PersonTO").iterate();

        while (iterator.hasNext()) {
            PersonTO pTO = iterator.next();
            System.out.println(pTO.getName());
            System.out.println(pTO.getFamily());

            Iterator<AddressesTO> addressesTOIterator = pTO.getAddress_list().iterator();

            while (addressesTOIterator.hasNext()) {
                AddressesTO aTO = addressesTOIterator.next();
                System.out.println(aTO.getAddress());
            }
            System.out.println("****************************************");


        }
       session.close();

    }

    public void delete()
    {
        session = HibernateClassicUtil.getSession();
        transaction = session.beginTransaction();

        PersonTO pTo = new PersonTO();
        pTo.setId(1);



        Iterator<AddressesTO> iterator =
                session.createQuery("from AddressesTO where person_id = 1").iterate();

        ArrayList<AddressesTO> addressList = new ArrayList<AddressesTO>();

//        AddressesTO aTO;

        while (iterator.hasNext())
        {
            addressList.add(iterator.next());
        }

        pTo.setAddress_list(addressList);

        session.delete(pTo);



        transaction.commit();
        session.close();

    }



}
