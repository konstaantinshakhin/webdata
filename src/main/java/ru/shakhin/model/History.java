package ru.shakhin.model;

/**
 * Created by kshahin on 10/14/2015.
 */

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Date: 26.03.2014
 * Time: 15:29
 *
 * @author Ruslan Molchanov (ruslanys@gmail.com)
 */
@Document(collection = History.COLLECTION_NAME)
public class History implements Serializable {
    public static final String COLLECTION_NAME = "historyes";





    private BigInteger idManager;
    private BigInteger idPerson;
    private Manager manager;
    private String operationName;
    private String date;

    public History(){

    }

    public BigInteger getId() {
        return idManager;
    }

    public void setId(BigInteger id) {
        this.idManager = id;
    }


    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigInteger getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(BigInteger idPerson) {
        this.idPerson = idPerson;
    }
}
