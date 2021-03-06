package com.b.myproject.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "role", schema = "myproject")
public class RoleEntity implements AbstractEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy="uuid2")
    @Column(name = "ID", nullable = false, length = 36)
    @EqualsAndHashCode.Include
    private String id;
    @NotNull(message = "Trường bắt buộc phải nhập")
    @Column(name = "NAME_ROLE", nullable = false)
    private String nameRole;
    @Column(name = "ROLE_DESCRIPTION", length = 1000, nullable = true)
    @Size(max = 1000, message = "Không vượt quá 1000 ký tự")
    private String roleDescription;
    @Column(name = "CREATE_AT", nullable = true)
    private Timestamp createAt;
    @Column(name = "UPDATE_AT", nullable = true)
    private Timestamp updateAt;
    @Column(name = "ENABLE", nullable = true)
    private Byte enable;

}
