package com.personnelmanager.domain.db.common.dao.impl;

import com.personnelmanager.domain.db.Auditable;
import com.personnelmanager.domain.db.common.dao.GenericBaseDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

/**
 * This the generic base class for all daos. It is annotated as a stereotype component.
 */
@Component
public abstract class GenericBaseDaoImpl extends HibernateDaoSupport implements GenericBaseDao {

    /**
     * We use autowired annotation to set session factory, so all subclasses does not need to set session Factory.
     * adding this method is important as it fixes the error where subclass is declared as stereotype of Repository
     * but Spring cannot find SessionFactory or HibernateTemplate during bean creation.
     * @param sessionFactory
     */
    @Autowired
    public void initReference(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }
    /**
	 * {@inheritDoc}
	 */
	public Auditable save(Auditable auditable) {
		HibernateTemplate ht = getHibernateTemplate();
		ht.saveOrUpdate(auditable);
        return auditable;
	}

	/**
	 * {@inheritDoc}
	 */
	public SessionFactory getHibernateSessionFactory() {
		return this.getSessionFactory();
	}


	/**
	 * {@inheritDoc}
	 */
	public abstract Auditable get(Long id);


}