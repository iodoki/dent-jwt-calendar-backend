package com.doki.dentalapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "appointment_services")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AppointmentPatientServiceRecord {

    @EmbeddedId
    private AppointmentPatientServiceRecordId id = new AppointmentPatientServiceRecordId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("appointmentId")
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("patientServiceId")
    @JoinColumn(name = "patient_service_id")
    private PatientServiceRecord patientServiceRecord;

    // getters & setters
}
