package com.b.myproject.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "group")
public class GroupEntity implements AbstractEntity{
    @Id
    @Column(name = "ID", nullable = false, length = 36)
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Basic
    @Column(name = "NAME_GROUP", nullable = false, length = 128)
    private String nameGroup;
    @Basic
    @Size(max = 1000, message = "Không vượt quá 1000 ký tự")
    @Column(name = "GROUP_DESCRIPTION", nullable = true, length = 1000)
    private String groupDescription;
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
