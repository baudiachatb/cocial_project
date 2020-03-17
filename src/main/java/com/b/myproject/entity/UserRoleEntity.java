package com.b.myproject.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "user_role", schema = "myproject")
public class UserRoleEntity implements AbstractEntity {
    @Id
    @Column(name = "ID", nullable = false, length = 36)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @EqualsAndHashCode.Include
    private String id;
    @ManyToOne
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID", nullable = false)
    private UserEntity userByIdUser;
    @ManyToOne
    @JoinColumn(name = "ID_ROLE", referencedColumnName = "ID", nullable = false)
    private RoleEntity roleByIdRole;
}
