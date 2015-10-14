package ru.shakhin.model;

/**
 * Created by kshahin on 10/14/2015.
 */

import org.springframework.data.annotation.Id;
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
    public static final String COLLECTION_NAME = "historys";

    @Id
    private BigInteger id;
    /* *******************************************************
     Если вы хотите, чтобы ID объекта была автогенерируемая
     строка (об этом я писал в посте), то опишите поле ID так:
     @Id
     private String id;
     ********************************************************* */

    private String userName;
    private String operationName;
    private String date;

    public History(){

    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}
