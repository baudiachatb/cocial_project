package com.b.myproject.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "user_detail_google")
public class UserDetailGoogleEntity implements AbstractEntity {
    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Basic
    @Email
    @Column(name = "EMAIL", nullable = false, length = 36)
    private String email;
    @Basic
    @Column(name = "FIRST_NAME", nullable = false, length = 36)
    private String firstName;
    @Basic
    @Column(name = "LAST_NAME", nullable = false, length = 36)
    private String lastName;
    @Basic
    @Column(name = "CREATE_AT", nullable = true)
    private Timestamp createAt;
    @Basic
    @Column(name = "UPDATE_AT", nullable = true)
    private Timestamp updateAt;
    @Basic
    @Column(name = "AVATAR_URL", nullable = true, length = 128)
    private String avatarUrl;
    @ManyToOne
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID")
    private UserEntity userByIdUser;

}
