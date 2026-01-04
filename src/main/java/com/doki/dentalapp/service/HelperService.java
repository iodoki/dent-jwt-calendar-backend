package com.doki.dentalapp.service;

import com.doki.dentalapp.dto.ServiceNCategoryDTO;
import com.doki.dentalapp.model.*;

import java.util.List;
import java.util.UUID;

public interface HelperService {
    AllergyQuestion findQuestion(UUID questionId);
    Clinic resolveClinicFromSecurity();
    Patient findPatient(UUID patientId);
    Doctor findDoctor(UUID doctorId);
    Appointment findAppointment(UUID appointmentId);
    PatientServiceRecord findAppointmentPatientServiceRecord(Patient patient, UUID serviceId, UUID appointmentId);
    List<ServiceNCategoryDTO> processServiceNCategoriesFromPatientServiceRecord(UUID appointmentId);
    List<ServiceNCategoryDTO> getServicesNCategoriesFromAppointmentNPatientServiceRecordByAppointmentId(UUID appointmentId);

}
