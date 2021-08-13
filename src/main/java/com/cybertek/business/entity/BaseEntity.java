package com.cybertek.business.entity;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false,updatable = false)
    private LocalDateTime insertDateTime= LocalDateTime.now();

    @Column(updatable= false)
    private Long insertUserId;

    @Column
    private LocalDateTime lastUpdateDateTime;

    @Column
    private Long lastUpdateUserId;


    private Boolean isDeleted = false;



}
