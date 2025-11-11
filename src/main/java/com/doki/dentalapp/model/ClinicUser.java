package com.doki.dentalapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clinic_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ClinicUser {

    @EmbeddedId
    private ClinicUserId id = new ClinicUserId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("clinicId")
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User User;

    // getters & setters
}
