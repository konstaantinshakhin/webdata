package ru.shakhin.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.shakhin.dao.HistoryDao;
import ru.shakhin.dao.PersonDao;
import ru.shakhin.dao.SequenceDao;
import ru.shakhin.model.Contact;
import ru.shakhin.model.History;
import ru.shakhin.model.Person;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by kshahin on 10/15/2015.
 */
public class PersonService {
    @Autowired
    private SequenceDao sequenceDao;
    @Autowired
    private PersonDao personDao;
    @Autowired
    private HistoryDao historyDao;

    public void add(Person person,BigInteger idManager) {
        person.setId(sequenceDao.getNextSequenceId(Person.COLLECTION_NAME));
        History history = new History();
        history.setOperationName("create");
        history.setId(idManager);
        historyDao.save(history);
        personDao.save(person);
    }
    public void update(Person person,BigInteger idManager){
        History history = new History();
        history.setOperationName("edit");
        history.setId(idManager);
        historyDao.save(history);
        personDao.save(person);
    }

    public Person get(BigInteger id){
        return personDao.get(id);
    }

    public void remove(BigInteger id,BigInteger idManager){
        History history = new History();
        history.setOperationName("delete");
        history.setId(idManager);
        historyDao.save(history);
        personDao.remove(id);
    }

    public List<Person> getAll(){
        return personDao.getAll();
    }

    public List<Person> getAllNotDeleted(){
        return personDao.getNotDelete();
    }

    public List<History> getHistory(BigInteger idManager){
        return historyDao.getHistoryByManagerId(idManager);
    }
}
