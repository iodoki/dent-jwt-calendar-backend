package com.doki.dentalapp.dto;
import java.util.UUID;

public class DoctorDTO {

    private UUID id;
    private UUID userId;
    private UUID clinicId;
    private String specialty;

    public DoctorDTO() {}

    public DoctorDTO(UUID id, UUID userId, UUID clinicId, String specialty) {
        this.id = id;
        this.userId = userId;
        this.clinicId = clinicId;
        this.specialty = specialty;
    }

    // Getters and Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }

    public UUID getClinicId() { return clinicId; }
    public void setClinicId(UUID clinicId) { this.clinicId = clinicId; }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
}

