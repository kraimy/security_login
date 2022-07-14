package com.example.login.entity;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
}
