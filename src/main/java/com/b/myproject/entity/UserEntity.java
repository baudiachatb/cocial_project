package com.b.myproject.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    @Size(min = 1, max = 30, message = "Nhập từ 1 đến 30 ký tự")
    @NotNull(message = "Trường bắt buộc phải nhập")
    @Column(name = "FIRST_NAME", nullable = false, length = 30)
    private String firstName;
    @Basic
    @Size(min = 1, max = 30, message = "Nhập từ 1 đến 30 ký tự")
    @NotNull(message = "Trường bắt buộc phải nhập")
    @Column(name = "LAST_NAME", nullable = false, length = 30)
    private String lastName;
    @Basic
    @NotNull(message = "Trường bắt buộc phải nhập")
    @Email(message = "Nhập đúng định dạng email")
    @Column(name = "EMAIL", nullable = false, length = 56)
    private String email;
    @Basic
    @NotNull(message = "Trường bắt buộc phải nhập")
    @Pattern(regexp = "^(?=.{6,30}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$")
    @Size(min = 6, max = 30, message = "Nhập từ 6 đến 30 ký tự")
    @Column(name = "USERNAME", nullable = false, length = 30)
    private String username;
    @Basic
    @NotNull(message = "Trường bắt buộc phải nhập")
    @Column(name = "PASSWORD", nullable = false, length = 128)
    private String password;
    @Basic
    @Size(max = 1000, message = "Không vượt quá 1000 ký tự")
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
