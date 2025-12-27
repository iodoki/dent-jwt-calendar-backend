package com.doki.dentalapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "clinics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Clinic {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "address", nullable = false, length = 200)
    private String address;

    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "tax_identity", nullable = false, length = 100)
    private String taxIdentity;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinic_id") // references users.clinic_id
    private List<User> users;

    @Column(name = "left_title", nullable = false, length = 20)
    private String leftTitle;


    @Column(name = "right_title", nullable = false, length = 20)
    private String rightTitle;

}
