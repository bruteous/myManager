package com.personnelmanager.domain.db.common.dao;


import com.personnelmanager.domain.db.Auditable;

import java.util.List;

/**
 * Allows Auditable objects to be created, edited and found.
 * User: MikeChen
 * Date: Jun 30, 2010
 * Time: 9:12:38 AM
 * To change this template use File | Settings | File Templates.
 */
public interface GenericDao extends GenericBaseDao {

    /**
     * Generic creation of Auditable record.
     * @param auditable
     */
    public abstract Auditable create(Auditable auditable);

    /**
     * Generic edit on an existing Auditable record.
     * @param autitable
     */
    public abstract Auditable edit(Auditable autitable);

    /**
     * Return a list of Auditable based on the search criteria.
     * @param searchCriteria
     * @return List<Auditable>
     */
    public abstract List<Auditable> find(Auditable searchCriteria);


    /**
     * Retrieve an Auditable record based on a unique search key/search key combination.
     * If no record is found, then an empty auditable record is returned.
     *
     * @param searchKey
     * @return
     */
    public abstract Auditable get(Auditable searchKey);


}