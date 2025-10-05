package com.example.dentalapp.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;
import java.util.Objects;

@Embeddable
public class AppointmentPatientServiceRecordId implements Serializable {

    private UUID appointmentId;
    private UUID patientServiceId;

    public AppointmentPatientServiceRecordId() {}

    public AppointmentPatientServiceRecordId(UUID appointmentId, UUID patientServiceId) {
        this.appointmentId = appointmentId;
        this.patientServiceId = patientServiceId;
    }

    // equals & hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppointmentPatientServiceRecordId)) return false;
        AppointmentPatientServiceRecordId that = (AppointmentPatientServiceRecordId) o;
        return Objects.equals(appointmentId, that.appointmentId) &&
                Objects.equals(patientServiceId, that.patientServiceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentId, patientServiceId);
    }
}

