package com.personnelmanager.service;

import com.personnelmanager.domain.db.Auditable;
import org.springframework.stereotype.Service;

/**
 * Generic Service
 * User: MikeChen
 * Date: Nov 23, 2010
 * Time: 8:59:10 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract interface GenericService {
    /**
     * Save auditables
     * @param auditable
     * @return
     */
    
    public abstract Auditable save(Auditable auditable);

    /**
     * Retrieve an auditable based on id.
     * @param id
     * @return
     */
    public abstract Auditable get(Long id);

}
