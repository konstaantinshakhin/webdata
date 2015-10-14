package ru.shakhin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ru.shakhin.model.Contact;
import ru.shakhin.model.History;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by kshahin on 10/14/2015.
 */
@Repository
public class HistoryDao {
    @Autowired
    private MongoOperations mongoOperations;

    public void save(History history) {
        mongoOperations.save(history);
    }

    public List<History> getByPersonId(BigInteger idPrson){
        return mongoOperations.find(Query.query(Criteria.where("idPrson").is(idPrson)), History.class);
    }
}
