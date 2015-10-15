package ru.shakhin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ru.shakhin.model.Contact;
import ru.shakhin.model.Person;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by kshahin on 10/15/2015.
 */
@Repository
public class PersonDao {
    @Autowired
    private MongoOperations mongoOperations;
    public void save(Person person) {
        person.setStatus("create");
        mongoOperations.save(person);

    }

    public Person get(BigInteger id) {
        return mongoOperations.findOne(Query.query(Criteria.where("id").is(id)), Person.class);
    }

    public List<Person> getNotDelete() {
        return mongoOperations.find(Query.query(Criteria.where("status").ne("delete")), Person.class);
    }

    public List<Person> getAll(){
        return mongoOperations.findAll(Person.class);
    }

    public void remove(BigInteger id) {
        Person person = get(id);
        person.setStatus("delete");
        //mongoOperations.remove(Query.query(Criteria.where("id").is(id)), Person.class);
    }
}
