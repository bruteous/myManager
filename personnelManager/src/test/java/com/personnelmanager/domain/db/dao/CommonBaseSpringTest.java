package com.personnelmanager.domain.db.dao;


import com.personnelmanager.domain.db.Auditable;
import com.personnelmanager.domain.db.common.dao.GenericDao;
import com.personnelmanager.domain.db.common.dao.impl.exception.RecordAlreadyExistsException;
import com.personnelmanager.domain.db.common.dao.impl.exception.RecordNonExistentException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by IntelliJ IDEA.
 * User: MikeChen
 * Date: Jul 15, 2010
 * Time: 11:54:08 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class CommonBaseSpringTest {
    protected ApplicationContext context = null;
    private Auditable auditable;
    protected GenericDao dao;
    protected SessionFactory sessionFactory;
    protected Session session;

    public ApplicationContext getContext() {
        return context;
    }

    public void setContext(ApplicationContext ctx) {
        this.context = ctx;
    }

    @Before
    public void setUp() throws Exception {
        if (context == null) {
            context = new ClassPathXmlApplicationContext("applicationContext.xml");
        }
        //Add this to allow Junit to test lazyInitialisation
        sessionFactory = (SessionFactory) context.getBean("sessionFactory");
        session = SessionFactoryUtils.getSession(this.sessionFactory, true);
        TransactionSynchronizationManager.bindResource(this.sessionFactory, new SessionHolder(session));
        dao = getDao();
    }

    @After
    public void tearDown() throws Exception {
        if (context != null) {
            context = null;
        }
        if (dao != null) {
            dao = null;
        }
        //Release session
        TransactionSynchronizationManager.unbindResource(this.sessionFactory);
        SessionFactoryUtils.releaseSession(this.session, this.sessionFactory);
    }

    /**
     * This test saving of a person.
     */
    @Test
    public void testSaveEditFind() {
        Auditable entry = getAuditable();
        assertTrue(checkBeforeSave(entry));
        dao.create(entry);
        assertTrue(checkAfterSave(entry));
        editData(entry);
        dao.edit(entry);
        Auditable retrievedEntry = retrieveEntry(entry);
        assertTrue(compareFindResult(entry, retrievedEntry));

    }

    @Test
    public void testSaveDuplicates() {
        try {
            Auditable entry = getAuditable();
            dao.create(entry);
            Auditable duplicateEntry = getAuditable();
            dao.create(duplicateEntry);
        } catch (RecordAlreadyExistsException e) {
            assertEquals(RecordAlreadyExistsException.MESSAGE, e.getMessage());
        }
    }

    public void testEditNonExistingRecord() {
        Auditable entry = getAuditable();
		try {
			dao.edit(entry);
		} catch (RecordNonExistentException e) {
			assertEquals(RecordNonExistentException.MESSAGE, e.getMessage());
		}
    }

    protected abstract boolean compareFindResult(Auditable entry, Auditable retrievedEntry);

    protected abstract Auditable retrieveEntry(Auditable entry);

    protected abstract void editData(Auditable entry);

    protected abstract boolean checkAfterSave(Auditable entry);

    protected abstract boolean checkBeforeSave(Auditable entry);

    public abstract Auditable getAuditable();

    public abstract GenericDao getDao();
}
