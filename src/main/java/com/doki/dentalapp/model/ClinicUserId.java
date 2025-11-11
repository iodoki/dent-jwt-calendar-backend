package com.doki.dentalapp.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class ClinicUserId implements Serializable {

    private UUID clinicId;
    private UUID userId;

    public ClinicUserId() {}

    public ClinicUserId(UUID clinicId, UUID userId) {
        this.clinicId = clinicId;
        this.userId = userId;
    }

    // equals & hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClinicUserId)) return false;
        ClinicUserId that = (ClinicUserId) o;
        return Objects.equals(clinicId, that.clinicId) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clinicId, userId);
    }
}

