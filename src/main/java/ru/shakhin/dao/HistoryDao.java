package ru.shakhin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ru.shakhin.model.Contact;
import ru.shakhin.model.History;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by kshahin on 10/14/2015.
 */
@Repository
public class HistoryDao {
    @Autowired
    private MongoOperations mongoOperations;

    public void save(History history) {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date today = new Date();
        String sdate = df.format(today);
        history.setDate(sdate);
        mongoOperations.save(history);
    }

    public List<History> getHistoryByManagerId(BigInteger idManager){
        return mongoOperations.find(Query.query(Criteria.where("idManager").is(idManager)), History.class);
    }
}
