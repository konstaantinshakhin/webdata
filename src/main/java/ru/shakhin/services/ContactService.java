package ru.shakhin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shakhin.dao.SequenceDao;
import ru.shakhin.dao.ContactDao;
import ru.shakhin.model.Contact;

import java.math.BigInteger;
import java.util.List;


@Service
public class ContactService {
    @Autowired private SequenceDao sequenceDao;
    @Autowired private ContactDao contactDao;

    public void add(Contact contact) {
        contact.setId(sequenceDao.getNextSequenceId(Contact.COLLECTION_NAME));
        contactDao.save(contact);
    }

    public void update(Contact contact) {
        contactDao.save(contact);
    }

    public Contact get(BigInteger id) {
        return contactDao.get(id);
    }

    public List<Contact> getAll() {
        return contactDao.getAll();
    }

    public void remove(BigInteger id) {
        contactDao.remove(id);
    }
}
