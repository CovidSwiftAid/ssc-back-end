package com.shu.ssc.entity;

import lombok.Data;

@Data
//@Entity
//@Table(name = "admin")
public class Admin {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "user_id")
    private Integer userId;

//    @Column(name = "phone_id")
    private String phoneId;

//    @Column(name = "password")
    private String password;
}