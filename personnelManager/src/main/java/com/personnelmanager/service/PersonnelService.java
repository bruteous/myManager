package com.personnelmanager.service;

import com.personnelmanager.domain.db.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Services declaration
 * User: P669450d
 * Date: 13/08/2010
 * Time: 1:51:48 PM
 * To change this template use File | Settings | File Templates.
 */

public interface PersonnelService extends GenericService {
    /**
     * Get person based on login name, if person does not exist in db, then null is returned.
     * @param login
     * @return
     */

    public Person getPerson(String login);

    /**
     * Get Person based on personId, if person does not exist, then null is returned.
     * @param personId
     * @return
     */

    public Person getPerson(Long personId);

    /**
     * Check to see if person exists.
     * @param login
     * @return
     */
    public boolean isPersonExists(String login);

    /**
     * Find all people that matches the search criteria.
     * @param searchCriteria
     * @return
     */
    public List<Person> findPerson(Person searchCriteria);
}
