package com.personnelmanager.domain.db.dao;

import com.personnelmanager.domain.db.Role;

/**
 * Created by IntelliJ IDEA.
 * User: MikeChen
 * Date: Jul 21, 2010
 * Time: 6:17:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class RoleCreator {
    public static Role createAdminRole() {
        Role role = new Role();
        role.setRoleName("ROLE_ADMIN");
        role.setRoleDescription("Administrator");
        return role;
    }

    public static Role createUserRole() {
        Role role = new Role();
        role.setRoleName("ROLE_USER");
        role.setRoleDescription("User");
        return role;
    }
}
