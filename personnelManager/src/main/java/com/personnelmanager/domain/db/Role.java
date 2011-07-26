package com.personnelmanager.domain.db;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: MikeChen
 * Date: Jul 16, 2010
 * Time: 5:59:35 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Role")
public class Role implements Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="roleId")
    private Long roleId;

    @Version
    @Column(name = "version")
    private Integer version;

    @Column (name="authority", unique=true)
    private String roleName;

    @Column (name="roleDescription")
    private String roleDescription;

    @OneToMany(mappedBy = "role")
    private Set<Person> persons = new HashSet<Person>();



    public Set<Person> getPersons() {
        return persons;
    }

    public void setUsers(Set<Person> persons) {
        this.persons = persons;
    }

    public Role() {
        super();
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long long1) {
        this.roleId = long1;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
