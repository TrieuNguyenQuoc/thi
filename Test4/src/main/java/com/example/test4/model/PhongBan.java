package com.example.test4.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Phongbans")
public class PhongBan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String namePhong;
}
