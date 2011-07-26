package com.personnelmanager.service.impl;

import com.personnelmanager.domain.db.Auditable;
import com.personnelmanager.domain.db.Person;
import com.personnelmanager.domain.db.dao.PersonDao;
import com.personnelmanager.domain.db.dao.impl.PersonDaoImpl;
import com.personnelmanager.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of personnel service
 * User: P669450d
 * Date: 13/08/2010
 * Time: 1:52:15 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class PersonnelServiceImpl implements PersonnelService{
    @Autowired
    private PersonDao personDao;

    public PersonDao getPersonDao() {
        return personDao;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Transactional
    public Person getPerson(String login) {
        return personDao.getPerson(login);
    }

    @Transactional
    public Person getPerson(Long personId) {
        return personDao.getPerson(personId);
    }

    @Transactional
    public boolean isPersonExists(String login) {
        return personDao.isPersonExists(login);
    }

    @Transactional
    public Auditable save(Auditable auditable) {
        return personDao.save(auditable);
    }

    @Transactional
    public Auditable get(Long id) {
        return getPerson(id);
    }


    public List<Person> findPerson(Person searchCriteria) {
        return personDao.findPerson(searchCriteria);
    }
}
