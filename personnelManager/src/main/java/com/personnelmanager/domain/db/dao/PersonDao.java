package com.personnelmanager.domain.db.dao;

import com.personnelmanager.domain.db.Person;
import com.personnelmanager.domain.db.common.dao.GenericDao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: MikeChen
 * Date: Jul 13, 2010
 * Time: 4:40:06 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PersonDao extends GenericDao {
    /**
     * Checks to see if the person with the given login already exists
     * @param login
     * @return true if the login already exists.
     */
    public boolean isPersonExists(String login);

    /**
     * Search the database for all people that matches the search criteria.
     * @param searchCriteria
     * @return List<Person> matching the search criteria.
     */
    public List<Person> findPerson(Person searchCriteria);

    /**
     * Retrieve a person based on the personId. If no match is found, then a blank
     * Person object is returned.
     * @param personId
     * @return Person
     */
    public Person getPerson(Long personId);

    /**
     * Retrieve a person based on the login. If no match is found, then a blank Person
     * object is returned.
     * @param login
     * @return Person
     */
    public Person getPerson(String login);

}
