package com.cybertek.business.entity;



import com.cybertek.business.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="users")
public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private String userName;
    private String passWord;
    private Boolean enabled;
    private String phone;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    private Role role;
}
