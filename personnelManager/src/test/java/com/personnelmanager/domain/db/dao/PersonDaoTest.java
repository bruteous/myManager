package com.personnelmanager.domain.db.dao;

import com.personnelmanager.domain.db.Auditable;
import com.personnelmanager.domain.db.Person;
import com.personnelmanager.domain.db.Role;
import com.personnelmanager.domain.db.common.dao.GenericDao;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: MikeChen
 * Date: Jul 13, 2010
 * Time: 4:48:51 PM
 * To change this template use File | Settings | File Templates.
 */

public class PersonDaoTest extends CommonBaseSpringTest {
    PersonDao personDao = null;

    @Test
    public void testCreatePersonWithRole() {
        Person person = PersonCreator.createTestUser1();
        Role adminRole = RoleCreator.createAdminRole();
        person.setRole(adminRole);

        personDao.create(person);
        Person retrievedPerson = personDao.getPerson(person.getPersonId());
        assertNotNull(retrievedPerson.getRole());
        assertEquals("ROLE_ADMIN", retrievedPerson.getRole().getRoleName());
    }

    @Test
    public void testEditPersonRole() {
        Person person = PersonCreator.createTestUser1();
        Role adminRole = RoleCreator.createAdminRole();
        person.setRole(adminRole);

        personDao.create(person);
        assertEquals("ROLE_ADMIN", person.getRole().getRoleName());

        //Changing Role
        Role userRole = RoleCreator.createUserRole();
        person.setRole(userRole);
        personDao.edit(person);
        Person retrievedPeron = personDao.getPerson(person.getPersonId());
        assertEquals("ROLE_USER", retrievedPeron.getRole().getRoleName());

    }

    @Test
    public void testPersonDeleteRole() {
        Person person = PersonCreator.createTestUser1();
        Role adminRole = RoleCreator.createAdminRole();
        person.setRole(adminRole);

        personDao.create(person);
        assertEquals("ROLE_ADMIN", person.getRole().getRoleName());

        person.setRole(null);
        personDao.edit(person);
        Person retrievedPeron = personDao.getPerson(person.getPersonId());
        assertNull(person.getRole());

    }
    
    @Test
    public void testGetPerson() {
        Person person = PersonCreator.createTestUser1();
        personDao.create(person);

        Person retrievedPerson = personDao.getPerson(person.getLogin());
        assertEquals(person.getPersonId().longValue(), retrievedPerson.getPersonId().longValue());
    }

    @Test
    public void testFindPerson(){
        Person person = PersonCreator.createTestUser1();
        personDao.create(person);
        Person criteria = new Person();
        criteria.setLogin(person.getLogin());
        criteria.setFirstName(person.getFirstName());
        criteria.setLastName(person.getLastName());
        List<Person> foundPerson = personDao.findPerson(criteria);
        assertTrue(foundPerson.size() == 1);
    }

    @Test
    public void testIsPersonExist() {
        Person person = PersonCreator.createTestUser1();
        personDao.create(person);
        assertTrue(personDao.isPersonExists(person.getLogin()));
        assertFalse(personDao.isPersonExists("abc"));
    }

    @Override
    protected boolean compareFindResult(Auditable entry, Auditable retrievedEntry) {
        if ((entry instanceof Person) && (retrievedEntry instanceof Person)) {
            Person person1 = (Person) entry;
            Person person2 = (Person) retrievedEntry;
            return person1.equals(person2);
        }
        return false;
    }

    @Override
    protected Auditable retrieveEntry(Auditable entry) {
        if (entry instanceof Person) {
            Person person = (Person) entry;
            return getDao().get(person.getPersonId());
        }
        return null;
    }

    @Override
    protected void editData(Auditable entry) {
        if (entry instanceof Person) {
            Person person = (Person) entry;
            person.setLogin("test1");
        }
    }

    @Override
    protected boolean checkAfterSave(Auditable entry) {
        if (entry instanceof Person) {
            Person person = (Person) entry;
            if (person.getPersonId() != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean checkBeforeSave(Auditable entry) {
        if (entry instanceof Person) {
            Person person = (Person) entry;
            if (person.getPersonId() == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Auditable getAuditable() {
        return PersonCreator.createTestUser1();
    }

    @Override
    public GenericDao getDao() {
        if (personDao == null) {
            personDao = (PersonDao) getContext().getBean("personDao");
        }
        return personDao;
    }
}
