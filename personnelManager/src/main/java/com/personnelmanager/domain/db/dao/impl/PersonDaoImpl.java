package com.personnelmanager.domain.db.dao.impl;

import com.personnelmanager.domain.db.Auditable;
import com.personnelmanager.domain.db.Person;
import com.personnelmanager.domain.db.common.dao.impl.GenericDaoImpl;
import com.personnelmanager.domain.db.dao.PersonDao;
import org.apache.commons.lang.StringUtils;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of PersonDAO, note  if we declare it as Stereotype of Repository, we require to inject SessionFactory
 * during bean creation. Best way is use Autowired annotation to achieve this.
 * User: MikeChen
 * Date: Jul 13, 2010
 * Time: 4:41:41 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class PersonDaoImpl extends GenericDaoImpl implements PersonDao {


    @Override
	protected Long getIdentifier(Auditable auditable) {
		Person person = (Person) auditable;
		return person.getPersonId();
	}


	@Override
	protected boolean checkIdentfierFieldsNotFilled(Auditable auditable) {
		Person person = (Person) auditable;
		return StringUtils.isBlank(person.getLogin());
	}

	protected boolean isExistsInDb(Auditable auditable) {
		Person person = (Person) auditable;
		Person personFromDB = (Person) this.get(person);
		if (personFromDB != null) {
			return true;
		}
		return false;
	}


	public Auditable get(Auditable searchCriteria) {
		Person person = (Person) searchCriteria;
		HibernateTemplate ht = getHibernateTemplate();
		List<Person> people = ht.find("from Person person where person.login='" + person.getLogin() + "'");
		if ((people != null) && (people.size() == 1)) {
			return people.get(0);
		} else {
			return null;
		}
	}


    /**
     * Find person based on login name, first name and last name
     * @param searchCriteria
     * @return
     */
	public List<Auditable> find(Auditable searchCriteria) {
		Person person = (Person) searchCriteria;
		HibernateTemplate ht = getHibernateTemplate();
		DetachedCriteria criteria = DetachedCriteria.forClass(Person.class);
		addCriteria(criteria, "login", person.getLogin(), false);
		addCriteria(criteria, "firstName", person.getFirstName(), true);
		addCriteria(criteria, "lastName", person.getLastName(), true);
		return getHibernateTemplate().findByCriteria(criteria);
	}






	public Auditable get(Long id) {
		HibernateTemplate ht = getHibernateTemplate();
		List<Person> people = ht.find("from Person person where person.personId=" + id.longValue() + "");
		if (people.size() == 1) {
			return people.get(0);
		} else {
			return new Person();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isPersonExists(String login) {
		Person person = new Person();
		person.setLogin(login);
		return this.isExistsInDb(person);
	}


	/**
	 * {@inheritDoc}
	 */
	public List<Person> findPerson(Person person) {
		List<Person> result = new ArrayList<Person>();
		List<Auditable> findResult = this.find(person);
		//System.out.println("Size " + findResult.size());
		for (Auditable p : findResult) {
			Person foundPerson = (Person) p;
			result.add(foundPerson);
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public Person getPerson(Long personId) {
		return (Person) this.get(personId);
	}

	/**
	 * {@inheritDoc}
	 */
	public Person getPerson(String login) {
		Person person = new Person();
		person.setLogin(login);
		return (Person) this.get(person);
	}
}
