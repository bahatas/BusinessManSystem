package com.cybertek.business.dto;


import com.cybertek.business.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long Id;


    private String firstName;
    private String lastName;
    private String userName;
    private String passWord;
    private String confirmPassword;
    private boolean enables;
    private String phone;
    private RoleDTO role;
    private Gender gender;


}
