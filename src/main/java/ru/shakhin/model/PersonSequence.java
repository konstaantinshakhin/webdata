package ru.shakhin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

/**
 * Created by kshahin on 10/15/2015.
 */
@Document(collection = PersonSequence.COLLECTION_NAME)
public class PersonSequence {
    public static final String COLLECTION_NAME = "personsequences";

    @Id
    private String id;
    private BigInteger sequence;

    public PersonSequence() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigInteger getSequence() {
        return sequence;
    }

    public void setSequence(BigInteger sequence) {
        this.sequence = sequence;
    }
}
