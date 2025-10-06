package com.longbow.doctor_service.serviceImp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.longbow.doctor_service.dto.DoctorDto;
import com.longbow.doctor_service.entity.Doctor;
import com.longbow.doctor_service.mapping.ModelMapping;
import com.longbow.doctor_service.repository.DoctorRepository;
import com.longbow.doctor_service.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DoctorServiceImp implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private ModelMapping modelMapping;
    @Autowired
    private ObjectMapper objectMapper;

    public PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
    @Override
    public DoctorDto createDoctor(DoctorDto doctorDto) {
        Optional<Doctor> optionalDoctor = doctorRepository.findByEmail(doctorDto.getEmail());
        if (optionalDoctor.isPresent()) {
            throw new RuntimeException("Doctor with this email already exists. Please login instead.");
        }

        Doctor doctor = modelMapping.dtoToEntity(doctorDto);
        doctor.setPassword(passwordEncoder.encode(doctorDto.getPassword()));

        Doctor savedDoctor = doctorRepository.save(doctor);
        return modelMapping.entityToDto(savedDoctor);
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<Doctor> doctors=doctorRepository.findAll();
        return doctors.stream().map(modelMapping::entityToDto).toList();
    }

    @Override
    public DoctorDto getByIdDoctor(Integer id) {
        Doctor doctor=doctorRepository.findById(id).orElseThrow(()->new RuntimeException("Doctor not found with ID: " + id));
        return null;
    }

    @Override
    public DoctorDto updateDoctorById(Integer id, DoctorDto doctorDto) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + id));

        // Encode password if provided
        if (doctorDto.getPassword() != null && !doctorDto.getPassword().isBlank()) {
            doctorDto.setPassword(passwordEncoder.encode(doctorDto.getPassword()));
        } else {
            doctorDto.setPassword(doctor.getPassword()); // keep existing password
        }

        modelMapping.getModelMapper().map(doctorDto, doctor);

        Doctor updatedDoctor = doctorRepository.save(doctor);

        DoctorDto updatedDto = modelMapping.entityToDto(updatedDoctor);
        updatedDto.setPassword(null); // hide password
        return updatedDto;
    }

    @Override
    public DoctorDto doctorByIdUpdate(Integer id, Map<String, Object> updates) {
        // 1️⃣ Fetch entity
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + id));

        // 2️⃣ Convert entity to DTO
        DoctorDto doctorDto = modelMapping.entityToDto(doctor);

        // 3️⃣ Convert Map -> DTO dynamically
        DoctorDto updatesDto = objectMapper.convertValue(updates, DoctorDto.class);

        // 4️⃣ Handle password encoding explicitly
        if (updatesDto.getPassword() != null) {
            updatesDto.setPassword(passwordEncoder.encode(updatesDto.getPassword()));
        }

        // 5️⃣ Merge updates DTO into existing DTO using ModelMapper
        modelMapping.getModelMapper().map(updatesDto, doctorDto);

        // 6️⃣ Map updated DTO back to entity
        modelMapping.getModelMapper().map(doctorDto, doctor);

        // 7️⃣ Save entity
        Doctor updatedDoctor = doctorRepository.save(doctor);

        // 8️⃣ Return DTO without password
        DoctorDto updatedDto = modelMapping.entityToDto(updatedDoctor);
        updatedDto.setPassword(null);
        return updatedDto;
    }


    @Override
    public void deleteByIdDoctor(Integer id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + id));
        doctorRepository.delete(doctor);
    }


}
