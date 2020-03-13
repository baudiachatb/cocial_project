package com.b.myproject.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "user", schema = "myproject")
public class UserEntity implements AbstractEntity {
    @Id
    @Column(name = "ID", nullable = false, length = 36)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @EqualsAndHashCode.Include
    private String id;
    @Basic
    @Column(name = "FIRST_NAME", nullable = false, length = 30)
    private String firstName;
    @Basic
    @Column(name = "LAST_NAME", nullable = false, length = 30)
    private String lastName;
    @Basic
    @Column(name = "EMAIL", nullable = false, length = 56)
    private String email;
    @Basic
    @Column(name = "USERNAME", nullable = false, length = 30)
    private String username;
    @Basic
    @Column(name = "PASSWORD", nullable = false, length = 128)
    private String password;
    @Basic
    @Column(name = "USER_DESCRIPTION", nullable = true, length = 1000)
    private String userDescription;
    @Basic
    @Column(name = "CREATE_AT", nullable = true)
    private Timestamp createAt;
    @Basic
    @Column(name = "UPDATE_AT", nullable = true)
    private Timestamp updateAt;
    @Basic
    @Column(name = "ENABLE", nullable = true)
    private Byte enable;
}
