package com.doki.dentalapp.exeption;

import java.util.UUID;

public class AppointmentNPatientServiceRecordNotFoundException extends RuntimeException {
    public AppointmentNPatientServiceRecordNotFoundException(UUID appointmentId, String patientName, UUID serviceId) {
        super("Appointment "+appointmentId+ " for patient name " + patientName + " with service id " + serviceId + " not found");
    }
}
