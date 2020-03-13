package com.b.myproject.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "role", schema = "myproject")
public class RoleEntity implements AbstractEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy="uuid2")
    @EqualsAndHashCode.Include
    private String id;
    @NotNull(message = "trường này không được để trống")
    @Column(name = "NAME_ROLE", nullable = false)
    private String nameRole;
    @Column(name = "ROLE_DESCRIPTION", length = 1000, nullable = true)
    private String roleDescription;
    @Column(name = "CREATE_AT", nullable = true)
    private Timestamp createAt;
    @Column(name = "UPDATE_AT", nullable = true)
    private Timestamp updateAt;
    @Column(name = "ENABLE", nullable = true)
    private Byte enable;

}
