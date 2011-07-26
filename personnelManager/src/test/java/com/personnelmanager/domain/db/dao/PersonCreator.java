package com.personnelmanager.domain.db.dao;

import com.personnelmanager.domain.db.Person;

import java.util.Calendar;

/**
 * Created by IntelliJ IDEA.
 * User: MikeChen
 * Date: Jul 15, 2010
 * Time: 12:19:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonCreator {
	/**
	 * This method will create a new user with minimal information.
	 */
	public static Person createTestUser1() {
		Person person = new Person();
		person.setSalutation("Mr");
		person.setFirstName("Test First Name");
		person.setMiddleName("Test Middle Name");
		person.setLastName("Test Last Name");
		person.setLogin("test");
        person.setPassword("test");
        Calendar dob = Calendar.getInstance();
        dob.set(1974,12,18);
		person.setDob(dob.getTime());
		return person;
	}

    public static Person createTestUser2() {
        Person person = new Person();
        person.setSalutation("Mr");
        person.setFirstName("Test2 First Name");
        person.setMiddleName("Test2 Middle Name");
        person.setLastName("Test2 Last Name");
        person.setLogin("test2");
        person.setPassword("test2");
        Calendar dob = Calendar.getInstance();
        dob.set(1974,12,18);
        person.setDob(dob.getTime());
        return person;
    }

}
