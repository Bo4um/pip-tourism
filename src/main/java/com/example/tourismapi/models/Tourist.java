package com.example.tourismapi.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tourist")
public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "touristId")
    Long touristId;

    @Column(name = "fullName")
    String fullName;

    @Column(name = "userId")
    Long userId;

    @Column(name = "groupId")
    Long groupId;

}
