package com.doki.dentalapp.repository;

import com.doki.dentalapp.model.ClinicUser;
import com.doki.dentalapp.model.ClinicUserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicUserRepository extends JpaRepository<ClinicUser, ClinicUserId> {
}
