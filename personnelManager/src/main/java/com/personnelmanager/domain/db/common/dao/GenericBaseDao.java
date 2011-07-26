package com.personnelmanager.domain.db.common.dao;

import com.personnelmanager.domain.db.Auditable;
import org.hibernate.SessionFactory;

/**
 * Basic interface for saving and retrieving domain objects.
 * User: MikeChen
 * Date: Jun 30, 2010
 * Time: 9:10:15 AM
 * To change this template use File | Settings | File Templates.
 */
public interface GenericBaseDao {
    /**
     * Get a hibernate session factory.
     * @return SessionFactory
     */
    public abstract SessionFactory getHibernateSessionFactory();

    /**
     * Generic Save on Auditable
     * @param auditable
     */
    public abstract Auditable save(Auditable auditable);

    /**
     * Retrieve an Auditable record based on the id.
     * @param id
     * @return
     */
    public abstract Auditable get(Long id);


}