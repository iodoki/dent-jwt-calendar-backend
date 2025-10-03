package com.example.dentalapp.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "appointment_services")
public class AppointmentService {

    @EmbeddedId
    private AppointmentServiceId id = new AppointmentServiceId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("appointmentId")
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("patientServiceId")
    @JoinColumn(name = "patient_service_id")
    private PatientService patientService;

    // getters & setters
}
