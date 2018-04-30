package com.RUADota.DAO;

import com.RUADota.Entity.Person;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

//@Component
public interface PersonDao {

    @Insert(value="insert into t_person(name, nick) values (#{name}, #{nick})")
    void add(Person person);

    @Delete(value="delete from t_person where id=#{id}")
    void delete(long id);

    @Update(value="update t_person set name=#{name}, nick=#{nick} where id=#{id}")
    void update(Person person);

    @Select(value="select * from t_person where id=#{id}")
    Person select(long id);
}
