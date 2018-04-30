package com.RUADota.Service;

import com.RUADota.Entity.Person;

public interface PersonService {
    Person select(long id);
    void insert(Person person);
}
