package com.doki.dentalapp.service;

import com.doki.dentalapp.dto.DoctorDTO;
import com.doki.dentalapp.model.Doctor;
import com.doki.dentalapp.repository.ClinicRepository;
import com.doki.dentalapp.repository.DoctorRepository;
import com.doki.dentalapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final UserRepository userRepository;
    private final ClinicRepository clinicRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository,
                             UserRepository userRepository,
                             ClinicRepository clinicRepository) {
        this.doctorRepository = doctorRepository;
        this.userRepository = userRepository;
        this.clinicRepository = clinicRepository;
    }

    @Override
    public DoctorDTO createDoctor(DoctorDTO dto) {
        Doctor doctor = new Doctor();
        doctor.setSpecialty(dto.specialty());
        doctor.setUser(dto.userId() != null ? userRepository.findById(dto.userId()).orElse(null) : null);
        doctor.setClinic(clinicRepository.findById(dto.clinicId()).orElseThrow());
        doctorRepository.save(doctor);
        return mapToDTO(doctor);
    }

    @Override
    public DoctorDTO updateDoctor(UUID id, DoctorDTO dto) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow();
        doctor.setSpecialty(dto.specialty());
        if (dto.userId() != null)
            doctor.setUser(userRepository.findById(dto.userId()).orElse(null));
        doctor.setClinic(clinicRepository.findById(dto.clinicId()).orElseThrow());
        doctorRepository.save(doctor);
        return mapToDTO(doctor);
    }

    @Override
    public void deleteDoctor(UUID id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public DoctorDTO getDoctorById(UUID id) {
        return doctorRepository.findById(id).map(this::mapToDTO).orElseThrow();
    }

    @Override
    public List<DoctorDTO> getAllDoctors() {
        return doctorRepository.findAll().stream()
                .map(this::mapToDTO)
                .sorted(Comparator.comparing(DoctorDTO::firstName))
                .collect(Collectors.toList());
    }

    private DoctorDTO mapToDTO(Doctor doctor) {
        return new DoctorDTO(
                doctor.getId(),
                doctor.getUser() != null ? doctor.getUser().getId() : null,
                doctor.getClinic().getId(),
                doctor.getSpecialty(),
                doctor.getFirstName(),
                doctor.getLastName(),
                doctor.getFullName()
        );
    }
}
