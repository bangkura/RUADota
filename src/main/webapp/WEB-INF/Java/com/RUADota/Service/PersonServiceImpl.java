package com.RUADota.Service;

import com.RUADota.DAO.PersonDao;
import com.RUADota.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service("personService")
public class PersonServiceImpl implements PersonService{
    //@Autowired
    private PersonDao dao;

    //@Override
    public Person select(long id) {
        return dao.select(id);
    }

    //@Override
    public void insert(Person person) {
        dao.add(person);
    }
}
