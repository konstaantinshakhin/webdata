package ru.shakhin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import ru.shakhin.exceptions.SequenceException;
import ru.shakhin.model.PersonSequence;
import ru.shakhin.model.Sequence;

import java.math.BigInteger;

/**
 * Created by kshahin on 10/15/2015.
 */
@Repository
public class PersonSequenceDao {
    @Autowired
    private MongoOperations mongoOperations;

    public BigInteger getNextSequenceId(String key) {
        // получаем объект Sequence по наименованию коллекции
        Query query = new Query(Criteria.where("id").is(key));

        // увеличиваем поле sequence на единицу
        Update update = new Update();
        update.inc("sequence", 1);

        // указываем опцию, что нужно возвращать измененный объект
        FindAndModifyOptions options = new FindAndModifyOptions();
        options.returnNew(true);

        // немного магии :)
        PersonSequence psequence = mongoOperations.findAndModify(query, update, options, PersonSequence.class);

        // если не нашли такой sequence, выбросить исключение
        if(psequence == null) throw new SequenceException("Unable to get sequence for key: " + key);

        return psequence.getSequence();
    }
}
