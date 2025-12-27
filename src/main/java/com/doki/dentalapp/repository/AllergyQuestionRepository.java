package com.doki.dentalapp.repository;

import com.doki.dentalapp.model.AllergyQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AllergyQuestionRepository extends JpaRepository<AllergyQuestion, UUID> {
    List<AllergyQuestion> findAllByClinic_Id(UUID clinicId);
}
