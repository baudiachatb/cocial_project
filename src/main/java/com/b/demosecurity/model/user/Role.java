package com.b.demosecurity.model.user;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String idRole;
  @Column(name = "NAME_ROLE", nullable = false, unique = true)
  private String nameRole;
  @Column(name = "ROLE_DESCRIPTION")
  private String roleDescription;
  @Column(name = "CREATE_AT")
  private java.sql.Timestamp createAt;
  @Column(name = "UPDATE_AT")
  private java.sql.Timestamp updateAt;
  @Column(name = "ENABLE")
  private long enable;


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


  public java.sql.Timestamp getCreateAt() {
    return createAt;
  }

  public void setCreateAt(java.sql.Timestamp createAt) {
    this.createAt = createAt;
  }


  public java.sql.Timestamp getUpdateAt() {
    return updateAt;
  }

  public void setUpdateAt(java.sql.Timestamp updateAt) {
    this.updateAt = updateAt;
  }


  public long getEnable() {
    return enable;
  }

  public void setEnable(long enable) {
    this.enable = enable;
  }

}
