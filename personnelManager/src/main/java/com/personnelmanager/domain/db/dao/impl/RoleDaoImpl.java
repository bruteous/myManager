package com.personnelmanager.domain.db.dao.impl;

import com.personnelmanager.domain.db.Auditable;
import com.personnelmanager.domain.db.Person;
import com.personnelmanager.domain.db.Role;
import com.personnelmanager.domain.db.common.dao.impl.GenericDaoImpl;
import com.personnelmanager.domain.db.dao.RoleDao;
import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: MikeChen
 * Date: Jul 22, 2010
 * Time: 5:54:47 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class RoleDaoImpl extends GenericDaoImpl implements RoleDao {
    public boolean isRoleExists(String roleName) {
        Role role = new Role();
        role.setRoleName(roleName);
        return this.isExistsInDb(role);
    }

    public Role getRole(Long roleId) {
        return (Role) this.get(roleId);
    }

    public Role getRole(String roleName) {
        Role role = new Role();
        role.setRoleName(roleName);
        return (Role) this.get(role);
    }

    public List<Role> getAllRoles() {
        Role searchCriteria = new Role();
        return findRoles(searchCriteria);
    }

    public List<Role> findRoles(Role searchCriteria) {
        Role role = (Role) searchCriteria;
        HibernateTemplate ht = getHibernateTemplate();
        DetachedCriteria criteria = DetachedCriteria.forClass(Role.class);
        addCriteria(criteria, "roleName", role.getRoleName(), true);
        return getHibernateTemplate().findByCriteria(criteria);
    }


    @Override
    public Auditable get(Auditable searchCriteria) {
		Role role = (Role) searchCriteria;
		HibernateTemplate ht = getHibernateTemplate();
		List<Role> roles = ht.find("from Role role where role.roleName='" + role.getRoleName() + "'");
        if ((roles != null) && (roles.size() == 1)) {
			return roles.get(0);
		} else {
			return null;
		}
    }

    @Override
    protected boolean isExistsInDb(Auditable auditable) {
        if (!(auditable instanceof Role)) {
            return false;
        }
		Role role = (Role) auditable;
		Role roleFromDB = (Role) this.get(role);
		if (roleFromDB != null) {
			return true;
		}
		return false;    }

    @Override
    protected Long getIdentifier(Auditable auditable) {
		Role role = (Role) auditable;
		return role.getRoleId();    }

    @Override
    protected boolean checkIdentfierFieldsNotFilled(Auditable auditable) {
        Role role = (Role) auditable;
        return StringUtils.isBlank(role.getRoleName());
    }

    @Override
    public List<Auditable> find(Auditable searchCriteria) {
        Role role = (Role) searchCriteria;
        HibernateTemplate ht = getHibernateTemplate();
        DetachedCriteria criteria = DetachedCriteria.forClass(Role.class);
        addCriteria(criteria, "roleName", role.getRoleName(), false);
        return getHibernateTemplate().findByCriteria(criteria);
    }

    @Override
    public Auditable get(Long id) {
        HibernateTemplate ht = getHibernateTemplate();
        List<Role> roles = (List<Role>) ht.find("from Role role where role.roleId=" + id.longValue() + "");
        if (roles.size() == 1) {
            return roles.get(0);
        } else {
            return new Person();
        }
    }
}
