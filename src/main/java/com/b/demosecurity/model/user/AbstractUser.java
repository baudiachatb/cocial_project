package com.b.demosecurity.model.user;

import java.sql.Timestamp;

public abstract class AbstractUser {
    private String idRole;
    private String nameRole;
    private String roleDescription;
    private java.sql.Timestamp createAt;
    private java.sql.Timestamp updateAt;
    private long enable;

    public AbstractUser() {
    }

    public AbstractUser(String idRole, String nameRole, String roleDescription, Timestamp createAt, Timestamp updateAt, long enable) {
        this.idRole = idRole;
        this.nameRole = nameRole;
        this.roleDescription = roleDescription;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.enable = enable;
    }

    public String getIdRole() {
        return idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public long getEnable() {
        return enable;
    }

    public void setEnable(long enable) {
        this.enable = enable;
    }
}
