package com.personnelmanager.domain.db.common.dao.impl;


import com.personnelmanager.domain.db.Auditable;
import com.personnelmanager.domain.db.common.dao.GenericDao;
import com.personnelmanager.domain.db.common.dao.impl.exception.RecordAlreadyExistsException;
import com.personnelmanager.domain.db.common.dao.impl.exception.RecordNonExistentException;
import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: MikeChen
 * Date: Jun 30, 2010
 * Time: 6:02:22 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class GenericDaoImpl extends GenericBaseDaoImpl implements GenericDao {
    /**
	 * {@inheritDoc}
	 */
	public Auditable create(Auditable auditable) {
		if (isNotExist(auditable)) {
			this.save(auditable);
            return auditable;
		} else {
			throw new RecordAlreadyExistsException();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Auditable edit(Auditable auditable) {
		if (!this.isNotExist(auditable)) {
			this.save(auditable);
            return auditable;
		} else {
			throw new RecordNonExistentException();
		}
	}


	/**
	 * {@inheritDoc}
	 */
	public abstract Auditable get(Auditable searchKey);
	/**
	 * {@inheritDoc}
	 */
	protected abstract boolean isExistsInDb(Auditable auditable);
	/**
	 * {@inheritDoc}
	 */
	protected boolean isNotExist(Auditable auditable) {
		if (getIdentifier(auditable) == null) {
			if (checkIdentfierFieldsNotFilled(auditable)) {
				return true;
			} else {
				if (this.isExistsInDb(auditable)) {
					return false;
				} else {
					return true;
				}
			}
		} else {
			return false;
		}
	}

	/**
	 * Used by the subclass to return a specific identifier used by isNotExist method.
	 * @param auditable
	 * @return id of the auditable;
	 */
	protected abstract Long getIdentifier(Auditable auditable);

	/**
	 * Used by the subclass to test if all identifier fields are not filled. This is used by isNotExist method.
	 * @param auditable
	 * @return true if all identifier fields are not filled.
	 */
	protected abstract boolean checkIdentfierFieldsNotFilled(Auditable auditable);

	/**
	 * {@inheritDoc}
	 */
	public abstract List<Auditable> find(Auditable searchCriteria);

	protected void addCriteria(DetachedCriteria criteria, String field, String value, boolean isLike) {
		System.out.println(field + ":" + value);
		if (StringUtils.isNotBlank(value)) {
			if (isLike) {
				criteria.add(Restrictions.like(field, "%"+value+"%"));
			} else {
				criteria.add(Restrictions.eq(field, value));
			}
		}
	}
}