
package com.doki.dentalapp.model;

import com.doki.dentalapp.util.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "clinic_id")
    private UUID clinicId;  // just store the ID, not a Clinic object

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private Role role;

    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<DentRole> roles = new HashSet<>();

}
