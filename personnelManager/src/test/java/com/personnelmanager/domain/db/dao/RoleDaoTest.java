package com.personnelmanager.domain.db.dao;

import com.personnelmanager.domain.db.Auditable;
import com.personnelmanager.domain.db.Person;
import com.personnelmanager.domain.db.Role;
import com.personnelmanager.domain.db.common.dao.GenericDao;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: MikeChen
 * Date: Jul 21, 2010
 * Time: 6:16:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class RoleDaoTest extends CommonBaseSpringTest {
    RoleDao roleDao = null;

    @Test
    public void testFindAllPersonBelongToARole() {
        Role userRole = RoleCreator.createUserRole();
        Person person1 = PersonCreator.createTestUser1();
        Person person2 = PersonCreator.createTestUser2();
        userRole.getPersons().add(person1);
        userRole.getPersons().add(person2);

        roleDao.create(userRole);
        Role retrievedRole = roleDao.getRole(userRole.getRoleId());

        assertEquals(2, retrievedRole.getPersons().size());
        for (Person person : retrievedRole.getPersons()) {
            assertTrue((person.getLogin().equalsIgnoreCase(person1.getLogin()) ||
                    person.getLogin().equalsIgnoreCase(person2.getLogin())));
        }
    }

    @Test
    public void testfindRoles() {
        Role admin = RoleCreator.createAdminRole();
        Role user = RoleCreator.createUserRole();
        roleDao.create(admin);
        roleDao.create(user);
        Role criteria = new Role();
        criteria.setRoleName("IN");
        List<Role> roles = roleDao.findRoles(criteria);
        assertEquals(1, roles.size());
        assertEquals("ROLE_ADMIN", roles.get(0).getRoleName());
    }
    @Test
    public void testGetAllRoles() {
        Role admin = RoleCreator.createAdminRole();
        Role user = RoleCreator.createUserRole();
        roleDao.create(admin);
        roleDao.create(user);
        List<Role> roles = roleDao.getAllRoles();
        assertEquals(2, roles.size());
        assertEquals("ROLE_ADMIN", roles.get(0).getRoleName());
        assertEquals("ROLE_USER", roles.get(1).getRoleName());

    }
    @Test
    public void testIsRoleExist() {
        Role role = RoleCreator.createAdminRole();
        roleDao.create(role);
        assertTrue(roleDao.isRoleExists(role.getRoleName()));
        assertFalse(roleDao.isRoleExists("abc"));
    }

    @Test
    public void testGetRoleWithRoleId() {
        Role role = RoleCreator.createAdminRole();
        roleDao.create(role);

        Role retrievedRole = roleDao.getRole(role.getRoleId());
        assertEquals(role.getRoleId().longValue(), retrievedRole.getRoleId().longValue());
    }
    
    @Test
    public void testGetRoleWithRoleName() {
        Role role = RoleCreator.createAdminRole();
        roleDao.create(role);

        Role retrievedRole = roleDao.getRole(role.getRoleName());
        assertEquals(role.getRoleId().longValue(), retrievedRole.getRoleId().longValue());
    }
    @Override
    protected boolean compareFindResult(Auditable entry, Auditable retrievedEntry) {
        boolean result;
        if ((entry instanceof Role) && (retrievedEntry instanceof Role)) {
            Role role1 = (Role) entry;
            Role role2 = (Role) retrievedEntry;
            return ((role1.getRoleName().equals(role2.getRoleName())) && 
                    (role1.getRoleDescription().equals(role2.getRoleDescription())));
        }
        return false;
    }

    @Override
    protected Auditable retrieveEntry(Auditable entry) {
        if (entry instanceof Role) {
            Role role = (Role) entry;
            return getDao().get(role.getRoleId());
        }
        return null;
    }

    @Override
    protected void editData(Auditable entry) {
        if (entry instanceof Role) {
            Role role = (Role) entry;
            role.setRoleName("test");
            role.setRoleDescription("Test Description");
        }
    }

    @Override
    protected boolean checkAfterSave(Auditable entry) {
        if (entry instanceof Role) {
            Role role = (Role) entry;
            if (role.getRoleId() != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean checkBeforeSave(Auditable entry) {
        if (entry instanceof Role) {
            Role role = (Role) entry;
            if (role.getRoleId() == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Auditable getAuditable() {
        return RoleCreator.createAdminRole();
    }

    @Override
    public GenericDao getDao() {
        if (roleDao == null) {
            roleDao = (RoleDao) getContext().getBean("roleDao");
        }
        return roleDao;
    }
}
