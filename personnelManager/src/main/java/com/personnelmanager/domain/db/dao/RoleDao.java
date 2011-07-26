package com.personnelmanager.domain.db.dao;

import com.personnelmanager.domain.db.Person;
import com.personnelmanager.domain.db.Role;
import com.personnelmanager.domain.db.common.dao.GenericDao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: MikeChen
 * Date: Jul 22, 2010
 * Time: 8:59:55 AM
 * To change this template use File | Settings | File Templates.
 */
public interface RoleDao  extends GenericDao {

    /**
     * Checks to see if the role with the given role name already exists
     * @param roleName
     * @return true if the login already exists.
     */
    public boolean isRoleExists(String roleName);


    /**
     * Retrieve a role based on the roleId. If no match is found, then a blank
     * Role object is returned.
     * @param roleId
     * @return Role
     */
    public Role getRole(Long roleId);

    /**
     * Retrieve a role based on the roleName. If no match is found, then a blank Role
     * object is returned.
     * @param roleName
     * @return Role
     */
    public Role getRole(String roleName);

    /**
     * get all roles in the database.
     * @return
     */
    public List<Role> getAllRoles();


    /**
     * Find all roles matching the criteria specified in the search criteria.
     * @param criteria
     * @return
     */
    public List<Role> findRoles(Role criteria);

}
