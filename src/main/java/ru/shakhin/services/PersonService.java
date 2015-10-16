package ru.shakhin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shakhin.dao.HistoryDao;
import ru.shakhin.dao.PersonDao;
import ru.shakhin.dao.PersonSequenceDao;
import ru.shakhin.model.History;
import ru.shakhin.model.Person;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by kshahin on 10/15/2015.
 */
@Service
public class PersonService {
    @Autowired
    private PersonSequenceDao psequenceDao;
    @Autowired
    private PersonDao personDao;
    @Autowired
    private HistoryDao historyDao;

    public void add(Person person,BigInteger idManager) {
        person.setId(psequenceDao.getNextSequenceId(Person.COLLECTION_NAME));
        History history = new History();
        history.setOperationName("create");
        history.setIdPerson(person.getId());
        historyDao.save(history);
        personDao.save(person);
    }
    public void update(Person person,BigInteger idManager){
        History history = new History();
        history.setOperationName("edit");
        history.setIdPerson(person.getId());
        historyDao.save(history);
        personDao.save(person);
    }

    public Person get(BigInteger id){
        return personDao.get(id);
    }

    public void remove(Person person,BigInteger idManager){
        History history = new History();
        history.setOperationName("delete");
        history.setIdPerson(person.getId());
        historyDao.save(history);
        personDao.remove(person.getId());
    }

    public List<Person> getAll(){
        return personDao.getAll();
    }

    public List<Person> getAllNotDeleted(){
        return personDao.getNotDelete();
    }

    public List<History> getHistory(BigInteger idPerson){
        return historyDao.getHistoryByPersonId(idPerson);
    }
}
